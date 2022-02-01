//package Read_Capcha;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.io.FileHandler;
//import org.testng.annotations.Test;
//
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//
//public class Handle_capcha_2 {
//
//	@Test
//	public void test() throws IOException {
//		
//		try {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
//
//		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--disable-notifications");
//
//		WebDriver driver = new ChromeDriver(opt);
//
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//
//		driver.get("https://www.irctc.co.in/nget/train-search");
//		driver.manage().window().maximize();
//
//		driver.findElement(By.xpath(
//				"/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button"))
//				.click();
//
//		driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[2]"))
//				.click();
//
//		driver.findElement(By.xpath(
//				"//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[1]/div[1]/span[2]/a/u/strong"))
//				.click();
//
//		WebElement image_element = driver.findElement(By.id("nlpCaptchaImg"));
//
//		File src = image_element.getScreenshotAs(OutputType.FILE);
//		String path = "D:\\Eclipse\\eclipse_workspace\\Capacha_Read\\Screenshots\\image.png";
//		
//		FileHandler.copy(src, new File(path));
//		
//		ITesseract image = new Tesseract();
//		
//		String str = image.doOCR(new File(path));
//		System.out.println("Image ocr done");
//
//		System.out.println(str);
//	} catch (Exception ex) {
//		System.out.println("Your error is " + ex.getMessage());
//	}
//
//	}
//
//}
