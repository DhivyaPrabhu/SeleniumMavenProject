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

        //Perform Login
        loginpage.EnterUserName("PrabhuRaja");
        loginpage.EnterPassword("12345678");
        loginpage.ClickLoginButton();

        // Verify the actual result with expected result
        loginpage.verifyLogin("Log out");
    }

    @Test()
    public void testSignup()
    {
        HomePage homepageOptions=new HomePage(driver);
        SignupPage SignupPage=new SignupPage(driver);
        homepageOptions.clickSignupLink();

        // Perform signup
        SignupPage.EnterUserName("DivaPrabha50");
        SignupPage.EnterPassword("123456789");
        SignupPage.ClickSignUpButton();

        // Verify the actual result with expected result
        SignupPage.verifySignUp("Sign up successful");

    }
}
