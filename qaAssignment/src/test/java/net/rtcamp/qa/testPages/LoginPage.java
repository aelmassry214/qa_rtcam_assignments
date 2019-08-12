package net.rtcamp.qa.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.rtcamp.qa.testBase.TestBase;

public class LoginPage extends TestBase {

	public WebElement usernameElement() {
		return driver.findElement(By.id("user_login"));
	}

	public WebElement passwordElement() {
		return driver.findElement(By.id("user_pass"));
	}

	public WebElement loginButtonElement() {
		return driver.findElement(By.id("wp-submit"));
	}

	public void Login(String username, String password) {
		usernameElement().sendKeys(username);
		passwordElement().sendKeys(password);
		loginButtonElement().click();
	}

}
