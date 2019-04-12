package Methods;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicElements {
	private WebDriver driver;
	private String BaseUrl;
	
	//Burada ayn� de�ere sahip attribute i�in yaz�lan kod var

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "https://www.google.com/intl/tr/gmail/about/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		driver.get(BaseUrl);//gmaile gidiyor
		String anasayfa = driver.getWindowHandle();//gmail sayfas�n� al�yor
		driver.findElement(By.xpath("//a[contains(@class,'h-c-button h-c-button--primary hero-carousel__cta hero-carousel__cta--reg')]")).click();
		Thread.sleep(2000);
		
		Set<String>TabListesi = driver.getWindowHandles();//kay�t olu�turuna bast�ktan sonra yeni tab a��ld��� i�in windowhandles kullan�yoruz
		
		for (String child:TabListesi)
		{
			if(!child.equalsIgnoreCase(anasayfa))//ilk tab ikinciye e�it olmad��� zaman ikinci taba ge�ip a�a��dakileri yapacak
		{
		driver.switchTo().window(child);//2nci sekmeye ge�iyor, yeni a��lan
		driver.findElement(By.id("firstName")).clear();//ad s�tununu temizliyor
		driver.findElement(By.id("firstName")).sendKeys("selenium");//ad s�tununa bu de�eri giriyor
		driver.findElement(By.id("lastName")).clear();//soyad s�tununu temizliyor
		driver.findElement(By.id("lastName")).sendKeys("koddeneme");//soyad s�tununa bu de�eri giriyor
		driver.findElement(By.id("username")).clear();//kullan�c� ad� s�tununu temizliyor
		driver.findElement(By.id("username")).sendKeys("seleniumkoddeneme");//kullan�c� ad� s�tununa bu de�eri giriyor
		
		String cssSelect = "input[class='whsOnd zHQkBf'][name='Passwd']";//bu elementlerin class de�erleri ayn�, css kullanarak name de�erlerini de al�yoruz
		driver.findElement(By.cssSelector(cssSelect)).clear();//cssSelect e atad���m�z i�in art�k onu kullan�yoruz
		driver.findElement(By.cssSelector(cssSelect)).sendKeys("sinem12345");
		String cssSelect2 = "input[class='whsOnd zHQkBf'][name='ConfirmPasswd']";
		driver.findElement(By.cssSelector(cssSelect2)).clear();
		driver.findElement(By.cssSelector(cssSelect2)).sendKeys("sinem12345");
		
		driver.findElement(By.xpath("//span[contains(@class,'RveJvd snByac')]")).click();//ileri tu�una bas�yoruz
		
		String baslik = driver.findElement(By.cssSelector("h1[jsname='z6sL2b']")).getText();//sonraki sayfaya ge�mi� mi kontrol etmek i�in bir ba�l�k al�yoruz
		assertEquals(baslik, "Numaran�z� do�rulay�n");//burada kontrol ediyoruz
		}
		
			
		}
		
		
	}}


