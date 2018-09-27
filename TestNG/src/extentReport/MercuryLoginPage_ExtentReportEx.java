package extentReport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MercuryLoginPage_ExtentReportEx {
	
  public String appURL;
  public WebDriver driver;
  
 //Extent Reporting
  public ExtentHtmlReporter htmlReporter;
  public ExtentReports extent;
  public ExtentTest test;
  String path;
  
  @BeforeTest
  public void setUP()
  {
	  appURL = "http://newtours.demoaut.com/";
      // start reporters
      htmlReporter = new ExtentHtmlReporter("./Reports/Externt_Report.html");
  
      // create ExtentReports and attach reporter(s)
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
  }
  
  @BeforeMethod()
  public void navigateApp() throws InterruptedException
  {
	  System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(appURL);
	  //Thread.sleep(5000);
	  driver.manage().window().maximize();
	  
	// creates a toggle for the given test, adds all log events under it    
     
  }
  
  @AfterMethod()
  public void closeDriver()
  {
	  driver.quit();
  }
	
  @Test
  public void verifyLoginPage() throws IOException {
	  
	  test = extent.createTest("VerifyLoginPage", "Verify application Login page");
	  test.log(Status.INFO, "This step shows usage of log(status, details)");
	  test.info("This step shows usage of info(details)");
	  
	  //verifying login page is displayed or not.
	  if (driver.findElement(By.name("userName")).isDisplayed()) {
		  path = TakeScreenShot("LoginPage_Pass");
		  test.pass("LoginPage Loaded", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		  Assert.assertTrue(true, "Login Page is displayed");
	  } else {
		  path = TakeScreenShot("LoginPage_Fail");
		  test.fail("LoginPage Not Loaded", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		  Assert.assertTrue(false, "Login Page is Not displayed");
	  }
	  
	  test.addScreenCaptureFromPath("F:\\GitRepos\\TestNGPractice\\TestNG\\ScreenShots\\LoginPage_Pass.jpg");
	  extent.flush();
  }
  
  @Test
  public void extentFail() throws IOException {
	  
	  test = extent.createTest("VerifyFailTest", "Verify application Login page");
	  test.log(Status.FAIL, "Test Fail");
	  
	  extent.flush();
  }
  
  @Test
  public void extentPass() throws IOException {
	  
	  test = extent.createTest("VerifyPassTest", "Verify application Login page");
	  test.log(Status.PASS, "Test Pass");
	  
	  extent.flush();
  }
  
  @Test
  public void verifyLogin() throws IOException {
	  //verifying login.
	  test = extent.createTest("Verify Login", "Verify application Login page");
	  
	  driver.findElement(By.name("userName")).sendKeys("narender");
	  driver.findElement(By.name("password")).sendKeys("narender");
	  driver.findElement(By.name("login")).click();
	  
	  if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
		  path = TakeScreenShot("Login_Success");
		  test.pass("Login Successful", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		  Assert.assertTrue(true); 	
			
		} else {
			test.log(Status.FAIL, "Test Fail");
			path = TakeScreenShot("Login_Unsuccess");
			test.fail("Login Unsuccessful", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			Assert.assertTrue(false);
		}
	  
	  extent.flush();
  }
  
  public String TakeScreenShot(String Name) {
	  File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File DestFile=new File("./ScreenShots/" + Name + ".jpg");
	  screenshotFile.renameTo(DestFile);
	  return new File("./ScreenShots/" + Name + ".jpg").getAbsolutePath();
  }
  
}
