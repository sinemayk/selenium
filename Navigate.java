package Methods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigate {
	private WebDriver driver;
	private String BaseUrl;
	
	@Before
	public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "http://localhost/whizTrial/";
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.navigate().to(BaseUrl);
		driver.navigate().to("https://google.com/");
		
		driver.navigate().back();//WhizTrial a dönüyor
		Thread.sleep(2000);
		assertEquals(driver.getTitle(), "WhizTrial Registration" );
		
		driver.navigate().forward();//Google a gidiyor
		Thread.sleep(2000);
		assertEquals(driver.getTitle(), "Google" );
		
		
	}

}
