package GenericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListeners implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" started",true);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+" ended",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" method FAILED",true);
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.fullPageScreenshot("./Screenshots/"+result.getName()+".png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" method SKIPPED",true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" method STARTED",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" method PASSED",true);
	}

}
