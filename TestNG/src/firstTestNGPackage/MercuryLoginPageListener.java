package firstTestNGPackage;

import java.io.File;

import listeners.Report;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(listeners.Report.class)
public class MercuryLoginPageListener {
	
  public String appURL;
  public WebDriver driver;
  //working
	
  @BeforeTest
  public void setUP()
  {
	  appURL = "http://newtours.demoaut.com/";
  }
  
  @BeforeMethod()
  public void navigateApp() throws InterruptedException
  {
	  System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
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
  public void verifyLogin() {
	  //verifying login.
	  driver.findElement(By.name("userName")).sendKeys("narender");
	  driver.findElement(By.name("password")).sendKeys("narender");
	  driver.findElement(By.name("login")).click();
	  
	  if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			System.out.println("Flight selection page displayed successfully");
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File DestFile=new File("F:\\Selenium\\Programs\\LoginSuccess.jpg");
			screenshotFile.renameTo(DestFile);
			Assert.assertTrue(true); 	
			
		} else {
			System.out.println("Flight selection got failed");
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File DestFile=new File("F:\\Selenium\\Programs\\LoginUnSuccess.jpg");
			screenshotFile.renameTo(DestFile);
			Assert.assertTrue(false);
		}
  }
  
}
