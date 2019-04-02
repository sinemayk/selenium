package Methods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetSizePosition {
	private WebDriver driver;
	private String BaseUrl1;
	private String BaseUrl2;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		BaseUrl1 = "https://www.google.com/";
		BaseUrl2 = "http://localhost/whizTrial/index.php";
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get(BaseUrl1);
		driver.manage().window().setSize(new Dimension(600,900));
		System.out.println("Google size "+ driver.manage().window().getSize());
		System.out.println("Google size height "+ driver.manage().window().getSize().getHeight());
		System.out.println("Google size width "+ driver.manage().window().getSize().getWidth());
		Thread.sleep(2000);
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		
		driver.manage().window().setPosition(new Point(300,200));
		System.out.println("Google position "+ driver.manage().window().getPosition());
		System.out.println("Google position X "+ driver.manage().window().getPosition().getX());
		System.out.println("Google position Y "+ driver.manage().window().getPosition().getY());
		System.out.println("***************************************");
		Thread.sleep(2000);
		driver.manage().window().maximize();
			
		assertEquals(driver.getTitle(), "Google");
		}
	

	@Test
	public void test2() throws InterruptedException {
		driver.get(BaseUrl2);
		driver.manage().window().setSize(new Dimension(800,500));
		System.out.println("WhizTrial size "+ driver.manage().window().getSize());
		System.out.println("WhizTrial size height "+ driver.manage().window().getSize().getHeight());
		System.out.println("WhizTrial size width "+ driver.manage().window().getSize().getWidth());
		Thread.sleep(2000);
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		
		driver.manage().window().setPosition(new Point(700,400));
		System.out.println("WhizTrial position "+ driver.manage().window().getPosition());
		System.out.println("WhizTrial position X "+ driver.manage().window().getPosition().getX());
		System.out.println("WhizTrial position Y "+ driver.manage().window().getPosition().getY());
		System.out.println("***************************************");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		assertEquals(driver.getTitle(), "WhizTrial Registration");
		}

}
