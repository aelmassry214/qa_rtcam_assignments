package net.rtcamp.qa.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.rtcamp.qa.testBase.TestBase;

public class ActivityPage extends TestBase {

	// ------------ WebElements ---------------------
	private WebElement logoutLinkElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("logoutLinkLocator")));
	}

	private WebElement newPostTextAreaElement() {
		return driver.findElement(By.xpath((eLocators.getProperty("newPostTextAreaLocator"))));
	}

	private WebElement mediaButtonElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("mediaButtonLocator")));
	}

	private WebElement privacySelectOptionElement() {
		return driver.findElement(By.id(eLocators.getProperty("privacySelectOptionLocator")));
	}

	private WebElement updatePostButtonElement() {
		return driver.findElement(By.id(eLocators.getProperty("updatePostButton")));
	}

	// -------------- Action Methods -------------------
	public void logout() {
		logoutLinkElement().click();
	}

	public void writeNewPostText() {
		newPostTextAreaElement().click();
		newPostTextAreaElement().sendKeys("Beleive in yourself.");
	}

	public void addMedia(String fileName) {
		mediaButtonElement().sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\raw\\" + fileName);
	}

	public void selectPrivacy() {
		Select selectPrivacy = new Select(privacySelectOptionElement());
		selectPrivacy.selectByVisibleText(eLocators.getProperty("selectPrivate"));
	}

	public void updatePost() {
		updatePostButtonElement().click();
	}

}
