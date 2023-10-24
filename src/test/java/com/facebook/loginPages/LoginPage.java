package com.facebook.loginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "email")
	WebElement userNameId;

	public WebElement userNameMethod(String enterYourUserName) {
		/// driver.findElement(By.id("email"));
		userNameId.sendKeys(enterYourUserName);
		return userNameId;
	}

	@FindBy(how = How.NAME, using = "pass")
	public WebElement passwordLocator;

	public WebElement passWordMethod(String enterYourPassword) {
		passwordLocator.sendKeys(enterYourPassword);
		return passwordLocator;
	}

	@FindBy(how = How.XPATH, using = "//button[starts-with(@id,'u_0_5_')]")
	private WebElement loginButtonLocator;

	public void logingButton() {
		loginButtonLocator.click();
	}

}
