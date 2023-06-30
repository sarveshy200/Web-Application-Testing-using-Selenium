package seleniumTest;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test5 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
//	Opening the one of the search product
	public void openOneSearchResult() {
		String product = "iphone";
		WebElement searchInput = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchInput.sendKeys(product);
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		
//		driver.findElement(By.xpath("https://www.amazon.in/Apple-iPhone-14-128GB-Midnight/dp/B0BDHX8Z63/ref=sr_1_3?crid=1CY3W44272E6J&keywords=iphone&qid=1688096341&sprefix=%2Caps%2C220&sr=8-3"));
		
		WebElement firstProduct = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][normalize-space()='Apple iPhone 14 (128 GB) - Midnight']"));
		firstProduct.click();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
