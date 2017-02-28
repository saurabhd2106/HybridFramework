package testNG;

import org.testng.annotations.Test;

public class GroupsInTestNG {
	
	@Test (groups="Sanity")
	public void tc8(){
		System.out.println("Executing TC8...");
	}
	
	@Test (groups="Regression")
	public void tc2(){
		System.out.println("Executing TC2...");
	}

	@Test (groups="Sanity")
	public void tc3(){
		System.out.println("Executing TC3...");
	}

	@Test (groups="Regression")
	public void tc4(){
		System.out.println("Executing TC4...");
	}

	@Test (groups="Sanity")
	public void tc5(){
		System.out.println("Executing TC5...");
	}

	@Test (groups="Regression")
	public void tc1(){
		System.out.println("Executing TC1...");
	}

}
