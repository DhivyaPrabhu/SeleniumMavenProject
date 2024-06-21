package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNgListener implements ITestListener
{

    public ExtentReports extent= new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("D:\\Intelli workspace\\TestNgwithExtent\\test-output\\ExtentReport.html");
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest("Verify Sign up and Login").assignAuthor("Dhivya Prabhu").assignCategory("FunctionalTesting").assignDevice("Windows");
        extent.attachReporter(spark);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext arg) {
        System.out.println("Starts Test Execution"+arg.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
