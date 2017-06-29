package test;

import commonLibs.CommonDriver;
import commonLibs.DropdownControls;
import commonLibs.TextboxControls;
import commonLibs.WebElementControls;
import designPattern.EbayPOM1Style;

public class DemoEbayPOM1Style {

	public static void main(String[] args) {
		
			try {
				CommonDriver cmnDriver = new CommonDriver("chrome");
				TextboxControls textbox = new TextboxControls();
				DropdownControls dropdown = new DropdownControls();
				WebElementControls element = new WebElementControls();
				
				cmnDriver.openBrowser("http://www.ebay.in");
				
				EbayPOM1Style ebayHomePage = new EbayPOM1Style(cmnDriver.getDriver());
				textbox.setText(ebayHomePage.searchBox, "Apple Watches");
				dropdown.selectViaVisibleText(ebayHomePage.searchDropdown, "Watches");
				
				element.click(ebayHomePage.searchButton);
				
				cmnDriver.closeBrowser();
				
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			
			

	}

}
