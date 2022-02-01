package Read_Capcha;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Handle_Capcha_5 {

//	@Test
//	public void test() throws IOException, TesseractException, InterruptedException {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://democaptcha.com/demo-form-eng/math-image.html");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		
//
//		
//		WebElement image_element = driver.findElement(By.xpath("//*[@id='htest_image']"));
//		String str = image_element.getText();
//		String s1 = str.substring(0,2);
//		String s2 = str.substring(3,5);
//
//		Integer i1 = Integer.valueOf(s1);
//
//		Integer i2 = Integer.valueOf(s2);
//
//		System.out.println("No1: "+i1+" "+"No2 : "+i2);
//		
//		Integer i = i1 + i2;
//		String s= String.valueOf(i);
//		
//		driver.findElement(By.id("vericode")).sendKeys(s);

//	}
//}
	

	@Test
	public void test() throws IOException, TesseractException {
		try {
//			WebDriverManager.chromedriver().setup();
			
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\karbh\\workspace\\Com.Captcha.Handle\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://democaptcha.com/demo-form-eng/math-image.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			WebElement image_element = driver.findElement(By.id("htest_image"));
			File src = image_element.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/Screenshots/math_image.png";
			FileHandler.copy(src, new File(path));

			ITesseract tesseract = new Tesseract();
			tesseract.setDatapath("tessdata");
			tesseract.setLanguage("eng");

			Thread.sleep(2000);
			String text = tesseract.doOCR(new File(path));
			System.out.println("Image and Text captured");
			Thread.sleep(2000);
			System.out.println(text);

			String s1 = text.substring(0, 2);
			System.out.println(s1);
			String s2 = text.substring(3, 5);
			System.out.println(s2);
			int i1 = Integer.valueOf(s1);
			System.out.println(i1);
			int i2 = Integer.valueOf(s2);
			System.out.println(i2);
			int result = i1 + i2;
			System.out.println(result);
			String string_result = String.valueOf(result);
			System.out.println(string_result);
			Thread.sleep(1500);
			driver.findElement(By.id("vericode")).sendKeys(string_result);
			driver.findElement(By.xpath("//*[@id='image_captcha_demo_form']/table/tbody/tr[4]/td[2]/input")).click();
		} catch (Exception ex) {
			System.out.println("your error is " + ex.getMessage());
		}

	}
}
