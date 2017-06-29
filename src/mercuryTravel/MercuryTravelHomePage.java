package mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.ActionControl;
import commonLibs.CommonDriver;
import commonLibs.TextboxControls;
import commonLibs.WebElementControls;

public class MercuryTravelHomePage {
	
	@FindBy (linkText="Flights")
	private WebElement flightLink;
	
	
	@FindBy (linkText="Hotels")
	private WebElement hotelLink;
	
	//Complete other WebElements
	
	@FindBy(linkText="Customer Login")
	private WebElement customerLogin;
	
	
	@FindBy(linkText="User Login")
	private WebElement userLogin;
	
	
	@FindBy(linkText="Register")
	private WebElement RegisterLink;
	
	
	@FindBy(id="sign_user_email")
	private WebElement userEmailId;
	
	@FindBy(id="sign_user_password")
	private WebElement userPassword;
	
	@FindBy(xpath="//div[@id='modalLogin']//form[@class='form-signin']//button")
	private WebElement loginButton;
	
	@FindBy(id="(//a[@class='dropdown-toggle'])[4]")
	private WebElement welcomeText;
	
	private WebElementControls element;
	
	private ActionControl action;
	
	private TextboxControls textbox;
	
	
	
	public MercuryTravelHomePage(WebDriver Driver) {
		element = new WebElementControls();
		action = new ActionControl(Driver);
		textbox = new TextboxControls();
		PageFactory.initElements(Driver, this);
	}
	
	public void userLogin(String emailId, String password) throws Exception{
		
		moveToLogin();
		
		element.click(userLogin);
		
		textbox.setText(userEmailId, emailId);
		
		textbox.setText(userPassword, password);
		
		element.click(loginButton);
	}
	
	
	
	private void moveToLogin() throws Exception{
		action.moveToElement(customerLogin);
	}
	
	public String getWelcomeText() throws Exception{
		return element.getText(welcomeText);
	}
}
