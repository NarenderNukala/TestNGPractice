
package firstTestNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	//working
	public String appURL;
	public WebDriver driver;
	
  @Test
  public void homePageTitle() throws InterruptedException {
	  
	 /* //access specifiers will not be supported in testNG within the test method */
	 /* public String appURL;
	  public WebDriver driver;*/
	  
	  String appURL;
	  WebDriver driver;
	  
	  appURL = "http://newtours.demoaut.com/";
	  System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.get(appURL);
	  Thread.sleep(5000);
	  String expValue = "Welcome: Mercury Tours";
	  String actValue = driver.getTitle();
	  Assert.assertEquals(actValue, expValue);
	  driver.quit();
  }
}
