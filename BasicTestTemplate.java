package CommonlyUsedMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

public class BasicTestTemplate {
		private WebDriver driver;
		private String baseUrl;
	
	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
	    baseUrl = "https://www.google.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    }
	  @Test
	  public void test_01() throws Exception {
	    driver.get(baseUrl);
	    String ExpectedTitle =driver.getTitle();
        assertEquals(ExpectedTitle,"Google");
	  	}
	  @Test
	  public void test_02() throws Exception {
		driver.get(baseUrl);//google.com ý alýyor
		driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");//arama çubuðuna yazdýrýyor
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();//Google'da Ara ya týklýyor
	    driver.findElement(By.className("LC20lb")).click();//Selenium Webdriver sonucuna tklýyor
	    assertEquals(driver.getTitle(),"Selenium WebDriver");// Açýlan sayfanýn title ý ile Selenium Webdriver ý karþýlaþtýrýyor
		}
	  }
