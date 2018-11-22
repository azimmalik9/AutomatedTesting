package com.qa.azim.DemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountSuccess {

		@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
		private WebElement signInLink;

		public void clickLink() {

			signInLink.click();

		}
}
