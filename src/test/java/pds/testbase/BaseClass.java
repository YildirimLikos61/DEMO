package pds.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pds.utility.ConfigsReader;
import pds.utility.Constants;

public class BaseClass {

	
	
	public static WebDriver driver ;
	

	/**
	 * This method will launch the browser 
	 * 
	 * @throws InterruptedException
	 */
	public static void setUp() throws InterruptedException 
	{
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
		
		String browser=ConfigsReader.getProperty("browser");
		
		switch(browser) 
		{
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
			default:
				break;
			
		}
		
		Thread.sleep(2000);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLY_WAIT));
		driver.manage().window().maximize();
		
		String website=ConfigsReader.getProperty("url");
		driver.get(website);
		PageInitializer.Initializer();
		
		
	}
	
	
	
	
	/**
	 * This method will quit the window
	 */
	public static void tearDown()
	{
		if(driver!=null) 
		{
			driver.quit();
		}
	}
	
	
	
	
}
