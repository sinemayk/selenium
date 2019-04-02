package Methods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetPageSource {
	private WebDriver driver;
	private String BaseUrl1;
	private String BaseUrl2;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		BaseUrl1 = "https://www.google.com/";
		BaseUrl2 = "http://localhost/whizTrial/index.php";
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test1() {
		driver.get(BaseUrl1);
		System.out.println(driver.getPageSource());
		System.out.println("***************************************");
			
		assertEquals(driver.getTitle(), "Google");
		}
	

	@Test
	public void test2() {
		driver.get(BaseUrl2);
		System.out.println(driver.getPageSource());
		System.out.println("***************************************");
			
		assertEquals(driver.getTitle(), "WhizTrial Registration");
		}

}
