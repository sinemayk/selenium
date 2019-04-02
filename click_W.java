package CommonlyUsedMethods;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class click_W {

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
	    driver.get(baseUrl + "/whizTrial/");  //  Launch the whizTrial website
	    driver.findElement(By.linkText("Create New Account")).click();  // Click on the 'Create New Account' linkText
	    Thread.sleep(3000); 
	    assertEquals(driver.getTitle(),"WhizTrial Registration"); // Verifying the Registration page
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	     driver.quit();
	
}
}


