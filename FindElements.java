package Methods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElements {
	private WebDriver driver;
	private String BaseUrl;
	
	

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "https://www.google.com/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		driver.get(BaseUrl);
		List<WebElement> linklistesi = driver.findElements(By.tagName("a"));
		System.out.println(linklistesi.size());
		
		for (int i=1; i<linklistesi.size();i++){
			System.out.println(linklistesi.get(i).getText());
			System.out.println("***************************************************************");
			
			
		}
		
		
	}

}
