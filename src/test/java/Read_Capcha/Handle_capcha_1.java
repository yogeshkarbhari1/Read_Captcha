package Read_Capcha;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Handle_capcha_1 {

	@Test
	public void test() throws IOException, TesseractException, InterruptedException {

		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

//			ChromeOptions opt = new ChromeOptions();
//			opt.addArguments("--disable-notifications");

//			WebDriver driver = new ChromeDriver(opt);
			WebDriver driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//			
			 driver.get("https://allwebco-templates.com/support/script-simple-captcha.htm");
			
//			2.driver.get("https://www.plus2net.com/php_tutorial/captcha-demo1.php");
			
			driver.manage().window().maximize();

			 WebElement image_element = driver.findElement(By.id("CaptchaDiv"));

			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", image_element);
			
			Thread.sleep(2000);
//			2. WebElement image_element = driver.findElement(By.id("capt"));

			File src = image_element.getScreenshotAs(OutputType.FILE);
			String path = "D:\\Eclipse\\eclipse_workspace\\Capacha_Read\\Screenshots\\image.png";

			FileHandler.copy(src, new File(path));

			Thread.sleep(1000);

			ITesseract image = new Tesseract();
			image.setDatapath("tessdata");
			image.setLanguage("eng");

			String str = image.doOCR(new File(path));
			System.out.println("Image ocr done");

			System.out.println(str);
			Thread.sleep(2000);
			driver.findElement(By.id("CaptchaInput")).sendKeys(str);
			
//			2.driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys(str);
			
			Thread.sleep(3000);
			
		} catch (Exception ex) {
			System.out.println("Your error is " + ex.getMessage());
		}
	}

}
