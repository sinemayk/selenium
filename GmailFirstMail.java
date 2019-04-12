package Methods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailFirstMail {
	private WebDriver driver;
	private String BaseUrl;
	
	//Burada ayn� de�ere sahip attribute i�in yaz�lan kod var

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "https://www.gmail.com/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
//kodu �al��t�rmadan �nce taray�c�n�n ge�mi�ini temizle ya da taray�c�n�n ayarlar�ndan 'ge�mi�i hat�rlama' se�ene�ini se�
	//e�er ge�mi�i hat�rlarsa girdi�in adresten gmail seni ba�ka adrese y�nlendirebilir, o zaman kodun hata verir.Senaryon de�i�ir.
	@Test
	public void test() throws Exception {
		driver.get(BaseUrl);//gmaile gidiyor
		
		driver.findElement(By.xpath("//input[contains(@autocomplete,'username')]")).clear();//textbox � temizliyoruz
		driver.findElement(By.xpath("//input[contains(@autocomplete,'username')]")).sendKeys("sinemayk");//de�eri giriyoruz
		driver.findElement(By.xpath("//span[contains(@class,'RveJvd snByac')]")).click();//ileri tu�una bas�yoruz
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("19091207ks");
		driver.findElement(By.xpath("//span[contains(@class,'RveJvd snByac')]")).click();
		Thread.sleep(5000);
		
		
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[2]/span[1]/span[1]")).click();
		String baslik = driver.findElement(By.cssSelector("span[class='gD']")).getText();//sonraki sayfaya ge�mi� mi kontrol etmek i�in gelen mail sahibi al�yoruz
		assertEquals(baslik, "noreply+subscribe@blogger.com");//burada kontrol ediyoruz
		}
		
			
		
		
		
	}


