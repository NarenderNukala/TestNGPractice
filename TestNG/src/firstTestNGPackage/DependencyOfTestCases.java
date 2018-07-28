package firstTestNGPackage;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyOfTestCases {
//working
  @Test
  public void Registration() {
	  System.out.println("First Registration has to be completed.");
	  //Assert.assertTrue(false); 
  }
  
  @Test(dependsOnMethods={"Registration"})
  public void Login() {
	  System.out.println("Login into application after Register.");
  }
  
  @Test(dependsOnMethods={"Registration","Login"})
  public void ChangePassword() {
	  System.out.println("Change Password after login into application.");
  }
  
}
