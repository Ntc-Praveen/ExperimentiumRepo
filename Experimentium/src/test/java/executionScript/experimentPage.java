package executionScript;

import org.testng.annotations.Test;
import GenericLib.BaseTest;
import chemicalExperiment.searchPage;

public class experimentPage extends BaseTest{
    
	@Test
	public  void ExperimentsTab() throws Throwable
		
	{
		  
		  searchPage sp=new searchPage();
		  Thread.sleep(10000);
		  sp.Experiments();
		  Thread.sleep(2000);
		  sp.readData();
		  Thread.sleep(2000);
		  sp.SelectCouse();
		  Thread.sleep(2000);
		  sp.Hazardlevel();

	}

}
