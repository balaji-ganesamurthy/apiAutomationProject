package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports =
            ExtentReportManager.getExtentReports();

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extentReports.createTest(result.getName());

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());
    }
    
    @Override
    public void onFinish(org.testng.ITestContext context) {
        extentReports.flush();
    }
}