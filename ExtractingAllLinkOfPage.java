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

public class ExtractingAllLinkOfPage {
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
			
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		System.out.println(linkElements.size());
		int i = 0;
		Thread.sleep(3000);
		
		//her linkin metnini alýyoruz
		for(WebElement e : linkElements)
		{
			linkTexts[i] = e.getText();
			i++;
		}
		
		//Her linke gidip baþlýðý çalýþýyor mu bakýyoruz
		Thread.sleep(2000);
		for (String t : linkTexts)	{
			
			Set<String>TabListesi = driver.getWindowHandles();
			
			for (String child:TabListesi)
			{
				if(child.equalsIgnoreCase(anasayfa))//tab anasayfaya esitse
			{
							
			driver.switchTo().window(anasayfa)	;
			
			driver.findElement(By.linkText(t)).click();
			String pageTitle = driver.getTitle();
			
			if(pageTitle.equals("404 Not Found")){
				System.out.println(t + ":" + "Title not working");
			}
			else {
				System.out.println(t + ":" + "Title is working");
			}
			driver.navigate().back();
				
			}
			
			
		}

}}}
