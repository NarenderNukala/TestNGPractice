package firstTestNGPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercuryLoginPageCrossBrowser {
	
  public String appURL;
  public WebDriver driver;
  //working.  Need to run through LoginCrossBrowser.xml (TestSuite)
	
  @BeforeTest
  public void setUP()
  {
	  appURL = "http://newtours.demoaut.com/";
	  System.setProperty("webdriver.chrome.driver","F:\\Software\\chromedriver_win32\\chromedriver.exe");
	  System.setProperty("webdriver.gecko.driver","F:\\Software\\geckodriver.exe");  
	  System.setProperty("webdriver.ie.driver","F:\\Software\\IEDriverServer.exe");
  }
  
  @BeforeMethod()
  @Parameters({"Browser"})
  public void navigateApp(String brw) throws InterruptedException
  {
	  if (brw.equalsIgnoreCase("Firefox")) driver = new FirefoxDriver();
	  if (brw.equalsIgnoreCase("Chrome")) driver = new ChromeDriver();
	  if (brw.equalsIgnoreCase("IE")) driver = new InternetExplorerDriver();
	  driver.get(appURL);
	  //Thread.sleep(5000);
	  driver.manage().window().maximize();
  }
  
  @AfterMethod()
  public void closeDriver()
  {
	  driver.quit();
  }
	
  @Test
  public void verifyLoginPage() {
	  //verifying login page is displayed or not.
	  if (driver.findElement(By.name("userName")).isDisplayed()) {
		  Assert.assertTrue(true, "Login Page is displayed");
	  } else {
		  Assert.assertTrue(false, "Login Page is Not displayed");
	  }
  }
  
  @Test
  @Parameters({"userName","password"})
  public void verifyLogin(String uName, String passwd) {
	  //verifying login.
	  driver.findElement(By.name("userName")).sendKeys(uName);
	  driver.findElement(By.name("password")).sendKeys(passwd);
	  driver.findElement(By.name("login")).click();
	  
	  if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			System.out.println("Flight selection page displayed successfully");
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\ScrSheet\\LoginSuccess.jpg");
			screenshotFile.renameTo(DestFile);
			Assert.assertTrue(true); 	
			
		} else {
			System.out.println("Flight selection got failed");
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\ScrSheet\\LoginUnSuccess.jpg");
			screenshotFile.renameTo(DestFile);
			Assert.assertTrue(false);
		}
  }
  
}
