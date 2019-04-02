package Methods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class isSelected {
	private WebDriver driver;
	private String BaseUrl;
		

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		BaseUrl = "http://localhost/whizTrial/index.php";
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get(BaseUrl);
		WebElement rmm_me = driver.findElement(By.id("Rem"));
		boolean beforeselected = rmm_me.isSelected();
		System.out.println("Remember me radio button is selected:" +beforeselected);
		rmm_me.click();
		boolean afterselected = rmm_me.isSelected();
		System.out.println("Remember me radio button is selected:" +afterselected);
		
		}
	}
