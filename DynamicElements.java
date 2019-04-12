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
	
	//Burada ayný deðere sahip attribute için yazýlan kod var

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
		String anasayfa = driver.getWindowHandle();//gmail sayfasýný alýyor
		driver.findElement(By.xpath("//a[contains(@class,'h-c-button h-c-button--primary hero-carousel__cta hero-carousel__cta--reg')]")).click();
		Thread.sleep(2000);
		
		Set<String>TabListesi = driver.getWindowHandles();//kayýt oluþturuna bastýktan sonra yeni tab açýldýðý için windowhandles kullanýyoruz
		
		for (String child:TabListesi)
		{
			if(!child.equalsIgnoreCase(anasayfa))//ilk tab ikinciye eþit olmadýðý zaman ikinci taba geçip aþaðýdakileri yapacak
		{
		driver.switchTo().window(child);//2nci sekmeye geçiyor, yeni açýlan
		driver.findElement(By.id("firstName")).clear();//ad sütununu temizliyor
		driver.findElement(By.id("firstName")).sendKeys("selenium");//ad sütununa bu deðeri giriyor
		driver.findElement(By.id("lastName")).clear();//soyad sütununu temizliyor
		driver.findElement(By.id("lastName")).sendKeys("koddeneme");//soyad sütununa bu deðeri giriyor
		driver.findElement(By.id("username")).clear();//kullanýcý adý sütununu temizliyor
		driver.findElement(By.id("username")).sendKeys("seleniumkoddeneme");//kullanýcý adý sütununa bu deðeri giriyor
		
		String cssSelect = "input[class='whsOnd zHQkBf'][name='Passwd']";//bu elementlerin class deðerleri ayný, css kullanarak name deðerlerini de alýyoruz
		driver.findElement(By.cssSelector(cssSelect)).clear();//cssSelect e atadýðýmýz için artýk onu kullanýyoruz
		driver.findElement(By.cssSelector(cssSelect)).sendKeys("sinem12345");
		String cssSelect2 = "input[class='whsOnd zHQkBf'][name='ConfirmPasswd']";
		driver.findElement(By.cssSelector(cssSelect2)).clear();
		driver.findElement(By.cssSelector(cssSelect2)).sendKeys("sinem12345");
		
		driver.findElement(By.xpath("//span[contains(@class,'RveJvd snByac')]")).click();//ileri tuþuna basýyoruz
		
		String baslik = driver.findElement(By.cssSelector("h1[jsname='z6sL2b']")).getText();//sonraki sayfaya geçmiþ mi kontrol etmek için bir baþlýk alýyoruz
		assertEquals(baslik, "Numaranýzý doðrulayýn");//burada kontrol ediyoruz
		}
		
			
		}
		
		
	}}


