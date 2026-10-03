package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("reports/API-Automation-Report.html");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);
        }

        return extentReports;
    }
}