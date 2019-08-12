package net.rtcamp.qa.testCases;

import org.testng.annotations.Test;

import net.rtcamp.qa.testBase.TestBase;
import net.rtcamp.qa.testPages.ActivityPage;

public class UpdateMediaStatusPost extends TestBase {

	ActivityPage activityPage = new ActivityPage();

	@Test
	public void updateMediaImagesPost() {
		activityPage.writeNewPostText();
		activityPage.addMedia(eLocators.getProperty("image1"));
		activityPage.selectPrivacy();
		activityPage.updatePost();
	}

}
