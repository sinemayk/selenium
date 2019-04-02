package CommonlyUsedMethods;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class timeouts_R {

	 private WebDriver driver;
	  private String baseUrl;
	 
	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
	    //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
	    //driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	  }

	  @Test
	  public void findElement() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");//arama �ubu�una yazd�r�yor
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();//Google'da Ara ya t�kl�yor
	    driver.findElement(By.className("LC20lb")).click();//Selenium Webdriver sonucuna tkl�yor
	    Thread.sleep(3000);
	    assertEquals(driver.getTitle(),"Selenium WebDriver");
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	}
	}


