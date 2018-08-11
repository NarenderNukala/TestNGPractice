package firstTestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryLoginPageGrpIds {
	
  public String appURL;
  public WebDriver driver;
  //Working
	
  @BeforeTest
  public void setUP()
  {
	  appURL = "http://newtours.demoaut.com/";
	  System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(appURL);
	  //Thread.sleep(5000);
	  driver.manage().window().maximize();
  }
  
 	
  @Test(groups = { "Sanity" })
  public void verifyLoginPage() {
	  
	  System.out.println("Sanity1 Method");
	  
/*	  //verifying login page is displayed or not.
	  if (driver.findElement(By.name("userName")).isDisplayed()) {
		  Assert.assertTrue(true, "Login Page is displayed");
	  } else {
		  Assert.assertTrue(false, "Login Page is Not displayed");
	  }*/
  }
  
  @Test(groups = { "Sanity" })
  public void verifyLoginPage1() {
	 System.out.println("Sanity2 Method");
  }
  
  @Test(groups = { "Regression" })
  public void verifyLogin() {
	  
	  System.out.println("Regression Method");
	  
	 /* //verifying login.
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
		}*/
  }
  
}
