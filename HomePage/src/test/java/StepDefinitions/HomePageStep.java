/*
@author Admin
@Date Jan 24, 2022

*/
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobject.HomePageObject;

public class HomePageStep {
	WebDriver driver;
	HomePageObject home;
	
	@Given("Open the browser")
	public void open_the_browser() {
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		home = new HomePageObject(driver);
	}

	@When("Enter the URL {string}")
	public void enter_the_url(String string) {
		driver.get(string);
	}
	
	@When("Click on Shop Menu")
	public void click_on_shop_menu() {
	    home.clickShop();
	}

	@When("Now click on Home menu button")
	public void now_click_on_home_menu_button() {
	   home.clickHome();
	}

	@When("Test whether the Home page has Three Arrivals only")
	public void test_whether_the_home_page_has_three_arrivals_only() {
	    int arrivals = home.checkArrival();
	    System.out.println(arrivals);
	}

	@Then("The Home page must contains only three Arrivals")
	public void the_home_page_must_contains_only_three_arrivals() {
		int arrivals = home.checkArrival();
		boolean flag;
		if(arrivals!=3) {
			flag =false;
		}else {
			flag = true;
		}
		Assert.assertTrue(flag);
	}
	
	@When("Now click the image in the Arrivals")
	public void now_click_the_image_in_the_arrivals() {
	    home.clickElementArrivals();
	}

	@Then("Test whether it is navigating to next page where the user can add that book into his basket.")
	public void test_whether_it_is_navigating_to_next_page_where_the_user_can_add_that_book_into_his_basket() {
	   Assert.assertEquals("Thinking in HTML", home.getTextTitle());
	}

	@Then("Image should be clickable and shoul navigate to next page where user can add that book to his basket")
	public void image_should_be_clickable_and_shoul_navigate_to_next_page_where_user_can_add_that_book_to_his_basket() {
	    boolean check = home.checkBtn();
	    Assert.assertTrue(check);
	}
	
	@When("Click on Description tab for the book you clicked on.")
	public void click_on_description_tab_for_the_book_you_clicked_on() {
	    home.clickDescription();
	}

	@Then("There should be a description regarding that book the user clicked on")
	public void there_should_be_a_description_regarding_that_book_the_user_clicked_on() {
	    Assert.assertTrue(home.checkDescription());
	}

	@When("Now click on Reviews tab for the book you clicked on.")
	public void now_click_on_reviews_tab_for_the_book_you_clicked_on() {
	    // Write code here that turns the phrase above into concrete actions
	    home.clickReviews();
	}
	@Then("User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page")
	public void user_can_click_on_the_item_link_in_menu_item_after_adding_the_book_in_to_the_basket_which_leads_to_the_check_out_page() {
	    home.clickCart();
	}

	@Then("There should be a Reviews regarding that book the user clicked on")
	public void there_should_be_a_reviews_regarding_that_book_the_user_clicked_on() {
		Assert.assertTrue(home.checkReviews());
	}
	
	@When("Click on the Add To Basket button which adds that book to your basket")
	public void click_on_the_add_to_basket_button_which_adds_that_book_to_your_basket() {
	    home.clickBtnAdd();
	}

	@Then("User can view that Book in the Menu item with price.")
	public void user_can_view_that_book_in_the_menu_item_with_price() {
//		WebElement menuItem = driver.findElement(By.xpath("//span[@class='amount']"));
		WebElement priceItem = driver.findElement(By.xpath("//ins/span[@class='woocommerce-Price-amount amount']"));
		Assert.assertEquals(home.getPrice(priceItem),400);
		home.clickCart();
	}

	@When("Now click on Item link which navigates to proceed to check out page.")
	public void now_click_on_item_link_which_navigates_to_proceed_to_check_out_page() {
	    	
	    	home.clickCheckOut();
	}

	@When("Enter the Coupon code as {string} to get 50rps off on the total.")
	public void enter_the_coupon_code_as_to_get_50rps_off_on_the_total(String string) {
		home.inputCodeInCoupon(string);
	    home.clickBtnCoupon();
	}
	@Then("User can not able to apply coupon by entering ?krishnasakinala? in the coupon textbox which give 50rps off on the total price because the coupon is applicable for the book price > {int} rps")
	public void user_can_not_able_to_apply_coupon_by_entering_krishnasakinala_in_the_coupon_textbox_which_give_50rps_off_on_the_total_price_because_the_coupon_is_applicable_for_the_book_price_rps(Integer int1) {
		 Assert.assertEquals(home.getError(), "The minimum spend for this coupon is ₹450.00.");  
	}
	
	 @When("^Now click on Remove this icon in Check out page which removes that book from the grid.$")
	    public void now_click_on_remove_this_icon_in_check_out_page_which_removes_that_book_from_the_grid() throws Throwable {
	        home.clickRemove();
	    }

	    @Then("^User has the feasibility to remove the book at the time of check out also$")
	    public void user_has_the_feasibility_to_remove_the_book_at_the_time_of_check_out_also() throws Throwable {
	     boolean flag = home.checkMessage();
	    	Assert.assertTrue(flag);
	    }
	    
	    @When("^Click on textbox value under quantity in Check out page to add or subtract books.$")
	    public void click_on_textbox_value_under_quantity_in_check_out_page_to_add_or_subtract_books() throws Throwable {
	       home.changeQuantity();
	       boolean flag = home.checkUpdateBasket();
	       Assert.assertTrue(flag);
	    }

	    @When("^Now click on Update Basket to reflect those changes$")
	    public void now_click_on_update_basket_to_reflect_those_changes() throws Throwable {
	       home.clickUpdateBasket();
	    }

	    @Then("^User has the feasibility to Update Basket at the time of check out.$")
	    public void user_has_the_feasibility_to_update_basket_at_the_time_of_check_out() throws Throwable {
	    	 Assert.assertEquals(home.checkMessage(), "Basket updated.");
	    }

	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
