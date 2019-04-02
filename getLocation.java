package Methods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getLocation {
	private WebDriver driver;
	private String BaseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		BaseUrl = "https://www.google.com/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(BaseUrl);
		WebElement searchbutton = driver.findElement(By.name("btnK"));
		int xcoordinate = searchbutton.getLocation().x;
		int ycoordinate = searchbutton.getLocation().y;
		System.out.println("Search button x coordinate: "+ xcoordinate);
		System.out.println("Search button y coordinate: "+ ycoordinate);
		
		Thread.sleep(2000);
	
		}

}
