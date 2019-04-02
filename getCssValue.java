package Methods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getCssValue {
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
		WebElement searchbutton = driver.findElement(By.name("btnK"));
		String fontstyle = searchbutton.getCssValue("font-style");//butonu web element olan searchbuttona atadýk
		String fontsize = searchbutton.getCssValue("font-size");//o yüzden artýk driver.find.. deðil searchbutton.find yazýyoruz
		String backgroundcolour = searchbutton.getCssValue("background-color");
		
		System.out.println("Font style of search button: " + fontstyle);
		System.out.println("Font size of search button: " + fontsize);
		System.out.println("Background colour of search button: " + backgroundcolour);
				
		
	}

}
