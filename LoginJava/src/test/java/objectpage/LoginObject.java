/*
@author Admin
@Date Jan 8, 2022

*/
package objectpage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
public class LoginObject {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(.,'My Account')]")
	private WebElement myaccount;
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(name = "login")
	private WebElement btnLogin;
	@FindBy(xpath = "//a[.='Sign out']")
	private WebElement logout;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li")
	private WebElement error;
	@FindBy(xpath = "//h2[contains(.,'Login')]")
	private WebElement lbllogin;
	
	public LoginObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMyAccount() {
		myaccount.click();
	}
	
	public void inputUsername(String user) {
		username.sendKeys(user);
	}
	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickButtonLogin() {
		btnLogin.click();
	}
	public void clickButtonLogout() {
		logout.click();
	}
	public String getTextLogout() {
		return logout.getText();
	}
	
	public String getTextErrort() {
		return error.getText();
	}
	
	public String getTextLogin() {
		return lbllogin.getText();
	}
	public void screenshot() throws IOException {
		File screenshotLocation = password.getScreenshotAs(OutputType.FILE);
		String projectPath = System.getProperty("user.dir");
		FileUtils.copyFile(screenshotLocation,new File(projectPath+"\\src\\test\\resources\\screenshot\\checkpassword.png"));
	}
}
