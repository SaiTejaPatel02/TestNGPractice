package com.TestNGPractice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependsOnMethodsTestNG {

	static String trackingNumber = null;
	  
	@Ignore
	@Test
	public void CreateShipment() throws Exception
	{
		//System.out.println(5/0);
		System.out.println("CreateShipment");
		trackingNumber = "ABC12YH";
	}
	
	///-- if "alwaysRun=true" is mentioned,even then if the dependent method is failed,test will run 
	
	@Test( dependsOnMethods = {"CreateShipment"},ignoreMissingDependencies = true)
	public void TrackShipment() throws Exception
	{
		if(trackingNumber !=null)
			System.out.println("TrackShipment");
		else
			throw new Exception("invalid tracking number");
	}
	
	@Test( priority=3,dependsOnMethods = {"CreateShipment","TrackShipment"},ignoreMissingDependencies = true)
	public void CancelShipment() throws Exception
	{
		if(trackingNumber !=null)
			System.out.println("CancelShipment");
		else
			throw new Exception("invalid tracking number");
	}
	
}
