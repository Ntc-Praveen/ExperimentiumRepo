package chemicalExperiment;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.BaseTest;
import GenericLib.FileLib;

public class UsersEntry {
	
	@FindBy(xpath="//input[@id='user_login']")private WebElement userName ; 
	@FindBy(xpath="//input[@id='user_pass']")private WebElement userPassword;
	@FindBy(xpath="//input[@id='wp-submit']")private WebElement Login;
	@FindBy(xpath="//input[@id='submit']")private WebElement Authenticate;
	@FindBy(xpath="//div[text()='Users']")private WebElement Users;
	@FindBy(xpath="//a[text()='Add New User']")private WebElement addUser;
	@FindBy(xpath="//input[@id='user-search-input']") private WebElement searchFiled;
	
	@FindBy(xpath="//input[@id='search-submit']")private WebElement SearchButton;
	//@FindBy(xpath="//td[contains(@class, 'username')]//a[text()='")private WebElement searchedUsername;
	@FindBy(xpath="//td[@data-colname='Email']")private WebElement searchedUIEmail;
	
	
	@FindBy(xpath="//input[@id='user_login']")private WebElement usernameField;
	@FindBy(xpath="//input[@id='email']")private WebElement emailIdField;
	@FindBy(xpath="//input[@id='first_name']")private WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']")private WebElement lastName;
	@FindBy(xpath="//input[@class='pw-checkbox']")private WebElement passCheckbox;
	
	@FindBy(xpath="//label[@for='aam_user_role_administrator']")private WebElement Administrator;
	@FindBy(xpath="//label[@for='aam_user_role_editor']")private WebElement Editor;
	@FindBy(xpath="//label[@for='aam_user_role_author']")private WebElement Author;
	@FindBy(xpath="//label[@for'aam_user_role_contributor']")private WebElement Contributor;
	@FindBy(xpath="//label[@for='aam_user_role_subscriber']")private WebElement Subscriber;
	@FindBy(xpath="//label[@for='aam_user_role_accountabilityresearchandcompliance']")private WebElement Compliance;
	@FindBy(xpath="//label[@for='aam_user_role_sciencesocialstudiesandmtss']")private WebElement Mtss;
	@FindBy(xpath="//label[@for='aam_user_role_businessoperations']")private WebElement Operations;
	@FindBy(xpath="//label[@for'aam_user_role_superintendent']")private WebElement Superintendent;
	@FindBy(xpath="//label[@for='aam_user_role_mathematics']")private WebElement Mathematics;
	@FindBy(xpath="//label[@for='aam_user_role_literacyandlanguage']")private WebElement Literacyandlanguage;
	@FindBy(xpath="//label[@for='aam_user_role_datacenterandnetworksolutions']")private WebElement Datacenterandnetworksolutions;
	@FindBy(xpath="//label[@for='aam_user_role_specialeducation']")private WebElement specialeducation;	
	@FindBy(xpath="//label[@for='aam_user_role_procurement']")private WebElement procurement;
	@FindBy(xpath="//label[@for='aam_user_role_alumni_net']")private WebElement alumniNet;
	@FindBy(xpath="//label[@for='aam_user_role_charterschools']")private WebElement CharterSchools;
	@FindBy(xpath="//label[@for='aam_user_role_suptmember']")private WebElement SuptMember;
	@FindBy(xpath="//label[@for='aam_user_role_peimsln']")private WebElement peimsln;
	@FindBy(xpath="//label[@for='aam_user_role_transinstructors']")private WebElement transinstructors;
	@FindBy(xpath="//label[@for='aam_user_role_transproctors']")private WebElement transproctors;
	
	@FindBy(xpath="//input[@id='pass1']")private WebElement passWord;
	@FindBy(xpath="//input[@id='createusersub']")private WebElement saveUser;
	
	public WebElement getSearchFiled() {
		return searchFiled;
	}
	public WebElement getSearchButton() {
		return SearchButton;
	}
	public WebElement getSearchedUsername() {
		return searchedUIEmail;
	}

	
	public WebElement getAddUser() {
		return addUser;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getUserPassword() {
		return userPassword;
	}
	public WebElement getLogin() {
		return Login;
	}
	public WebElement getUsers() {
		return Users;
	}
	
	public UsersEntry()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void EnterData() throws InterruptedException
	{
		Thread.sleep(2000);
		userName.sendKeys("user");
		Thread.sleep(2000);
		userPassword.sendKeys("8ISfVGolJ@rF");
		Thread.sleep(5000);
		Login.click();
		//Thread.sleep(10000);
		//Authenticate.click();
		Users.click();
		Thread.sleep(3000);
		addUser.click();
		//Thread.sleep(3000);
		
    }
	
	public void roleBased() throws Throwable
	{
		FileLib fl = new FileLib();

		// Path to the Excel file and sheet name
		String filePath = "C:\\Users\\dell\\eclipse-workspace\\Experimentium\\Data\\Live users.xlsx";
		String sheetName = "Sheet1";
		Map<String, WebElement> validationMap = new HashMap<>();
		validationMap.put("alumniNet", alumniNet);
		validationMap.put("peimsln", peimsln);
		validationMap.put("Administrator", Administrator);
		validationMap.put("Editor", Editor);
		validationMap.put("Transinstructors", transinstructors);
		validationMap.put("CharterSchools", CharterSchools);
	    validationMap.put("SuptMember", SuptMember);
	    validationMap.put("Transproctors", transproctors);
	    validationMap.put("Transinstructors,Transproctors",transproctors);
	    validationMap.put("CharterSchools,SuptMember",CharterSchools);

		// Loop through users
		for (int i = 1; i <= 725; i++) {
		    // Read user data from Excel
		    String data1 = fl.readExcelData(filePath, sheetName, i, 3); // Username
		    String data2 = fl.readExcelData(filePath, sheetName, i, 2); // Email
		    String data3 = fl.readExcelData(filePath, sheetName, i, 0); // First Name
		    String data4 = fl.readExcelData(filePath, sheetName, i, 1); // Last Name
		    String data5 = fl.readExcelData(filePath, sheetName, i, 4); // Validation key (e.g., "alumniNet")

		    // Send values to fields
		    usernameField.sendKeys(data1);
		    emailIdField.sendKeys(data2);
		    firstName.sendKeys(data3);
		    lastName.sendKeys(data4);
		    Thread.sleep(1000);
		    passWord.clear();
		    Thread.sleep(3000);
		    passWord.sendKeys("Ntc@1234");
		    Thread.sleep(2000);
		    passCheckbox.click();
		    Thread.sleep(3000); 
		    // Step 2: Use validation text to find the correct WebElement
		    WebElement validationElement = validationMap.get(data5);
		    

		    if (validationElement != null) {
		        try {
		            Thread.sleep(2000);
		            validationElement.click(); // Click the validation option
		            Thread.sleep(2000);
		            saveUser.click(); // Save user
		            System.out.println(data1 + " User is created successfully");
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("Validation option not found for: " + data5 + " => " + data1 + " User is not created");
		    }

		    // Wait before next user (optional)
		    try {
		        Thread.sleep(5000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

		    // Click 'Add User' to prepare for next entry
		    addUser.click();
		}
	}
	 public void Test() throws Throwable
	 {
		 
		 FileLib fl = new FileLib();

		    String filePath = "C:\\Users\\dell\\eclipse-workspace\\Experimentium\\Data\\Usercreations.xlsx";
		    String sheetName = "Sheet1";

		    Map<String, WebElement> validationMap = new HashMap<>();
		    validationMap.put("alumniNet", alumniNet);
		    validationMap.put("peimsln", peimsln);
		    validationMap.put("Administrator", Administrator);
		    validationMap.put("Editor", Editor);
		    validationMap.put("Transinstructors", transinstructors);
		    validationMap.put("CharterSchools", CharterSchools);
		    validationMap.put("SuptMember", SuptMember);
		    validationMap.put("Transproctors", transproctors);
		    validationMap.put("Transinstructors,Transproctors", transproctors);
		    validationMap.put("CharterSchools,SuptMember", CharterSchools);
		    for (int i = 1; i <= 3; i++) {
		        String data1 = fl.readExcelData(filePath, sheetName, i, 3); // Username
		        String data2 = fl.readExcelData(filePath, sheetName, i, 2); // Email
		        String data3 = fl.readExcelData(filePath, sheetName, i, 0); // First Name
		        String data4 = fl.readExcelData(filePath, sheetName, i, 1); // Last Name
		        String data5 = fl.readExcelData(filePath, sheetName, i, 4); // Role
		        searchFiled.clear();
		        searchFiled.sendKeys(data2);
		        SearchButton.click();
		        Thread.sleep(2000); // Replace with WebDriverWait if possible

		        try {
		            // Try to find existing user email in the results
		            WebElement searchedEmail = searchedUIEmail;
		            String  searchedEmail1 =searchedEmail.getText();
		            System.out.println("element Text:"+ searchedEmail1);
		            if (data2.equals(searchedEmail1)) {
		                System.out.println(data1 + " already exists. Skipping creation.");
		                // continue;  // if inside loop
		            } else if(searchedEmail1=="no such element: Unable to locate element") {
		                System.out.println(data1 + " email not matching, treating as new user.");
		                //System.out.println(data1 + " not found. Proceeding to create user.");
			            // Now create the user
			            addUser.click();
			            usernameField.sendKeys(data1);
			            emailIdField.sendKeys(data2);
			            firstName.sendKeys(data3);
			            lastName.sendKeys(data4);
			            Thread.sleep(1000);
			            passWord.clear();
			            Thread.sleep(3000);
			            passWord.sendKeys("Ntc@1234");
			            Thread.sleep(2000);
			            passCheckbox.click();
			            Thread.sleep(3000);

			            WebElement validationElement = validationMap.get(data5);
			            if (validationElement != null) {
			                Thread.sleep(2000);
			                validationElement.click();
			                Thread.sleep(2000);
			                saveUser.click();
			                System.out.println(data1 + " User is created successfully");
			            } else {
			                System.out.println("Validation option not found for: " + data5);
			            }

			            // Optionally wait or refresh after creation
			            Thread.sleep(3000);
			        }
		            }
		           
		           
	
		         catch (NoSuchElementException e) {
		            System.out.println(data1 + " not found. Proceeding to create user.");
		            // Now create the user
		            addUser.click();
		            usernameField.sendKeys(data1);
		            emailIdField.sendKeys(data2);
		            firstName.sendKeys(data3);
		            lastName.sendKeys(data4);
		            Thread.sleep(1000);
		            passWord.clear();
		            Thread.sleep(3000);
		            passWord.sendKeys("Ntc@1234");
		            Thread.sleep(2000);
		            passCheckbox.click();
		            Thread.sleep(3000);

		            WebElement validationElement = validationMap.get(data5);
		            if (validationElement != null) {
		                Thread.sleep(2000);
		                validationElement.click();
		                Thread.sleep(2000);
		                saveUser.click();
		                System.out.println(data1 + " User is created successfully");
		            } else {
		                System.out.println("Validation option not found for: " + data5);
		            }

		            // Optionally wait or refresh after creation
		            Thread.sleep(3000);
		        }

		        // Optional: refresh table/search or prepare for next loop
		    }
		    
		        
	            
	        
		        
	     
	 }
	 

}
