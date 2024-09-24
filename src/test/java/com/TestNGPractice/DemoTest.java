package com.TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {

	@Test
	public void TestGoogle() throws Exception {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.google.com/");
		 driver.findElement(By.className("gLFyf")).sendKeys("Test",Keys.ENTER);
		 Thread.sleep(2000);
		 driver.quit();
		
	}
}
