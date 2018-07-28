package firstTestNGPackage;

import java.io.File;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMercuryLoginPage {
	
  public String appURL;
  public WebDriver driver;
  //working
	
  @BeforeTest
  public void setUP()   {
	  appURL = "http://newtours.demoaut.com/";
  }
  
  @BeforeMethod() 
  public void navigateApp() {
	  System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(appURL);
	  driver.manage().window().maximize();
  }
  
  @AfterMethod()
  public void closeDriver() {
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] getUserCredentials() {
	  
	  Object[][] userNames = new Object[3][2];
	  
	  userNames[0][0] = "narender";
	  userNames[0][1] = "narender";
	  
	  userNames[1][0] = "Naren1";
	  userNames[1][1] = "Naren1";
	  
	  userNames[2][0] = "Karna";
	  userNames[2][1] = "Karna";
	  
	  return userNames;
  }
	
  
  @Test(dataProvider="getUserCredentials")
  public void verifyLogin(String uName, String password) {
	  //verifying login.
	  driver.findElement(By.name("userName")).sendKeys(uName);
	  driver.findElement(By.name("password")).sendKeys(password);
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
