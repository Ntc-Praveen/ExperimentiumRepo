package chemicalExperiment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.BaseTest;
import GenericLib.FileLib;
import GenericLib.WebDriverCommonLib;

public class searchPage {

	@FindBy(xpath="//span[text()='Ce']")private WebElement chExeperiments;  
	@FindBy(xpath="//input[@id='exp_search_res']")private WebElement searchBox;
	@FindBy(xpath="//label[@for='tags_cat2']")  private WebElement inPerson; 
	@FindBy(xpath="//label[@for='tags_cat1']")  private WebElement Remote;
	@FindBy(xpath="//label[@for='tags_cat18']") private WebElement inChemistry;
	@FindBy(xpath="//label[@for='tags_cat19']") private WebElement geChemistryI;
	@FindBy(xpath="//label[@for='tags_cat20']") private WebElement geChemistryII;
	@FindBy(xpath="//label[@for='tags_cat21']") private WebElement OrChemistry;
	@FindBy(xpath="//label[@for='tags_cat22']") private WebElement bioChemistry;
	@FindBy(xpath="//label[@for='tags_cat300']") private WebElement hRequired;
	@FindBy(xpath="//label[@for='tags_cat305']") private WebElement benchTop;
	@FindBy(xpath="//label[@for='tags_cat17']") private WebElement lowAnywhere;
	@FindBy(xpath="//label[@for='tags_cat23']") private WebElement moderateinLab;
	@FindBy(xpath="//label[@for='tags_cat24']") private WebElement highFumehood;
	
	@FindBy(xpath="//label[@for='tags_cat293']") private WebElement sheatingPlate;
	@FindBy(xpath="//label[@for='tags_cat284']") private WebElement  ledLights;
	@FindBy(xpath="//label[@for='tags_cat285']") private WebElement  Buzzer;
	@FindBy(xpath="//label[@for='tags_cat292']") private WebElement  stuartSMP10orDigiment;
	@FindBy(xpath="//label[@for='tags_cat301']") private WebElement  vacuumLineorpump;
	@FindBy(xpath="//label[@for='tags_cat301']") private WebElement  labJack;
	@FindBy(xpath="//label[@for='tags_cat311']") private WebElement  hmantleandController;
	@FindBy(xpath="//label[@for='tags_cat3']") private WebElement  Basic;
	@FindBy(xpath="//label[@for='tags_cat4']") private WebElement  Probes;
	//@FindBy(xpath="//label[@for='sub_tags_cat6']") private WebElement  Ph;
	//@FindBy(xpath="//label[@for='sub_tags_cat6']") private WebElement  Ph;
	
	
	public WebElement getLowAnywhere() {
		return lowAnywhere;
	}

	public WebElement getModerateinLab() {
		return moderateinLab;
	}

	public WebElement getHighFumehood() {
		return highFumehood;
	}
	
	public WebElement getBenchTop() {
		return benchTop;
	}
	
	public WebElement gethRequired() {
		return hRequired;
	}
	
	public WebElement getChExeperiments() {
		return chExeperiments;
	}
	public WebElement getBioChemistry() {
		return bioChemistry;
	}
	
	public WebElement getGeChemistryII() {
		return geChemistryII;
	}
	public WebElement getGeChemistryI() {
		return geChemistryI;
	}
	public WebElement getInChemistry() {
		return inChemistry;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getchExeperiments()
	{
		return chExeperiments;
		
	}
	public WebElement getOrChemistry() {
		return OrChemistry;
	}
	public searchPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	
	public void Experiments() throws InterruptedException
	{
		Thread.sleep(2000);
		chExeperiments.click();
	}
	public WebElement getRemote() {
		return Remote;
	}
	
	FileLib fl = new FileLib();
	WebDriverCommonLib wc = new WebDriverCommonLib();
	
	public void readData() throws Throwable
	{
		
		String filePath = "C:\\Users\\dell\\eclipse-workspace\\Experimentium\\Data\\Excelone.xlsx.";
		String sheetName = "sheet1";

		// Step 1: Read search data and perform search
		String data = fl.readExcelData(filePath, sheetName, 1, 1);
		System.out.println("Data at row(1,2) is: " + data);
		Thread.sleep(2000);
		searchBox.sendKeys(data);
		Thread.sleep(2000);

		// Step 2: Take full page screenshot
		wc.fullPageScreenshot("./Screenshots/" + "Chemicalexperiments" + ".png");
		Thread.sleep(5000);

		// Step 3: Compare multiple elements in a loop
		WebElement[] elements = { inPerson, Remote };
		int[] excelRows = { 2, 3 };

		for (int i = 0; i < elements.length; i++) {
		    WebElement currentElement = elements[i];
		    String elementText = currentElement.getText();
		    String excelData = fl.readExcelData(filePath, sheetName, excelRows[i], 1);

		    System.out.println("/name is: " + excelData);

		    if (excelData.equals(elementText)) {
		        System.out.println("Element text matched: " + elementText);
		        currentElement.click();
		        Thread.sleep(5000);
		    } else {
		        System.out.println("Element not found in Excel: " + elementText);
		    }
		}
		

		
	}
	public void SelectCouse() throws Throwable 
	{
		//FileLib fl=new FileLib();
		String filePath="C:\\Users\\dell\\eclipse-workspace\\Experimentium\\Data\\Excelone.xlsx.";
		String sheetName="sheet1";
		WebElement[] elements= {inChemistry, geChemistryI, geChemistryII, OrChemistry, bioChemistry};
		int[] rowIndices = { 4, 5, 6, 7, 8 };
		
		for(int i=0; i<elements.length; i++)
		{
			
			String data=fl.readExcelData(filePath, sheetName, rowIndices[i], 1);
			System.out.println("Excel sheet values is :"+ data);
			WebElement element=elements[i];
			String elementText=element.getText();
			System.out.println("element Text is :"+ elementText);
			if(data != null && data.equals(elementText) )
			{
				System.out.println("boolen values is : True");
				element.click();
			}
			else
			{
				System.out.println("Excel sheet value is not matched");
			}
		}

	}
	
	public void Hazardlevel() throws Throwable
	{
		//FileLib fl=new FileLib();
		String filePath="C:\\Users\\dell\\eclipse-workspace\\Experimentium\\Data\\Excelone.xlsx.";
		String sheetName="sheet1";
		WebElement[] elements= {hRequired, benchTop, lowAnywhere, moderateinLab, highFumehood};
		int[] rowIndices = { 9, 10, 11, 12, 13 };
		
		for(int i=0; i<elements.length; i++)
		{
			String data=fl.readExcelData(filePath, sheetName, rowIndices[i], 1);
			System.out.println("Excel sheet value is: " + data);
			WebElement element=elements[i];
			String elementText=element.getText();
			System.out.println("Element text is: " + elementText);
			
			if(data!=null && data.equals(elementText))
			{
				System.out.println("Boolean value is: true"); 
				element.click();
			}
			else
			{
				System.out.println("There is no value in the sheet or it doesn't match");
			}
		}
	}
	
}
