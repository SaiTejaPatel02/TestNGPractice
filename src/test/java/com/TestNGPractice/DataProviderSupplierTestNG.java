package com.TestNGPractice;

import org.testng.annotations.DataProvider;

public class DataProviderSupplierTestNG {

	@DataProvider
	public String[] dp1() {
		String[] data = new String[] {
				"Ram",
				"Laxman",
				"Raju",
				"Rani"
		};
		return data;
	}
	
	@DataProvider
	public String[] dp2() {
		String[] data = new String[] {
				"Sai",
				"Teju",
				"Naveen",
				"Kumar"
		};
		return data;
	}
	
}
