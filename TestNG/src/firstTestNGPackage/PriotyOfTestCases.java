package firstTestNGPackage;

import org.testng.annotations.Test;

public class PriotyOfTestCases {
//working
/*  @Test
  public void Registration() {
	  System.out.println("First Registration has to be completed.");
  }
  
  @Test
  public void Login() {
	  System.out.println("Login into application after Register.");
  }
  
  @Test
  public void ChangePassword() {
	  System.out.println("Change Password after login into application.");
  }*/
  
  
  @Test(priority=1)
  public void Registration() {
	  System.out.println("First Registration has to be completed.");
  }
  
  @Test(priority=2)
  public void Login() {
	  System.out.println("Login into application after Register.");
  }
  
  @Test(priority=3)
  public void ChangePassword() {
	  System.out.println("Change Password after login into application.");
  }
  
  
}
