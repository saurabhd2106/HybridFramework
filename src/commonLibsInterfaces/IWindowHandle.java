package commonLibsInterfaces;

import java.util.Set;

public interface IWindowHandle {
	
	public void switchToChildWindow() throws Exception;
	
	public void switchToParentWindow() throws Exception;
	
	public String getWindowHandle() throws Exception;
	
	public Set<String> getWindowHandles() throws Exception;

}
