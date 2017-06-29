package commonLibs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibsInterfaces.IJavaScriptExecutor;

public class JavaScriptExecutor implements IJavaScriptExecutor{
	
	private WebDriver Driver;
	
	 public JavaScriptExecutor(WebDriver Driver) {
		this.Driver = Driver;
	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		
		JavascriptExecutor jsEngine = (JavascriptExecutor) Driver; 
		
		jsEngine.executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		JavascriptExecutor jsEngine = (JavascriptExecutor) Driver; 
		
		String jsCommand = String.format("window.scrollBy(%d, %d)", x, y);
		
		jsEngine.executeScript(jsCommand);
		
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		JavascriptExecutor jsEngine = (JavascriptExecutor) Driver; 
		
		return jsEngine.executeScript(scriptToExecute).toString();
		
	}

	@Override
	public void executeAsyncJavaScript(String scriptToExecute, Object[] args) throws Exception {
		
		JavascriptExecutor jsEngine = (JavascriptExecutor) Driver; 
		if(args == null){
			jsEngine.executeScript(scriptToExecute);
		}
		
		else {
		
		jsEngine.executeAsyncScript(scriptToExecute, args);
		
		}
	}

	
}
