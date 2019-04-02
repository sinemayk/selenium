import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.Assert.assertEquals;


public class Classname_Whiztrial {
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
		String name = driver.findElement(By.className("about-author")).getText(); 
		System.out.print(name);
		
		
	}
	

}
