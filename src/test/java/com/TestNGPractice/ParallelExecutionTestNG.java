package com.TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionTestNG {

	@Test(dataProvider = "loginData")
	public void TestLogin(String userName, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}
	
//--Create an XML File and mention the Thread count at suite level(data-provided-thread-count="2"	
//--The Thread count will pass 2 set at a time by mentioning the count
	
	@DataProvider(parallel = true)
	public Object[][] loginData() {
		Object[][] data = new Object[6][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "Admin";
		data[1][1] = "test123";
		
		data[2][0] = "Test";
		data[2][1] = "admin123";
		
		data[3][0] = "Prod";
		data[3][1] = "test123";
		
		data[4][0] = "Stage";
		data[4][1] = "admin123";
		
		data[5][0] = "L6";
		data[5][1] = "test123";
		return data;
	}
	
}
