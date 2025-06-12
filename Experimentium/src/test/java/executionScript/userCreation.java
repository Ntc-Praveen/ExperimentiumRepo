package executionScript;

import org.testng.annotations.Test;

import GenericLib.BaseTest;
import chemicalExperiment.UsersEntry;

public class userCreation extends BaseTest{
	
	@Test
	public void userEntries() throws Throwable
	{
		UsersEntry ue=new UsersEntry();
		ue.EnterData();
		Thread.sleep(2000);
	    ue.roleBased();
		Thread.sleep(2000);
		//ue.Test();
		
		
	}
	
	
	
	

}
