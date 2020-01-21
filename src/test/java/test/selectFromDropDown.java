package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectFromDropDown {

	public selectFromDropDown() {

	}

	public static WebDriver driver;
	public static String baseUrl = "http://demo.guru99.com/test/newtours/register.php";

	@BeforeMethod
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void selectSingleSelect() {
		driver.get(baseUrl);

		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		drpCountry.selectByVisibleText("KENYA");
		drpCountry.deselectByVisibleText("KENYA");

	}
	@Test(priority = 2)
	public void multiSelect()
	{
		driver.get("http://jsbin.com/osebed/2");
		Select fruits=new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		fruits.selectByValue("orange");
		fruits.deselectAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
