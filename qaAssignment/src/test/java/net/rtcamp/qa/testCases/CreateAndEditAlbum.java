package net.rtcamp.qa.testCases;

import java.awt.AWTException;

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

	@Test
	public void selectFiles() throws AWTException, InterruptedException {
		mediaAlbumPage.uploadfiles(eLocators.getProperty("image2"));
		// mediaAlbumPage.uploadfiles(eLocators.getProperty("image3"));
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
