package net.rtcamp.qa.testCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import net.rtcamp.qa.testBase.TestBase;
import net.rtcamp.qa.testPages.ProfilePage;

public class EditProfile extends TestBase {

	ProfilePage profilePage = new ProfilePage();

	@Test
	public void editProfileImage() throws AWTException, InterruptedException {
		profilePage.gotoProfilePage(eLocators.getProperty("profileAvatar"));
	}

}
