package Read_Capcha;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;

public class Handle_capcha_6 {

	public String s1;
	public String s2;

	@Test
	public void test() throws IOException, TesseractException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jsfiddle.net/v7bcjj1q/2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\'editor\']/div[3]/div[3]/div/div[1]/iframe")));

		WebElement image_element = driver.findElement(By.id("question"));
		String str = image_element.getText();
		System.out.println(str.length());
		System.out.println(str);
		if (str.length() == 8) {
			s1 = str.substring(0, 2);
			s2 = str.substring(5, 7);
		} else if (str.length() == 6) {
			s1 = str.substring(0, 1);

			s2 = str.substring(4, 5);

		} else if (str.length() == 7) {
			if ((str.substring(0, 1).length()) == 1) {
				s1 = str.substring(0, 1);

				s2 = str.substring(4, 6);

			} else if ((str.substring(5, 6).length()) == 1) {
				s1 = str.substring(0, 2);
				System.out.println(s1);

				s2 = str.substring(5, 6);
				System.out.println(s2);

			}
		}
		Integer i1 = Integer.valueOf(s1.replace(" ", ""));

		Integer i2 = Integer.valueOf(s2.replace(" ", ""));

		System.out.println("No1: " + i1 + " " + "No2 : " + i2);

		Integer i = i1 + i2;
		String s = String.valueOf(i);

		driver.findElement(By.id("ans")).sendKeys(s);

	}
}
