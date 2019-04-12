package Methods;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class IdentifyingLinksWithXPathAndCss {
	private WebDriver driver;
	public String BaseUrl;
	
	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "https://www.blogger.com/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
//Burada geçmiþi hatýrlama seçeneði açýk olan tarayýcý ile test yapýldý.
	@Test
	public void test() throws InterruptedException {
		driver.navigate().to(BaseUrl);
		driver.findElement(By.cssSelector("html body header.header div.header--content div.header--buttons a.sign-in.ga-header-sign-in")).click();
		driver.findElement(By.cssSelector("#identifierId")).clear();
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("sinemsencen");
		driver.findElement(By.xpath("//span[contains(@class,'RveJvd snByac')]")).click();//ileri tuþuna basýyoruz
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".I0VJ4d > div:nth-child(1) > input:nth-child(1)")).clear();
		driver.findElement(By.cssSelector(".I0VJ4d > div:nth-child(1) > input:nth-child(1)")).sendKeys("19091207ks");
		driver.findElement(By.xpath("//span[contains(@class,'RveJvd snByac')]")).click();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//a[contains(@href,'#editor/target=post;postID=720409305405083607;onPublishedMenu=allposts;onClosedMenu=allposts;postNum=0;src=postname')]")).getText();//xpath ile linkin  yazýsýný alýyoruz
		System.out.println(text);
		String text2 = driver.findElement(By.cssSelector("tr.K3JSBVB-o-r:nth-child(2) > td:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).getText();//css ile linkin  yazýsýný alýyoruz
		System.out.println(text2);
	}

}
