package Read_Capcha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handle_Capcha_4 {
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://codepen.io/btjackso/pen/NNBwaK");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		driver.switchTo().frame(driver.findElement(By.id("result")));

		WebElement image_element = driver.findElement(By.id("ebcaptchatext"));
		String str = image_element.getText();
		String s1 = str.substring(8,9);
		String s2 = str.substring(12,13);

		Integer i1 = Integer.valueOf(s1);

		Integer i2 = Integer.valueOf(s2);

		System.out.println("No1: "+i1+" "+"No2 : "+i2);
		
		Integer i = i1 + i2;
		String s= String.valueOf(i);
		
		driver.findElement(By.id("ebcaptchainput")).sendKeys(s);

	}

}
