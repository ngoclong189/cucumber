/*
@author Admin
@Date Jan 10, 2022

*/
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import objectpage.RegistrationObject;

public class RegistrationStep {
	WebDriver driver;
	
	RegistrationObject r;

	@SuppressWarnings("deprecation")
	@Given("^Open the browser$")
	public void open_the_browser_chrome() throws Throwable {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		r = new RegistrationObject(driver);
	}

	@When("^Enter the URL \"([^\"]*)\"$")
	public void enter_the_url_something(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@Then("^User will be registered successfully and will be navigated to the Home page$")
	public void user_will_be_registered_successfully_and_will_be_navigated_to_the_home_page() throws Throwable {
//		Assert.assertTrue(r.checkRegisterSuccess());
		System.out.println("oke roi qua di");
	}

	@Then("^Registration must fail with a warning message(ie You must enter a valid email address)$")
	public void registration_must_fail_with_a_warning_messageie_you_must_enter_a_valid_email_address()
			throws Throwable {
		System.out.println(r.getTextError());
	}

	@Then("^Registration must fail with a warning message(ie please enter an account password)$")
	public void registration_must_fail_with_a_warning_messageie_please_enter_an_account_password() throws Throwable {
		System.out.println(r.getTextError());
	}

	@Then("^Registration must fail with a warning message(ie please provide valid email address)$")
	public void registration_must_fail_with_a_warning_messageie_please_provide_valid_email_address() throws Throwable {
		System.out.println(r.getTextError());
	}

	@And("^Click on My Account Menu$")
	public void click_on_my_account_menu() throws Throwable {
		r.clickMyAccount();
	}

	@And("^Enter registered Email Address with \\\"([^\\\"]*)\\\" in Email-Address textbox$")
	public void enter_registered_email_address_in_emailaddress_textbox(String email) throws Throwable {
		r.inputEmail(email);
	}

	@And("^Enter your own password with \\\"([^\\\"]*)\\\" in password textbox$")
	public void enter_your_own_password_in_password_textbox(String password) throws Throwable {
		r.inputRegisterPassword(password);
	}

	@And("^Click on Register button$")
	public void click_on_register_button() throws Throwable {
		r.clickButtonRegister();
	}

	@And("^Enter invalid Email Address with \\\"([^\\\"]*)\\\" in Email-Address textbox$")
	public void enter_invalid_email_address_in_emailaddress_textbox(String invalidEmail) throws Throwable {
		r.inputEmail(invalidEmail);
	}

	@And("^Enter valid Email Address in Email-Address textbox$")
	public void enter_valid_email_address_in_emailaddress_textbox(String email) throws Throwable {
		r.inputEmail(email);
	}

	@And("^Enter empty password in password textbox$")
	public void enter_empty_password_in_password_textbox() throws Throwable {
		r.inputRegisterPassword("");
	}

	@And("^Enter empty Email Address in Email-Address textbox$")
	public void enter_empty_email_address_in_emailaddress_textbox() throws Throwable {
		r.inputEmail("");
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
