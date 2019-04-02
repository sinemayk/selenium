import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.Assert.assertEquals;


public class LinkText_Registration_Whiztrial {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");//mozillanin herseyine gecko yazican
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//bunu eklemedim hata verdi
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//sayfayi kapatiyor hemen testten sonra
	}

	@Test
	public void test1() throws InterruptedException {
		//fail("Not yet implemented");
		driver.get("http://localhost/whizTrial/");
		driver.findElement(By.linkText("Create New Account")).click();// html kodunda href den sonra gelen yazý kýsmý buraya yazýlýr 
		Thread.sleep(2000);
		
	}
	@Test
	public void test2() throws InterruptedException {
		//fail("Not yet implemented");
		driver.get("http://localhost/whizTrial/");
		driver.findElement(By.partialLinkText("Create New")).click();// html kodunda href den sonra gelen yazýnýn bir kýsmýný buraya yazýlýr 
		Thread.sleep(2000);
		
		
	}

}
