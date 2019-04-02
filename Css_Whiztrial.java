import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.Assert.assertEquals;


public class Css_Whiztrial {
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
		driver.findElement(By.id("N_acnt")).click();
		driver.findElement(By.name("Nm")).sendKeys("sinem");
		driver.findElement(By.name("Lm")).sendKeys("kirtac");
		driver.findElement(By.name("Uid")).sendKeys("myname");
		driver.findElement(By.name("pwd")).sendKeys("abcxyz");
		driver.findElement(By.name("Eid")).sendKeys("sinem@gmail.com");
		driver.findElement(By.name("Pno")).sendKeys("000000000");//yazacaðýn yerde +91 var zaten o yüzden tekrar yazma
		driver.findElement(By.id("fml")).click();
		driver.findElement(By.name("dat")).sendKeys("23.09.1986");
		driver.findElement(By.id("sel")).sendKeys("Employee");
		driver.findElement(By.id("add")).sendKeys("Istanbul");
		Thread.sleep(5000);
		driver.findElement(By.name("Sub")).click();
		
		
		
	}
	

}
