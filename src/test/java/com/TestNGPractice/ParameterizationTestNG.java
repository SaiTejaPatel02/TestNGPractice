package com.TestNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterizationTestNG {
	
	
	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void InitialiseBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browsername is invalid");
			break;
		}
		driver.manage().window().maximize();
	}

	@Parameters("sleepTime")
	@AfterTest
	public void TearDown(Long sleepTime) throws Exception {
		System.out.println(sleepTime);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sleepTime));
		//Thread.sleep(sleepTime);
		driver.quit();
	}

	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
		driver.get(url);
	}

	@Parameters({"username", "password"})
	@Test
	public void EnterLoginDetails(String username, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.xpath("//span[.='My Info']")).click();
	}

	@Test
	public void VerifyMyInfo() {
		boolean actualValue = driver.findElement(By.id("employee-details")).isDisplayed();
		Assert.assertTrue(actualValue);
	}

	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.name("oxd-userdropdown-name"));
		Assert.assertTrue(element.isDisplayed());
		Assert.assertTrue(element.getText().startsWith("Welcome"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText().startsWith("Welcome"));
	}

}
