package com.TestNGPractice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAndSoftAssertionsTestNG {
	
	
//HardAssert--Execution will be stopped if the assertions Fails
	
		@Test
		public void TestGoogle() throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
			String expectedTitle = "HYR Tutorials - Google Searchhh";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle, "Title is mismatched");
			Thread.sleep(5000);
			driver.quit();
		}

		
//SoftAssert--Execution will be continued even if the assertion is failed and exception is thrown at the end of the execution
		@Test
		public void TestFacebook() throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			//driver.findElement(By.name("email")).sendKeys("HYR Tutorials"/*, Keys.ENTER*/);
			driver.findElement(By.name("login")).click();
			Thread.sleep(5000);
			
			SoftAssert softAssert = new SoftAssert();
			//Title Assertion
			String actualTitle = driver.getTitle();
			String expectedTitle = "Log in to Facebook";
			softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
			
			//URL Assertion
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://www.facebook.com/";
			softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");
			
			//Text Assertion
			String actualText = driver.findElement(By.name("email")).getAttribute("value");
			String expectedText = "";
			softAssert.assertEquals(actualText, expectedText, "Username text is mismatched");
			
			//Border Assertion
			String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
			String expectedBorder = "1px solid rgb(240, 40, 73)";
			softAssert.assertEquals(actualBorder, expectedBorder, "Username border is mismatched");
			
			//ErrorMessage Assertion
			String actualErrorMessage = driver.findElement(By.xpath("//div[@id='email_container']/div[last()]")).getText();
			String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Username error message is mismatched");
			
			driver.quit();
			softAssert.assertAll();
		}
}
