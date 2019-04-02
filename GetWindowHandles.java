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
		System.out.println("a��k tab say�s� " + driver.getWindowHandles().size());		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("�erezler �lkemizi")).click();
		Thread.sleep(3000);	
		System.out.println("�erezler �lkemize t�klad�ktan sonra");		
		System.out.println("a��k tab say�s� " + driver.getWindowHandles().size());
		
		
		Set<String> tablistesi = driver.getWindowHandles();	
		for(String child:tablistesi)
				{
				if(!child.equalsIgnoreCase(anasayfa))//ilk tab anasayfaya e�it o y�zden else e d���yor, di�er tab e�it de�il
				{
				driver.switchTo().window(child);
			System.out.println("child id " + child);// id burda yaz�l�yor
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

			System.out.println("Veri �lkemize t�klad�ktan sonra");
			
			System.out.println("a��k tab say�s� " + driver.getWindowHandles().size());
				}
				else {
					System.out.println("Ba�ka tab yok");
					System.out.println("anasayfa id " + anasayfa);
				}
			Thread.sleep(3000);	
				}
		
		//ilk tab anasayfa oldu�u i�in "ba�ka tab yok" diyor, sonraki tab i�in for d�ng�s�nde id sini ve url ini yazd�r�yor.
		
						
		
				
		
		
		//assertEquals(driver.getTitle(), "Facebook - Giri� Yap veya Kaydol");
	}

}