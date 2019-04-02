package CommonlyUsedMethods;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sendKeys_R {
		private WebDriver driver;
	  @Before
	  	public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void findElements() throws Exception {
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");//arama çubuðuna yazdýrýyor
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();//Google'da Ara ya týklýyor
	    driver.findElement(By.className("LC20lb")).click();//Selenium Webdriver sonucuna tklýyor
	    Thread.sleep(3000);
	    assertEquals(driver.getTitle(),"Selenium WebDriver");
	}
	    
	  @After
	  	public void tearDown() throws Exception {
	    driver.quit();		  
	}
}
