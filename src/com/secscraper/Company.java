package com.secscraper;

import java.util.ArrayList;
import java.util.List;

public class Company {
	@Override
	public String toString() {
		return "Company [FullName=" + FullName + ", Symbol=" + Symbol + ", CIK=" + CIK + ", Records=" + Records + "]";
	}
	public String FullName;
	public String Symbol;
	public String CIK;
	public List<Record> Records;
	public Company() {
		Records = new ArrayList<>();
	}
}
