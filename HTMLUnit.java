package Methods;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class HTMLUnit {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();	
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRelativexpath() throws Exception {
	  driver.get("https://www.google.com/");
	  String Title = driver.getTitle();
	  System.out.println("Title of the webpage = " +Title);
	  
      assertEquals(Title,"Google");	  

  } 

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}