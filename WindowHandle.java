package Methods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandle {
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
	public void test() throws InterruptedException {
				
		driver.get("https://tr-tr.facebook.com/");
		String anasayfa = driver.getWindowHandle();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("sinem");
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys("123");
		driver.findElement(By.id("loginbutton")).click();	
		Thread.sleep(3000);
		
		driver.switchTo().window(anasayfa);//getWindowHandle ile aldýðýn sayfaya götürüyor
		
		//assertEquals(driver.getTitle(), "Facebook - Giriþ Yap veya Kaydol");
	}

}
