package Read_Capcha;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Handle_Capcha_3 {

	
	@Test
	public void test() throws IOException {
		
		try {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");

//		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://retail.onlinesbi.com/retail/login.htm");  //sbi bank
		
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"banner\"]/div[2]/a")).click(); //sbi bank

		

		WebElement image_element = driver.findElement(By.id("refreshImgCaptcha")); //sbi bank 
		

		File src = image_element.getScreenshotAs(OutputType.FILE);
		String path = "D:/Eclipse/eclipse_workspace/Capacha_Read/Screenshots/image.png";
		
		FileHandler.copy(src, new File(path));
		
		ITesseract image = new Tesseract();
		image.setDatapath("tessdata");
		image.setLanguage("eng");
//		Thread.sleep(4000);
		String str = image.doOCR(new File(path));
		System.out.println("Image ocr done");
		Thread.sleep(5000);
        System.out.println(str);
	} catch (Exception ex) {
		System.out.println("Your error is " + ex.getMessage());
	}

	}
}
