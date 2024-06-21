package DemoblazeTest;

import DemoblazePages.HomePage;
import DemoblazePages.LoginPage;
import DemoblazePages.SignupPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class MainTest extends BaseTest
{
    @Test(priority = 1)
    public void testLogin()
    {
        HomePage homepageOptions = new HomePage(driver);
        LoginPage loginpage = new LoginPage(driver);
        homepageOptions.clickLoginLink();
        ExtentTest test= extent.createTest("Verify Login").assignAuthor("Dhivya Prabhu").assignCategory("FunctionalTesting").assignDevice("Windows");
        try {
            //Perform Login
            loginpage.EnterUserName("PrabhuRaja");
            loginpage.EnterPassword("12345678");
            loginpage.ClickLoginButton();

            // Verify the actual result with expected result
            loginpage.verifyLogin("Log out");

            //Validating Login function -Extent Report
            test.log(Status.PASS, "Login Successful");
            test.pass("login Verfied");
        }
        catch (Exception e)
        {
            test.log(Status.FAIL,"Login not Successful");
            test.fail(" Wrong id or password Entered");
        }
    }

    @Test()
    public void testSignup()
    {
        HomePage homepageOptions=new HomePage(driver);
        SignupPage SignupPage=new SignupPage(driver);
        homepageOptions.clickSignupLink();
        ExtentTest test= extent.createTest("Verify Sign up").assignAuthor("Dhivya Prabhu").assignCategory("FunctionalTesting").assignDevice("Windows");
        try {
            // Perform signup
            SignupPage.EnterUserName("DivaPrabha46");
            SignupPage.EnterPassword("123456789");
            SignupPage.ClickSignUpButton();

            // Verify the actual result with expected result
            SignupPage.verifySignUp("Sign up successful");

            //Validating SignUp function -Extent Report
            test.log(Status.PASS, "Sign up Successful");
            test.pass("Sign up Verified");
        }
        catch (AssertionError e) {
            test.log(Status.FAIL, "Sign up not Successful");
            test.fail("The User is Existing already or Sign up failed: " + e.getMessage());
            throw e; // Rethrow the assertion error to fail the test
        } catch (Exception e) {
            test.log(Status.FAIL, "Sign up not Successful");
            test.fail("Unexpected error occurred: " + e.getMessage());
        }

    }
}
