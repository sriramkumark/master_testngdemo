package testngdemopack;

import org.testng.annotations.Test;

public class DemoTestng {
	@Test(priority=1)
	public void show() {
		System.out.println("testng setup");
	}

	@Test(priority=0)
	public void show1() {
		System.out.println("testng setup");
	}
	@Test(enabled=true)  // enabled=false  it will not execute , this way we can conntrolled the Test cases.
	public void show2() {
		System.out.println("testng setup boolean false");
	}
	@Test(priority = -1,enabled = true)  // 
	public void show3() {
		System.out.println("testng priority value is negative");
	}
	@Test(priority = -2)  // there if you have priorty is -ve Value it will invoke less negative value
	public void show4() {
		System.out.println("testng priority value is negative value -2");
	}
	// most dependsOnMethods used for to check prerequested functionality , EG; Health check on server.
	@Test(dependsOnMethods="show3")  // this method is dependent on show3 method, but that method enabled as false. it wil fails
	public void display()
	{
		System.out.println("im dependend menthod");
	}
	
}
