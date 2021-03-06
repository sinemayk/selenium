package CommonlyUsedMethods;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class getTitle_W {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
	  //driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRelativexpath() throws Exception {
	  driver.get("http://localhost/whizTrial/");
	  String Title = driver.getTitle();          // Getting the title with the help of getTitle
	  System.out.println("Title Of the webpage = " +Title);
	  
	  assertEquals("WhizTrial Registration",Title);	  

  }
  
  @Ignore
  @Test
  public void testRelativexpath_01() throws Exception {
	  driver.get("http://localhost/whizTrial/");
	  String Title = driver.getTitle();          // Getting the title with the help of getTitle
	  System.out.println("Title Of the webpage = " +Title);
	  
	  assertEquals("WhizTrial Registration",Title);	  

  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}