package net.rtcamp.qa.testCases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.rtcamp.qa.testBase.TestBase;
import net.rtcamp.qa.testPages.MediaAlbumPage;

public class CreateAndEditAlbum extends TestBase {

	MediaAlbumPage mediaAlbumPage = new MediaAlbumPage();

	@Test
	public void createAlbum() {
		mediaAlbumPage.createNewAlbum();
		driver.navigate().refresh();
	}

	@Test
	public void editAlbum() {
		mediaAlbumPage.editAlbum();
	}

	@DataProvider(name = "uploadImages")
	public static Object[] image() {

		return new Object[] { eLocators.getProperty("image2"), eLocators.getProperty("image3"),
				eLocators.getProperty("image4"), eLocators.getProperty("image5"), eLocators.getProperty("image6") };

	}

	@Test(dataProvider = "uploadImages")
	public void selectFiles(String image) throws AWTException, InterruptedException {
		mediaAlbumPage.uploadfiles(image);
		Thread.sleep(1000);

	}

	@Test
	public void uploadFiles() {
		mediaAlbumPage.startUploadFiles();

	}

	@Test
	public void likeMediaFile() {
		mediaAlbumPage.openMediaFile();
		mediaAlbumPage.likeMediaFile();
		mediaAlbumPage.closeMediaFile();
	}

	@Test
	public void assertImageInLikes() {
		mediaAlbumPage.assertImageInLikes();
	}

	@Test
	public void gotoAlbumPage() {
		driver.get(config.getProperty("albumURL"));
	}

}
