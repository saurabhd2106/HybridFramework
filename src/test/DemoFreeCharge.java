package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoFreeCharge {

	

		public WebDriver driver;

		@BeforeTest
		public void beforetest() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.freecharge.in");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		@Test
		public void test() {

			WebElement mobileNo = driver
					.findElement(By.xpath("//div[@class='input-container _3udlq _22ixJ undefined']/input"));
			mobileNo.clear();
			mobileNo.sendKeys("8826963949");

			WebElement radioPrepaid = driver.findElement(By.xpath("//span[contains(.,'Prepaid')]/preceding-sibling::span"));

			if (radioPrepaid.isSelected()) {
				System.out.println("Prepaid is selected");

			}

			WebElement radioPostpaid = driver.findElement(By.xpath("//span[text()='Postpaid']/preceding-sibling::span"));

			if (radioPostpaid.isSelected()) {
				System.out.println("postpaid is selected");

			}

			WebDriverWait wait = new WebDriverWait(driver, 20);

			WebElement button = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Proceed')]")));

			button.click();

			WebElement viewAllPlans = driver.findElement(By.xpath("//button[contains(text(),'View all plans')]"));

			viewAllPlans.click();

		}

		@AfterTest
		public void aftertest() {
			driver.quit();
		}

	}

