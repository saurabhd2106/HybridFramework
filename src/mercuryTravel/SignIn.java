package mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.TextboxControls;
import commonLibs.WebElementControls;

public class SignIn {
	
	@FindBy(id="loginform:loginBody:loginMainBody:userId")
	private WebElement emailId;
	
	@FindBy(id="loginform:loginBody:loginMainBody:passwordId")
	private WebElement password;
	
	@FindBy(className="bookButtonlogin")
	private WebElement signInButton;
	
	@FindBy(id="frm:Header:loginMainHeader:signOutL")
	private WebElement signOutButton;
	
	
	private TextboxControls textbox;
	private WebElementControls element;
	
	public SignIn(WebDriver Driver){
		textbox = new TextboxControls();
		element = new WebElementControls();
		PageFactory.initElements(Driver, this);
	}
	
	public void loginToMercury(String email, String pass) throws Exception{
		
		textbox.setText(emailId, email);
		textbox.setText(password, pass);
		element.click(signInButton);
		
	}
	
	public void signOut() throws Exception {
		element.click(signOutButton);
	}
	
}
