package Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GridExample1 {
	private WebDriver driver, driver1;
	private String baseUrl;

   @BeforeMethod
   public void setUp() throws MalformedURLException {
	   System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
      URL hubUrl = new URL("http://localhost:4441/wd/hub");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName("chrome");
      capabilities.setPlatform(Platform.WINDOWS);

      driver = new RemoteWebDriver(hubUrl, capabilities);
      baseUrl = "http://www.google.com/";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
   }

   @Test
   public void windowsTest() {
      driver.get(baseUrl);
      driver.findElement(By.id("gbqfq")).clear();
      driver.findElement(By.id("gbqfq")).sendKeys("Narender");
      driver.findElement(By.id("gbqfb")).click();
   }
   
   @Test
   public void titleVerifcation() {
	  String appURL = "http://newtours.demoaut.com/";
	  driver.get(appURL);
	  String expValue = "Welcome: Mercury Tours";
	  String actValue = driver.getTitle();
	  Assert.assertEquals(actValue, expValue);
   }
   
   @Test
   public void loginPageVerification() {
	   String appURL = "http://newtours.demoaut.com/";
	   driver.get(appURL);
	   if (driver.findElement(By.name("userName")).isDisplayed()) {
		  Assert.assertTrue(true, "Login Page is displayed");
	   } else {
		  Assert.assertTrue(false, "Login Page is Not displayed");
	   }
   }

   @AfterMethod
   public void tearDown() {
      driver.quit();
   }
   
   
}
