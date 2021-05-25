package runner;

import com.aventstack.extentreports.gherkin.model.Feature;

import utils.ExtentReportUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utils.Base.features;

import java.io.IOException;

/**
 * @author 
 * 
 */

public class TestNGListener implements ITestListener {

    ExtentReportUtil extentReportUtil = new ExtentReportUtil();
    
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("On test Sucess");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");

        try{
            extentReportUtil.ExtentReportScreenshot();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
        try{
            extentReportUtil.ExtentReportScreenshot();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");

        extentReportUtil.ExtentReport();

        features = extentReportUtil.extent.createTest(Feature.class, "Login Feature");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
        extentReportUtil.FlushReport();
    }
}
