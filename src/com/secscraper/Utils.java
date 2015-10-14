package com.secscraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static String GetBalanceSheet(Record r) {
		return "";
	}
	public static List<Company> ScrapeQuarterly(String url) throws IOException {
		ArrayList<Company> companies = new ArrayList<>();
		URL u = new URL(url);
		URLConnection uconn = (URLConnection) u.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(uconn.getInputStream()));
		String buff;
		int[] widths = new int[4];
		String curCompanyName = "";
		Company curCompany = null;
		boolean started = false;
		while ((buff = br.readLine()) != null) {
			if (buff.startsWith("Company Name")) {
				widths[0] = buff.indexOf("Form Type");
				widths[1] = buff.indexOf("CIK");
				widths[2] = buff.indexOf("Date Filed");
				widths[3] = buff.indexOf("File Name");
				started = true;
				continue;
			}
			if (!started) {
				continue;
			}
			if (!curCompanyName.equals(buff.substring(0, widths[0]).trim())) {
				if (curCompany != null && curCompany.Records.size() > 0) {
					companies.add(curCompany);
				}
				curCompanyName = buff.substring(0, widths[0]).trim();
				curCompany = new Company();
				curCompany.FullName = buff.substring(0, widths[0]).trim();
				curCompany.CIK = buff.substring(widths[1], widths[2]).trim();
			}
			if (buff.substring(widths[0], widths[1]).trim().contains("10-")) {
				Record r = new Record();
				r.date = buff.substring(widths[2], widths[3]).trim();
				String raw = buff.substring(widths[3]).trim();
				raw = raw.split("/")[3];
				raw = raw.split("\\.")[0];
				raw = raw.replaceAll("-", "");
				r.accession = raw;
				r.type = buff.substring(widths[0], widths[1]).trim();
				curCompany.Records.add(r);
			}
		}
		companies.add(curCompany);
		return companies;
	}
}
