package com.facebook.loginTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.facebook.base.BaseTest;
import com.facebook.loginPages.LoginPage;
import com.facebook.utilities.PropertiesReader;

public class LoginFunctionalTest extends BaseTest{
	
	LoginPage lp;
	PropertiesReader rp;
	
	@BeforeTest
	public void openFacebook() {
		openApp();
		
	}
		
	@Test(priority=0, groups="Smoke")
	public void userNameTest() {
		lp= new LoginPage(driver);
		rp=new PropertiesReader();
		lp.userNameMethod(rp.getUserName());
	}
	
	@Test(priority=1)
	public void passwordTest() {
		lp.passWordMethod(rp.getPassword());
	}
	@Test(priority=2)
	public void loginButtonTest() {
		lp.logingButton();
	}
	
	@AfterTest
	public void closeFacebook() {
		closeApp();
	}

}
