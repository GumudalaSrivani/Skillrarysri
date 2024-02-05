package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Starts");
	}


	@Override
	public void onTestStart(ITestResult result) {
      System.out.println(result.getMethod().getMethodName()+"Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Fail");
	System.out.println("Failed due to:"+result.getThrowable());
	WedDriverUtility web = new WedDriverUtility();
	web.captureScreenshot(BaseClass.sdriver,result.getMethod().getMethodName(),BaseClass.sjutil);
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	
	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
