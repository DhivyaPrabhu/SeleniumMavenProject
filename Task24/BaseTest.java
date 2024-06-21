package DemoblazeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest
{
    WebDriver driver;
    public ExtentReports extent= new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");

    @BeforeMethod
    public  void setUp()
    {
        // load chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        extent.attachReporter(spark);

    }

    @AfterMethod
    public  void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
        extent.flush();
    }

}
