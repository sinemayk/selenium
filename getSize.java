package Methods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getSize {
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
		int width = searchbutton.getSize().width;
		int height = searchbutton.getSize().height;
		System.out.println("Search button width: "+ width);
		System.out.println("Search button height: "+ height);
		
		//*************getTagName********************//
		String tagname = searchbutton.getTagName();
		System.out.println("Search button tagname: " +tagname);
		
		//*************isDisplayed******************//
		boolean displayed = searchbutton.isDisplayed();
		System.out.println("Search button displayed status: " +displayed);
		
		//************isEnabled********************//
		boolean enabled = searchbutton.isEnabled();
		System.out.println("Search button enabled status: " +enabled);
		
		Thread.sleep(2000);
	
		}

}
