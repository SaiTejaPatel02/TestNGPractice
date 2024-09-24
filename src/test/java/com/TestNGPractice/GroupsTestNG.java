package com.TestNGPractice;

import org.testng.annotations.Test;

//create an XML file to see the groups executions as individual groups will be executed
@Test(groups="all")
public class GroupsTestNG {

	
	@Test (groups= {"smoke","sanity","windows.smoke"})
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(groups= {"regression","sanity", "windows.sanity", "ios.sanity"})
	public void test2() {
		System.out.println("test2");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}
}
