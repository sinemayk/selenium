package CommonlyUsedMethods;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class firstTest {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	

	@Test
	public void test() {
		 	driver.get(baseUrl + "/whizTrial/");
		    driver.findElement(By.name("userauth1")).clear();
		    driver.findElement(By.name("userauth1")).sendKeys("gsahai");
		    driver.findElement(By.name("userauth")).clear();
		    driver.findElement(By.name("userauth")).sendKeys("pass123");
		    driver.findElement(By.name("commit")).click();
		    //driver.findElement(By.id("ilink")).click();
	}

}
