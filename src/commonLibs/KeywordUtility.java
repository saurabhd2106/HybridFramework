package commonLibs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordUtility {	
	CommonDriver oDriver;
	
	public KeywordUtility(){
		oDriver  = new CommonDriver();
	}
	
	public String performAction(String sActionName, By oBy, String sValue){
		sActionName = sActionName.trim();
		
		if(sActionName.isEmpty()){
			return ""; 
		}
		
		if(sActionName.equalsIgnoreCase("click")){
			oDriver.click(oBy);
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("openbrowser")){
			
			oDriver.openBrowser(sValue, "about:blank");
		
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("setPageLoadTimeOut")){
			
			oDriver.setPageLoadTimeout(Long.valueOf(sValue));
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("setElementDetectionTimeout")){
			
			oDriver.setElementDetectionTimeout(Long.valueOf(sValue));
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("navigateToUrl")){
			
			oDriver.navigateTo(sValue);
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("navigateBack")){
				
			oDriver.navigateBack();
				
				
				return "";
			}
			
		if(sActionName.equalsIgnoreCase("navigateForward")){
			
			oDriver.navigateForward();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("closeAllBrowser")){
			
			oDriver.closeAllBrowser();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("closeCurrentBrowser")){
			
			oDriver.closeBrowser();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("waitTillElementIsVisible")){
			
			
			oDriver.waitTillElementVisible(oBy, Long.valueOf(sValue));
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("savepagesnapshot")){
			
			oDriver.takeSnapshot(sValue);
			
			
			return "";
		}
		
		
		if(sActionName.equalsIgnoreCase("clear")){
			
			oDriver.getDriver().findElement(oBy).clear();
			return "";
		}
		
		
		
		if(sActionName.equalsIgnoreCase("acceptAlert")){
			
			oDriver.acceptAlert();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("rejectAlert")){
			
			oDriver.rejectAlert();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("selectDefaultframe")){
			oDriver.switchToFrame(sValue);
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("gettext")){
			return oDriver.getText(oBy);
			 
		}
		
		if(sActionName.equalsIgnoreCase("getTitle")){
			return oDriver.getTitle();
			 
		}
		
		if(sActionName.equalsIgnoreCase("getUrl")){
			return oDriver.getCurrentUrl();
			 
		}
		
		if(sActionName.equalsIgnoreCase("setText")){
			 oDriver.setText(oBy, sValue);
			 return "";
		}
		
		if(sActionName.equalsIgnoreCase("getstatus")){
			return String.valueOf(oDriver.isSelected(oBy));
			 
		}
		
		
		
		if(sActionName.equalsIgnoreCase("selectitem")){
			oDriver.selectElmentByVisibleText(oBy, sValue);
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("getItemsCount")){
			Select olist;
			WebElement oElement;
			
			oElement = oDriver.getDriver().findElement(oBy);
			olist = new Select(oElement);
			
			return String.valueOf(olist.getOptions().size());
			
		}
		
		if(sActionName.equalsIgnoreCase("isvisible")){
			oDriver.isVisible(oBy);
			return ""; 
		}
		
		return "Error: Unknown keyword..";

	}

}
