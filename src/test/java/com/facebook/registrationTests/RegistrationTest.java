package com.facebook.registrationTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.BaseTest;
import com.facebook.registrationPages.RegistrationPage;
import com.facebook.utilities.ExcelReader;

public class RegistrationTest extends BaseTest {
	RegistrationPage regPage;
	ExcelReader exReader;
	String file = "src/test/resources/registration (4).xlsx";

	String sheetName = "Sheet1";

	@BeforeMethod(groups= {"Smoke","Regression"})
	public void openFacebook() {
		openApp();
	}

	@Test(priority=0,groups="Smoke")
	public void faruqRegistrationTest() {
		regPage = new RegistrationPage(driver);
		regPage.createNewAccountButton();
		exReader = new ExcelReader(file, sheetName);
		String fName = exReader.getStringCellValue(1, 0);
		regPage.firstNameField(fName);
		regPage.lastNameField(exReader.getStringCellValue(1, 1));
		regPage.emailField(exReader.getStringCellValue(1, 2));
		regPage.reEnterEmail(exReader.getStringCellValue(1, 3));
		regPage.passwordField(exReader.getStringCellValue(1, 4));
		regPage.monthDropDownField(exReader.getStringCellValue(1, 5));
		regPage.dayDropDownField(exReader.getStringCellValue(1, 6));
		regPage.yearDropDownField(exReader.getStringCellValue(1, 7));
		regPage.radioButton(exReader.getStringCellValue(1, 8));
	}
	
	@Test(priority=1,groups="Regression")
	public void fabihaRegistrationTest() {
		regPage = new RegistrationPage(driver);
		regPage.createNewAccountButton();
		exReader = new ExcelReader(file, sheetName);
		String fName = exReader.getStringCellValue(2, 0);
		regPage.firstNameField(fName);
		regPage.lastNameField(exReader.getStringCellValue(2, 1));
		regPage.emailField(exReader.getStringCellValue(2, 2));
		regPage.reEnterEmail(exReader.getStringCellValue(2, 3));
		regPage.passwordField(exReader.getStringCellValue(2, 4));
		regPage.monthDropDownField(exReader.getStringCellValue(2, 5));
		regPage.dayDropDownField(exReader.getStringCellValue(2, 6));
		regPage.yearDropDownField(exReader.getStringCellValue(2, 7));
		regPage.radioButton(exReader.getStringCellValue(2, 8));
		String actualTitle="heelooo";
		String expentedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expentedTitle);
	}
	@Test(priority=2, groups="Regression",dependsOnMethods="fabihaRegistrationTest")
	public void testSkipped() {
		//throw new SkipException("Skipping this exception");
		//System.out.println("hello");
	}
	
	

	@AfterMethod(groups= {"Smoke","Regression"})
	public void closeFacebook() {
	 closeApp();
	}
}
