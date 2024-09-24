package com.TestNGPractice;

import org.testng.annotations.Test;

public class DataProviderSeperateClassTestNG {

	@Test(dataProvider = "dp2", dataProviderClass = DataProviderSupplierTestNG.class)
	public void TestLogin(String s) throws Exception {
		System.out.println(s);
	}
	
}
