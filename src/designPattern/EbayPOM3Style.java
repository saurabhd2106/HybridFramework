package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.DropdownControls;
import commonLibs.TextboxControls;
import commonLibs.WebElementControls;

public class EbayPOM3Style {
	
	@CacheLookup
	@FindBy(id="gh-ac")
	private WebElement searchBox;
	
	@CacheLookup
	@FindBy(id="gh-cat")
	private WebElement searchCategory;
	
	@CacheLookup
	@FindBy(id="gh-btn")
	private WebElement searchButton;
	
	@FindBy(className="listingscnt")
	private WebElement result;
	
	TextboxControls textbox;
	
	WebElementControls element;
	
	DropdownControls dropdown;
	
	public EbayPOM3Style(WebDriver Driver) {
		
		PageFactory.initElements(Driver, this);
		textbox = new TextboxControls();
		element = new WebElementControls();
		dropdown = new DropdownControls();
		
		}
	
	public void searchItem(String product, String category) throws Exception {
		textbox.setText(searchBox, product);
		dropdown.selectViaVisibleText(searchCategory, category);
		element.click(searchButton);
		
		String resultFromElement = element.getText(result);
		
		System.out.println("Result :: "+ resultFromElement);
		
	}
}
