package com.secscraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Scraper extends Thread {

	

	public static void main(String[] args) {
		try {
			Utils.ScrapeQuarterly("ftp://ftp.sec.gov/edgar/full-index/2015/QTR3/company.idx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
