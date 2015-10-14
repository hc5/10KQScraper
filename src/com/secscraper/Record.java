package com.secscraper;

public class Record {
	String type;
	String accession;
	@Override
	public String toString() {
		return "Record [type=" + type + ", accession=" + accession + ", date=" + date + "]";
	}
	String date;
	String balanceSheet;
}
