package CommonlyUsedMethods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class findElementby_W {

	 private WebDriver driver;
	  private String baseUrl;
	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
	    //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
	    //driver = new ChromeDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testRelativexpath() throws Exception {
	    driver.get(baseUrl + "/whizTrial/");
	    driver.findElement(By.id("Lid")).sendKeys("gsahai");  // Enter the username in the 'Username' input field
	    driver.findElement(By.id("Lpwd")).sendKeys("pass123");   //  Enter the password in the 'Password' input field
	    driver.findElement(By.id("Lsub")).click();  // Click on the 'Login' button
	    Thread.sleep(5000);
	    assertEquals(driver.getTitle(),"WhizTrial Registration"); // Verifying the welcome page
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	     driver.quit();
	
}
}