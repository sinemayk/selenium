package Methods;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickingOnOneByOne {
	private WebDriver driver;
	public String BaseUrl;
	
	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "https://www.instagram.com/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
//Burada geçmiþi hatýrlama seçeneði kapalý olan tarayýcý ile test yapýldý.
	@Test
	public void test() throws InterruptedException {
		driver.get(BaseUrl);
		String anasayfa = driver.getWindowHandle();
		
		WebElement box = driver.findElement(By.xpath("/html/body/span/section/footer"));
		List<WebElement> links = box.findElements(By.tagName("a"));
		System.out.println(links.size());
		Thread.sleep(2000);
		
		//her linkin metnini alýyoruz
		for(int i =0; i<links.size(); i++)
		{
			System.out.println(links.get(i).getText());
				
			Set<String>TabListesi = driver.getWindowHandles();
				
				for (String child:TabListesi)
				{
					if(child.equalsIgnoreCase(anasayfa))//tab anasayfaya esitse
				{
								
				driver.switchTo().window(anasayfa)	;
				links.get(i).click();
				
				//Bu kodu tekrar etmemim sebebi eðer sayfa güncellendiyse ve linkler deðiþtiyse iki test koþumu arasýnda yeni listeyi almak
				driver.get(BaseUrl);
				box = driver.findElement(By.xpath("/html/body/span/section"));//burada sayfanýn istediðiniz kýsmýný alabilirsiniz. istediðiniz kýsmýndaki linkleri box elementine atayabilirsiniz.
				links = box.findElements(By.tagName("a"));
				System.out.println("*****************************************");
				
		}		
			}
			
			
		}
				

}}
