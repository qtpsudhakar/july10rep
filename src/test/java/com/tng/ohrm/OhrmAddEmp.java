package com.tng.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OhrmAddEmp {
	WebDriver driver;

	@BeforeClass
	public void OpenApplication() {
		
		System.out.println("this is my first change");
		System.out.println("this is my second change");
		
		// specify driver
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");

		// open chrome
		driver = new ChromeDriver();

		// specify the page load time
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		// findelement timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// maximize browser
		driver.manage().window().maximize();

		// navigate url
		driver.get("http://opensource.demo.orangehrmlive.com/");

	}

	@Test
	public void login() {
		// enter text on username textbox
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("admin");

		// enter text on password
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin");

		// click on login button
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

	}

	@Test(dependsOnMethods="login",alwaysRun=true)
	public void addEmployee() {
		// click on pim link
		driver.findElement(By.xpath("//a[.='PIM']")).click();

		// click on Add Employee link
		driver.findElement(By.xpath("//a[contains(text(),'Add Em')]")).click();

		// enter text on first name
		driver.findElement(By.cssSelector("input#firstName")).sendKeys("selenium");

		// enter text on last name
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("hq");

		// click on save button
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}
}
