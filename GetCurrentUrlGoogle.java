package Methods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetCurrentUrlGoogle {
	private WebDriver driver;
	private String BaseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BaseUrl = "https://www.google.com/";
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(BaseUrl);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();
		Thread.sleep(5000);
		
		System.out.println(driver.getCurrentUrl());
			
		assertEquals(driver.getTitle(), "Selenium - Google'da Ara");
	}

}
