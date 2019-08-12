package net.rtcamp.qa.testPages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.rtcamp.qa.testBase.TestBase;

public class MediaAlbumPage extends TestBase {

	private WebDriverWait wait;

	// ------------------- Page WebElements ------------------------

	private WebElement optionsLinkElement() {
		return driver.findElement(By.id(eLocators.getProperty("optionsLinkLocator")));
	}

	private WebElement newAlbumElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("newAlbumLocator")));

	}

	private WebElement newAlbumNameElement() {
		return driver.findElement(By.id(eLocators.getProperty("newAlbumNameLocator")));
	}

	private WebElement createAlbumButtonElement() {
		return driver.findElement(By.id(eLocators.getProperty("createAlbumButtonLocator")));
	}

	private WebElement createAlbumPopupCloseElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("newAlbumPopupCloseLocator")));
	}

	private WebElement targetAlbumElement() {
		return driver.findElement(
				By.xpath(eLocators.getProperty("targetAlbumLocator") + eLocators.getProperty("newAlbumName") + "']"));
	}

	private WebElement uploadToAlbumLinkElement() {
		return driver.findElement(By.id(eLocators.getProperty("uploadToAlbumLinkLocator")));
	}

	private WebElement uploadFilesLinkElement() {
		return driver.findElement(By.xpath(eLocators.getProperty("uploadFilesInputLocator")));
	}

	private WebElement startUploadButtonElement() {
		return driver.findElement(By.xpath(eLocators.getProperty("startUploadButtonLocator")));
	}

	private WebElement targetMediaElement() {
		return driver.findElement(By.xpath(eLocators.getProperty("targetMediaLocator")));
	}

	private WebElement temporaryUploadFileListElement() {
		return driver.findElement(By.id(eLocators.getProperty("temporaryFilesUploadListLocator")));

	}

	private List<WebElement> likeLinkElement() {
		return driver.findElements(By.xpath(eLocators.getProperty("likeLinkLocator")));
	}

	private WebElement hoverToImageElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("hoverToImageLocator")));
	}

	private WebElement imageCloseButtonElement() {
		return driver.findElement(By.cssSelector(eLocators.getProperty("imageCloseButtonLocator")));
	}

	private WebElement likesElement() {
		return driver.findElement(By.id(eLocators.getProperty("likesLocator")));
	}

	private WebElement targetImageInLikesElement() {
		return driver.findElement(By.xpath(eLocators.getProperty("targetImageInLikesLocator")));
	}

	// ------------------- Page Methods ------------------------

	public void createNewAlbum() {

		optionsLinkElement().click();
		newAlbumElement().click();
		newAlbumNameElement().sendKeys(eLocators.getProperty("newAlbumName"));
		createAlbumButtonElement().click();
		createAlbumPopupCloseElement().click();

	}

	public void editAlbum() {

		targetAlbumElement().click();
		uploadToAlbumLinkElement().click();

	}

	public void uploadfiles(String fileName) throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(uploadFilesLinkElement()));

		uploadFilesLinkElement().click();

		Thread.sleep(500);

		robotUpload(System.getProperty("user.dir") + "\\src\\test\\resources\\raw\\" + fileName);

	}

	public void startUploadFiles() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(startUploadButtonElement()));
		startUploadButtonElement().click();
		wait.until(ExpectedConditions.invisibilityOf(temporaryUploadFileListElement()));

		driver.navigate().refresh();
	}

	public void openMediaFile() {
		targetAlbumElement().click();
		targetMediaElement().click();

	}

	public void likeMediaFile() {
		wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
		action.moveToElement(hoverToImageElement()).perform();

		for (int i = 0; i < likeLinkElement().size(); i++) {
			int x = likeLinkElement().get(i).getLocation().getX();

			if (x != 0) {
				wait.until(ExpectedConditions.visibilityOf(likeLinkElement().get(1)));
				likeLinkElement().get(1).click();
				break;
			}
		}

	}

	public void closeMediaFile() {
		imageCloseButtonElement().click();
	}

	public void assertImageInLikes() {
		likesElement().click();
		assertTrue(targetImageInLikesElement().isDisplayed());
	}

	// -------------------- Utility Methods ------------------------------

	public static void robotUpload(String fileName) throws AWTException {
		StringSelection ss = new StringSelection(fileName);
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Getting toolkit
		Toolkit toolKit = Toolkit.getDefaultToolkit();

		// Getting clipboard as file upload window
		Clipboard clipBoard = toolKit.getSystemClipboard();

		// Copying string file name to the file upload window
		clipBoard.setContents(ss, null);

		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
