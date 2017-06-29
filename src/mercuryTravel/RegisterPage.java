package mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.DropdownControls;
import commonLibs.TextboxControls;


public class RegisterPage {
	
	@FindBy(id="registration:searchPageBody:loginInfo:userNameId")
	private WebElement emailId;
	
	@FindBy(id="registration:searchPageBody:loginInfo:pwdId")
	private WebElement password;
	
	@FindBy(id="registration:searchPageBody:personal:selectOptionForGender")
	private WebElement titleDropdown;
	
	@FindBy(id="registration:searchPageBody:personal:firstNameId")
	private WebElement firstName;
	
	@FindBy(id="registration:searchPageBody:personal:lastNameId")
	private WebElement lastname;
	
	@FindBy(id="registration:searchPageBody:personal:dateOptionId")
	private WebElement dateOfBirth;
	
	@FindBy(id="registration:searchPageBody:personal:mobileNoId")
	private WebElement mobileNumber;
	
	@FindBy(id="registration:searchPageBody:personal:address1Id")
	private WebElement addressId;
	
	@FindBy(id="registration:searchPageBody:personal:cityId")
	private WebElement cityId;
	
	@FindBy(id="registration:searchPageBody:personal:pinCodeId")
	private WebElement pinCode;
	
	@FindBy(id="registration:searchPageBody:personal:checkbox2")
	private WebElement termsAndConditionCheckBox;
	
	private TextboxControls textBox;
	private DropdownControls dropdown;
	
	public RegisterPage(WebDriver Driver) {
		
		PageFactory.initElements(Driver, this);
		textBox = new TextboxControls();
		dropdown = new DropdownControls();
	}
	
	public void registerOnMercuryTravelSite() throws Exception{
		
		textBox.setText(emailId, "saurabh.d2106@gmail.com");
		textBox.setText(password, "abc@123");
		dropdown.selectViaVisibleText(titleDropdown, "Mr");
		textBox.setText(firstName, "Saurabh");
		textBox.setText(lastname, "Dhingra");
		
		
	}
	
}
