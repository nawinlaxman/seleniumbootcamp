package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentBasicReport {

	public static void main(String[] args) {
	
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ExtentBasicReport.html");
		extent.attachReporter(spark);
		extent.createTest("Test case 001").pass("step passed");
		extent.createTest("Test case 002").fail("step failed");
		extent.createTest("Test case 003").info("information provided");
		
		ExtentTest test004 = extent.createTest("Test case 004");
		test004.log(Status.PASS, "teststep is passed");
		test004.log(Status.WARNING, " warning appeared");
		test004.log(Status.PASS,"teststep is passed");
		
		
		ExtentTest test005 = extent.createTest("Test case 005");
		ExtentTest node = test005.createNode("test case 005");
		node.log(Status.PASS, "step1 passed");
		node.log(Status.PASS, "step2 passed");
		node.log(Status.PASS,MarkupHelper.createLabel("step3 passed", ExtentColor.GREEN));
		
		extent.flush();
	}

}
