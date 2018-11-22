package com.qa.azim.DemoSite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegistrationTest {

	WebDriver driver = null;
	Actions action = null;
	ExtentReports report = null;
	ExtentTest test = null;
	
	@Before
	public void setup() {
		//create Driver object for Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		
		driver = new ChromeDriver();		
		action = new Actions(driver);
		
		report = new ExtentReports("C:\\Users\\Azim\\Desktop\\report\\" + "DemoReport.html", true);

		test = report.startTest("Demo Site Registration");
		
		
		driver.get("http://thedemosite.co.uk/");
}
	
	@Test
	public void regTest() {
		
		LandingPage page = PageFactory.initElements(driver, LandingPage.class);
		test.log(LogStatus.INFO, "Clicking Registration Button");
		page.clickReg();
		
		RegistrationPage regPage = PageFactory.initElements(driver, RegistrationPage.class);
		test.log(LogStatus.INFO, "Filling out the form");
		regPage.fillOutForm(action);

		CreateAccountSuccess successPage = PageFactory.initElements(driver, CreateAccountSuccess.class);
		
		successPage.clickLink();

		LoginPage signInPage = PageFactory.initElements(driver, LoginPage.class);
		test.log(LogStatus.INFO, "Attempting to sign in with new credentials");
		signInPage.enterDetails(action);
		
		report.endTest(test);
		report.flush();
	}
	
	
	@After
	public void teardown() {
		driver.close();
	}
}
