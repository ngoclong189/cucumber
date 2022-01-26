/*
@author Admin
@Date Jan 10, 2022

*/
package objectpage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationObject {
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'My Account')]")
	WebElement myaccount;
	
	@FindBy(id = "reg_email")
	WebElement email;

	@FindBy(id = "reg_password")
	WebElement regiterPassword;

	@FindBy(xpath = "//input[@name='register']")
	WebElement btnRegiter;
	
	@FindBy(tagName = "strong")
	 WebElement checkRegis;

	@FindBy(xpath = "//ul[@class='woocommerce-error']/li")
	 WebElement error;
	
	public RegistrationObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAccount() {
		myaccount.click();
	}

	public void inputEmail(String e) {
		email.sendKeys(e);
	}

	public void inputRegisterPassword(String pass) {
		regiterPassword.sendKeys(pass);
	}

	public void clickButtonRegister() {
		btnRegiter.click();
	}
	
	
	public String getTextError() {
		return error.getText();
	}
	public boolean checkRegisterSuccess() {
		if(checkRegis.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
}
