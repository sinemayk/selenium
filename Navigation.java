package Methods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Navigation {
	private WebDriver driver;
	private String BaseUrl;
		
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		BaseUrl = "http://www.google.com";
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.navigate().to(BaseUrl);// to() yu kulland�k
		driver.findElement(By.name("q")).sendKeys("sinemayk.blogspot.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();
		driver.findElement(By.xpath("//a[@href='http://sinemayk.blogspot.com/']//h3[@class='LC20lb'][contains(text(),'Not Defteri')]")).click();
		String url = "http://sinemayk.blogspot.com/";
		assertEquals(driver.getCurrentUrl(), url); //�imdiki url ile gitmek istedi�imiz url i kar��la�t�r�yoruz
		Thread.sleep(2000);
		driver.navigate().back();// geri gidiyoruz, google arama sayfas�na
		String backTitle = "sinemayk.blogspot.com - Google'da Ara";
		assertEquals(backTitle, driver.getTitle());//ger�ekten google arama sayfas�na d�nm�� m� bak�yoruz
		driver.navigate().forward();// ileri gidiyoruz bloga
		assertEquals("Not Defteri", driver.getTitle());// ger�ekten blog a gitmi� mi bak�yoruz
		driver.navigate().refresh();// sayfay� yeniliyoruz
			
	}
	}
