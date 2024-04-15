package pds.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pds.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	
	/**
	 * This method will send text to specific Element
	 * @param el
	 * @param text
	 */
	public static void sendText(WebElement el,String text) 
	{
		el.clear();
		el.sendKeys(text);
	}
	
	
	
	public static void clickRadioOrCheckBox(List<WebElement> list,String value) 
	{
		
		for(WebElement el:list) 
		{
			String text1=el.getAttribute("value").trim();
			if(text1.equals(value) && el.isEnabled()) 
			{
				el.click();
				break;
			}
		}
		
	}
	
	
	public static void wait(int sec) 
	{
		try 
		{
			Thread.sleep(sec*1000);
		} catch (InterruptedException e)
		{	
			e.printStackTrace();
		}
	}
	
	public static void selectDropDown(WebElement el,int index) 
	{
		try 
		{
		 Select sel=new Select(el);
		 sel.selectByIndex(index);
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void selectDropDown(WebElement el,String visiabletext) 
	{
		try 
		{
		  Select sel=new Select(el);
		  sel.selectByVisibleText(visiabletext);
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void switchframe(int index) 
	{
		try 
		{
		  driver.switchTo().frame(index);
		}catch(NoSuchFrameException a)
		{
		  a.printStackTrace();
		}
	}
	
	
	public static void swicthframe(String nameorid) 
	{
		try 
		{
		driver.switchTo().frame(nameorid);
		}catch(NoSuchFrameException a) 
		{
			a.printStackTrace();
		}
	}
	
	public static void switchframe(WebElement el) 
	{
	   try 
	   {
		driver.switchTo().frame(el);
	   }catch(NoSuchFrameException a) 
	   {
		   a.printStackTrace();
	   }
	}
	
	
	public static void acceptAlert() 
	{
		try 
		{
		  Alert alert=driver.switchTo().alert();
		  alert.accept();
		}catch(NoAlertPresentException a) 
		{
			a.printStackTrace();
		}
	}
	
	
	public static void dismissAlert() 
	{
		try 
		{
		  Alert alert=driver.switchTo().alert();
		  alert.dismiss();
		}catch(NoAlertPresentException a) 
		{
			a.printStackTrace();
		}
	}
	
	
	public static void sendTextToAlert(String text) 
	{
	    try 
	    {
		  Alert alert=driver.switchTo().alert();
		  alert.sendKeys(text);
	    }catch(NoAlertPresentException a) 
	    {
	    	a.printStackTrace();
	    }
	}
	
	public static String getAlertText()
	{
	    String text=null;
		try 
		{
		  Alert alert=driver.switchTo().alert();
		  text=alert.getText();
		}catch(NoAlertPresentException a) 
		{
			a.printStackTrace();
		}
		return text;
	}
	
	
	
	public static void swicthtoWindow() 
	{
		String mainID=driver.getWindowHandle();
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		String win1=it.next();
		String win2=it.next();
		
		for(String handle:handles)
		{
			if(!mainID.equals(handle)) 
			{
				driver.switchTo().window(handle);
				break;
			}
		}
	}
	
	
	
	public static WebDriverWait getWaitObject() 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		return wait;
		
	}
	
	
	public static WebElement waitforvisibility(WebElement el) 
	{
		return getWaitObject().until(ExpectedConditions.visibilityOf(el));
	}
	
	
	public static WebElement waitforclickability(WebElement el) 
	{
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(el));
	}
	
	
	public static void click(WebElement el) 
	{
		waitforvisibility(el);
		el.click();
	}
	
	
	
	public static JavascriptExecutor getJSObject() 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		return js;
	}
	
	
	public static void scrollUp(int pixel) 
	{
		
		getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
	}
	
	public static void scrollDown(int pixel) 
	{
		
		getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
		
	}
	
	
	public static void scrollToElement(WebElement el) 
	{
		
		getJSObject().executeScript("arguments[0].scrollIntoView(true)",el);
		
	}
	
	
	
	public static void JSClick(WebElement el) 
	{
		getJSObject().executeScript("arguments[0].click()",el);
	}
	
	
	public static void selectCalendarDate(List<WebElement> list, String date) 
	{
		for(WebElement el:list) 
		{
			String text=el.getText();
			
			if(text.equals(date)) 
			{
				if(el.isEnabled()) 
				{
				    el.click();
				    break;
				}else 
				{
					System.out.println("Button is not enable");
					break;
				}
				
			}else
			{
				System.out.println("Text doesnt matvh");
			}		
		}
	}
	
	
	public static byte[] takesScreenShot(String filepath) 
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constants.SCREENSHOT_FILE_PATH + filepath + getTimeStamp() + ".png";

		try 
		{
			FileUtils.copyFile(sourceFile, new File(destination));
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		byte[] pictures=ts.getScreenshotAs(OutputType.BYTES);
		
		return pictures;
 		
		
	}
	
	
	
	public static String getTimeStamp() 
	{
		Date date=new Date();
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		
		return sd.format(date);
		
	}
	
	
	
	
}
