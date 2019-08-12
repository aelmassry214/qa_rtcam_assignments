package net.rtcamp.qa.testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import net.rtcamp.qa.testBase.TestBase;
import net.rtcamp.qa.testPages.ActivityPage;
import net.rtcamp.qa.testPages.HomePage;
import net.rtcamp.qa.testPages.LoginPage;

public class LoginTest extends TestBase {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	ActivityPage activityPage = new ActivityPage();

	// -------------- login Success ----------------
	@Test
	public void loginSuccessTest() {
		homePage.gotoLoginPage();
		loginPage.Login("demo", "demo");

		String sucessAssert = driver.findElement(By.cssSelector(eLocators.getProperty("loginSuccess"))).getText();
		assertTrue(sucessAssert.contains(eLocators.getProperty("successText")));

	}

	// -------------- login Fail -------------------
	@Test
	public void loginFailTest() {

		homePage.gotoLoginPage();
		loginPage.Login("demo", "123456");

		String failAssert = driver.findElement(By.id(eLocators.getProperty("loginFail"))).getText().toLowerCase();
		System.out.println(failAssert);
		assertTrue(failAssert.contains(eLocators.getProperty("errorText")));

	}

	@Test
	public void gotoHomePage() {
		driver.get(config.getProperty("url"));

	}

	@Test
	public void logout() {
		activityPage.logout();
	}

}
