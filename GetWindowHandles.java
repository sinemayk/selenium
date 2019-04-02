package Methods;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetWindowHandles {
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
		System.out.println("açýk tab sayýsý " + driver.getWindowHandles().size());		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Çerezler Ýlkemizi")).click();
		Thread.sleep(3000);	
		System.out.println("Çerezler Ýlkemize týkladýktan sonra");		
		System.out.println("açýk tab sayýsý " + driver.getWindowHandles().size());
		
		
		Set<String> tablistesi = driver.getWindowHandles();	
		for(String child:tablistesi)
				{
				if(!child.equalsIgnoreCase(anasayfa))//ilk tab anasayfaya eþit o yüzden else e düþüyor, diðer tab eþit deðil
				{
				driver.switchTo().window(child);
			System.out.println("child id " + child);// id burda yazýlýyor
			System.out.println("child url " + driver.getCurrentUrl());// url
			
			driver.findElement(By.xpath("//a[@href='https://www.facebook.com/about/privacy']")).click();
			//Iterator<String> iterator = tablistesi.iterator();
			//while(iterator.hasNext())
			for(String newchild:tablistesi)
			{
		//String nexttab = iterator.next();
		if(!newchild.equalsIgnoreCase(anasayfa))
			driver.switchTo().window(newchild);
		Thread.sleep(3000);	
		System.out.println("newchild id " + newchild);
		System.out.println("newchild url " + driver.getCurrentUrl());
			}

			System.out.println("Veri Ýlkemize týkladýktan sonra");
			
			System.out.println("açýk tab sayýsý " + driver.getWindowHandles().size());
				}
				else {
					System.out.println("Baþka tab yok");
					System.out.println("anasayfa id " + anasayfa);
				}
			Thread.sleep(3000);	
				}
		
		//ilk tab anasayfa olduðu için "baþka tab yok" diyor, sonraki tab için for döngüsünde id sini ve url ini yazdýrýyor.
		
						
		
				
		
		
		//assertEquals(driver.getTitle(), "Facebook - Giriþ Yap veya Kaydol");
	}

}