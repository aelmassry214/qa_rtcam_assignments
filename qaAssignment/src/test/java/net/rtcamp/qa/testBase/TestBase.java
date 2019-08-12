package net.rtcamp.qa.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties eLocators = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void setup() throws IOException {

		// ------------- initialize properties files ---------------
		if (driver == null) {

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");

			config.load(fis);

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\eLocators.properties");

			eLocators.load(fis);

		}

		// ------------- initialize and load webDriver ---------------
		if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);

		}

	}

	// @AfterSuite
	public void tearDown() {

		if (driver != null) {
			// driver.close();
			driver.quit();
		}
	}

}
