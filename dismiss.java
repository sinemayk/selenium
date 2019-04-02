package Methods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class dismiss {
	private WebDriver driver;
	private String BaseUrl;
		

	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		BaseUrl = "http://www.google.com";
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		driver = new FirefoxDriver(dc);

		
//Creating an alert with OK and Cancel button with the help of JavascriptExecutor
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.confirm('Alert dismiss in few seconds');");
		//js.executeScript("window.propmt('Enter your name')");		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(BaseUrl);
		
		try{}
		catch(UnhandledAlertException f){
		try{
		Thread.sleep(10000);
		Alert confirmation = driver.switchTo().alert();
		String alerttext = confirmation.getText();
		System.out.println("Alert text is: " +alerttext);
		Thread.sleep(5000);
		confirmation.dismiss();
		}
		catch(NoAlertPresentException noe){}
		}
		
		//driver.switchTo().alert().sendKeys("sinem");
		//org.openqa.selenium.UnhandledAlertException: Dismissed user prompt dialog: Alert dismiss in few seconds: 
	//yukarýdaki gibi hata veriyor, bu koda tekrar bakmak gerekiyor.


		
		}
	}
