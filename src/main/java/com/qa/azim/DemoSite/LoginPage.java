package com.qa.azim.DemoSite;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement usernameField;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passwordField;
	
	public void enterDetails(Actions action) {

		usernameField.sendKeys("Smart");
		passwordField.sendKeys("admin");
		action.sendKeys(Keys.TAB).perform();

		action.sendKeys(Keys.ENTER).perform();
}
}
