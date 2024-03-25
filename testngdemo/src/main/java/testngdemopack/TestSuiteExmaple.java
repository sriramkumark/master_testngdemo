package testngdemopack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSuiteExmaple {
	// Test Suite , MEans collections of Testcases.
	
	WebDriver driver;
	 long starttime;
	long endtime;
	@Test
	public void openBrowser() {
    		driver= new ChromeDriver();	
           starttime= System.currentTimeMillis();  
		}
		@Test(priority = 0)
	public void openGoogle() {
		driver.get("http://www.google.com");
		}
	@Test(priority = 2)
	public void openFlipkart() {
		driver.get("http://www.flipkart.com");
		
	}
	@Test(priority = 1)
	public void openAmazon() {
		driver.get("http://www.Amazon.in");
		
		
	}
	@Test(priority = 3)
	public void closeBrowser() {
		driver.quit();
		endtime=System.currentTimeMillis();
		long totaltime=starttime-endtime;
		System.out.println(starttime);
		System.out.println(endtime);
		System.out.println(totaltime);
		
	}
}
