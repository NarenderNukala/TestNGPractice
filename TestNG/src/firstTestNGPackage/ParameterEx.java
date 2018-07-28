package firstTestNGPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterEx {
  
	  public String appURL;
	  public WebDriver driver;
	  //working
		
	  @BeforeTest
	  public void setUP()
	  {
		  appURL = "http://newtours.demoaut.com/";
	  }
	  
	  @BeforeMethod()
	  public void navigateApp()
	  {
		  System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get(appURL);
		  driver.manage().window().maximize();
	  }
	  
	  @AfterMethod()
	  public void closeDriver()
	  {
		  driver.quit();
	  }
	  
	@Test
	@Parameters({ "userName", "password1" })
	public void verifyLogin(String uName, String passWd) {
		// verifying login.
		driver.findElement(By.name("userName")).sendKeys(uName);
		driver.findElement(By.name("password")).sendKeys(passWd);
		driver.findElement(By.name("login")).click();

		if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			System.out.println("Flight selection page displayed successfully");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File DestFile = new File("F:\\Selenium\\Programs\\LoginSuccess.jpg");
			screenshotFile.renameTo(DestFile);
			Assert.assertTrue(true);

		} else {
			System.out.println("Flight selection got failed");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File DestFile = new File("F:\\Selenium\\Programs\\LoginUnSuccess.jpg");
			screenshotFile.renameTo(DestFile);
			Assert.assertTrue(false);
		}
	}
	 
/*	 @Test  //optional parameter
	 @Parameters({"userName","password1", "password123"})
	 public void paramsEx(String uName,String passWd, @Optional("mysql") String suiteParam) {
		 System.out.println("Parameter Example");
		 System.out.println("Test Parameter1 : " + uName);
		 System.out.println("Test Parameter2 : " + passWd);
		 System.out.println("Suite Parameter1 : " + suiteParam);
	 }*/
	 
/*	 @Test  //parameter name should be same as in the xml
	 @Parameters({"userName","appPassword"})
	 public void paramsExOpt(String uName, String passWd) {
		 System.out.println("Parameter Example");
		 System.out.println("Test Parameter1 : " + uName);
		 System.out.println("Test Parameter2 : " + passWd);
	 }*/
	 
/*	 @Test
	 @Parameters({"userName","appPassword"})
	 public void paramsExOpt1(String uName, @Optional("defPassword") String passWd) {
		 System.out.println("Parameter Example");
		 System.out.println("Test Parameter1 : " + uName);
		 System.out.println("Test Parameter2 : " + passWd);
	 }*/
	
}
