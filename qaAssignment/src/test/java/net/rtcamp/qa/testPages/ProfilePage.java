package net.rtcamp.qa.testPages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.rtcamp.qa.testBase.TestBase;

public class ProfilePage extends TestBase {

	private WebDriverWait wait;

	// ---------------- Page WebElements -------------------------
	private WebElement profileLinkElement() {
		return driver.findElement(By.xpath(eLocators.getProperty("profileLinkLocator")));
	}

	private WebElement changeAvatarLinkElement() {
		return driver.findElement(By.id(eLocators.getProperty("changeAvatarLinkLocator")));
	}

	private WebElement uploadProfileAvatarInputElement() {
		return driver.findElement(By.id(eLocators.getProperty("uploadProfileAvatarInputLocator")));
	}

	private WebElement profileAvatarCropElement() {
		return driver.findElement(By.xpath(eLocators.getProperty("profileAvatarCropLocator")));
	}

	private WebElement cropSubmitButtonElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("cropSubmitButtonLocator")));
	}

	// --------------- Page Methods ------------------------------

	public void gotoProfilePage(String fileName) throws AWTException, InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(profileLinkElement()).click().build().perform();

		changeAvatarLinkElement().click();

		uploadProfileAvatarInputElement().click();
		Thread.sleep(1000);
		robotUpload(System.getProperty("user.dir") + "\\src\\test\\resources\\raw\\" + fileName);

		String newStyle = "position: absolute; z-index: 600; width: 386px; height: 386px; top: 12px; left: 22px; display: block";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', '" + newStyle + "')", profileAvatarCropElement());

		cropSubmitButtonElement().click();

	}

}
