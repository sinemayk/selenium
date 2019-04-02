package Methods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsWhiztrial {
	private WebDriver driver;
	private String BaseUrl;
	
	

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  BaseUrl = "http://localhost/whizTrial/";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get(BaseUrl);
		driver.findElement(By.id("N_acnt")).click();
		WebElement butuntablo= driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/table[1]"));
		List<WebElement> satirlar = butuntablo.findElements(By.tagName("input")); //burda artýk butuntablo için findelement metodunu kullanýyoruz
		System.out.println(satirlar.size());
		
		String satirinxpathi=null;
		String satirinadi;
		
		for (int i=1; i<satirlar.size();i++){
			satirinxpathi = "/html[1]/body[1]/section[1]/div[1]/form[1]/table[1]/tbody[1]/tr[" + String.valueOf(i)+"]";//abs xpath i alýyoruz, xpath string olduðu için i nin String value su lazým
			System.out.println(satirinxpathi);
			satirinadi = driver.findElement(By.xpath(satirinxpathi)).getText();//satirinxpath i sýrayla artacak ve herbirinin adi gelecek, getText demezsek formda görülen adý gelmez
			System.out.println(satirinadi);
			System.out.println("**********************************************");
			
			
		}
		
	}

}
