package seleniumTest;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test4 {
	
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
//	Verify search product
	public void verifySearchResults() {
		String product = "iphone";
		WebElement searchInput = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchInput.sendKeys(product);
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		WebElement resultsCount = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
		String searchResult = resultsCount.getText();
		
		if (searchResult.contains(product)) {
            System.out.println("Search results verification passed!");
        } else {
            System.out.println("Search results verification failed!");
        }
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
