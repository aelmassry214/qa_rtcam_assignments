package net.rtcamp.qa.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.rtcamp.qa.testBase.TestBase;

public class HomePage extends TestBase {

	private WebElement loginLinkElement() {
		return driver.findElement(By.cssSelector("#wp-admin-bar-bp-login a"));
	}

	public void gotoLoginPage() {
		loginLinkElement().click();
	}

}
