/*
@author Admin
@Date Jan 8, 2022

*/
package StepDefinitions;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.OrderWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import objectpage.LoginObject;


public class LoginSteps {
	WebDriver driver;
	LoginObject login;
	
	
	String usernameCorrect = "ngoclong.thaihoa@gmail.com";
	String passwordCorrect = "NgocLong!@#$%^&*(";
	String usernameWrong = "ngoclong1.thaihoa@gmail.com";
	String passwordWrong = "NgocLong12!@#$%^&*(";
	@Given("Open the browser")
	public void open_the_browser() {
		String projectPath = System.getProperty("user.dir");
		
	    System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    
	    WebDriverWait wait=new WebDriverWait(driver, 10);
	   
	}
	
	@Given("Enter the URL {string}")
	public void enter_the_url(String string) {
	    driver.get(string);
	}

	@When("Click on My Account Menu")
	public void click_on_my_account_menu() {
		
	    login = new LoginObject(driver);
	    login.clickMyAccount();
	}

	@When("Enter registered username in username textbox")
	public void enter_registered_username_in_username_textbox() {
	    login.inputUsername(usernameCorrect);
	}

	@When("Enter password in password textbox")
	public void enter_password_in_password_textbox() {
	    login.inputPassword(passwordCorrect);
	    
	}
	
	@When("Click on login button")
	public void click_on_login_button() {
	   login.clickButtonLogin();
	   
	}

	@Then("User must successfully login to the web page")
	public void user_must_successfully_login_to_the_web_page() {
	   String text = login.getTextLogout();
	   Assert.assertEquals("Sign out", text);
	}
	
	@When("Enter incorrect username in username textbox")
	public void enter_incorrect_username_in_username_textbox() {
		 login.inputUsername(usernameWrong);
	}

	@When("Enter incorrect password in password textbox.")
	public void enter_incorrect_password_in_password_textbox() {
		 login.inputPassword(passwordWrong);
	}
	
	@Then("Proper error must be displayed\\(ie Invalid username) and prompt to enter login again")
	public void proper_error_must_be_displayed_ie_invalid_username_and_prompt_to_enter_login_again() {
		System.err.println(login.getTextErrort());
	}
	
	@When("Enter valid username in username textbox")
	public void enter_valid_username_in_username_textbox() {
	    // Write code here that turns the phrase above into concrete actions
		login.inputUsername(usernameCorrect);
	}

	@When("Now enter empty password in the password textbox")
	public void now_enter_empty_password_in_the_password_textbox() {
	    // Write code here that turns the phrase above into concrete actions
		login.inputPassword("");
	}

	@Then("Proper error must be displayed\\(ie Invalid password) and prompt to enter login again")
	public void proper_error_must_be_displayed_ie_invalid_password_and_prompt_to_enter_login_again() {
	    // Write code here that turns the phrase above into concrete actions
		System.err.println(login.getTextErrort());
	}
	@When("Enter empty username in username textbox")
	public void enter_empty_username_in_username_textbox() {
		login.inputUsername("");
	}

	@When("Now enter valid password in the password textbox")
	public void now_enter_valid_password_in_the_password_textbox() {
		login.inputPassword(passwordCorrect);
	}
	
	@When("Enter the password field with some characters.")
	public void enter_the_password_field_with_some_characters() {
		login.inputPassword("%$#!@#$%^&*(");
	}

	@Then("The password field should display the characters in asterisks or bullets such that the password is not visible on the screen")
	public void the_password_field_should_display_the_characters_in_asterisks_or_bullets_such_that_the_password_is_not_visible_on_the_screen() throws IOException  {
	    login.screenshot();
	}
	
	@When("Enter the case changed username in username textbox")
	public void enter_the_case_changed_username_in_username_textbox() {
	    login.inputUsername(usernameCorrect);
	}

	@When("Enter the case chenged password in the password tetxbox")
	public void enter_the_case_chenged_password_in_the_password_tetxbox() {
	    login.inputPassword(passwordCorrect);
	}

	@When("Once your are logged in, sign out of the site")
	public void once_your_are_logged_in_sign_out_of_the_site() {
	    login.clickButtonLogout();
	}

	@When("Now press back button")
	public void now_press_back_button() {
	    driver.navigate().back();
	}
	
	@Then("User shouldnot be signed in to his account rather a general webpage must be visible")
	public void user_shouldn_t_be_signed_in_to_his_account_rather_a_general_webpage_must_be_visible() {
		Assert.assertEquals(login.getTextLogin(), "Login");
	}
	@After
	public void closeBrowse() {
		driver.quit();
	}
}
