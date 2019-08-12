package temp;

public class temp {

	// @DataProvider(name = "uploadImages")

	// public static Object[] image() {

	// return new Object[] { eLocators.getProperty("image1") };

	// }

	// =====================================================================

	// private WebElement dropFilesAreaElement() {
	// return
	// driver.findElement(By.xpath(eLocators.getProperty("dropFilesAreaLocator")));
	// }

	// System.out.println("inside uploadFiles");
	// File sFile = new File(System.getProperty("user.dir") +
	// "\\src\\test\\resources\\raw\\" + fileName);
	// DropFile(sFile, dropFilesAreaElement(), 0, 0);

	// uploadFilesLinkElement().sendKeys(System.getProperty("user.dir") +
	// "\\src\\test\\resources\\raw\\" + fileName);

	// ==========================================================================

	// public static void DropFile(File filePath, WebElement target, int offsetX,
	// int offsetY) {
	// System.out.println("inside DropFile method");
	// if (!filePath.exists())
	// throw new WebDriverException("File not found: " + filePath.toString());
	//
	// WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
	// JavascriptExecutor jse = (JavascriptExecutor) driver;
	// WebDriverWait wait = new WebDriverWait(driver, 30);
	//
	// String JS_DROP_FILE = "var target = arguments[0]," + " offsetX =
	// arguments[1]," + " offsetY = arguments[2],"
	// + " document = target.ownerDocument || document," + " window =
	// document.defaultView || window;" + ""
	// + "var input = document.createElement('INPUT');" + "input.type = 'file';" +
	// "input.style.display = 'none';"
	// + "input.onchange = function () {" + " var rect =
	// target.getBoundingClientRect(),"
	// + " x = rect.left + (offsetX || (rect.width >> 1)),"
	// + " y = rect.top + (offsetY || (rect.height >> 1))," + " dataTransfer = {
	// files: this.files };" + ""
	// + " ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
	// + " var evt = document.createEvent('MouseEvent');"
	// + " evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1,
	// 0, null);"
	// + " evt.dataTransfer = dataTransfer;" + " target.dispatchEvent(evt);" + "
	// });" + ""
	// + " setTimeout(function () { document.body.removeChild(input); }, 25);" +
	// "};"
	// + "document.body.appendChild(input);" + "return input;";
	//
	// System.out.println(JS_DROP_FILE);
	//
	// WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target,
	// offsetX, offsetY);
	// input.sendKeys(filePath.getAbsoluteFile().toString());
	// wait.until(ExpectedConditions.stalenessOf(input));
	// }

	// ========================================================================
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("window.scrollBy(0,500)");

	// ========================================================================
	// Actions builder = new Actions(driver);
	//
	// Action myAction = builder.click(uploadFilesLinkElement()).release().build();
	//
	// myAction.perform();

}
