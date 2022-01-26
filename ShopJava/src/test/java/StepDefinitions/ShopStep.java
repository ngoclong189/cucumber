/*
@author Admin
@Date Jan 17, 2022

*/
package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectpage.BuyObject;
import objectpage.CategoryObject;
import objectpage.ShopObject;
import objectpage.SortingObject;

public class ShopStep {
	WebDriver driver;
	ShopObject so;
	CategoryObject cate;
	SortingObject sorting;
	BuyObject buy;
	@Given("Open the browser")
	public void open_the_browser() {
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		so = new ShopObject(driver);
	}

	@When("Enter the URL {string}")
	public void enter_the_url(String string) {
		driver.get(string);
	}

	@When("Click on Shop Menu")
	public void click_on_shop_menu() {
		so = new ShopObject(driver);
		so.clickShop();
	}

	@When("Adjust the filter by price between {int} to {int} rps")
	public void adjust_the_filter_by_price_between_to_rps(Integer int1, Integer int2) {
		so.changeFilter(int1, int2);

	}

	@When("Now click on Filter button")
	public void now_click_on_filter_button() {
		so.clickFilter();
	}

	boolean checkedSale;
	boolean checkedNoSale;

	@Then("User can view books only between {int} to {int} rps price")
	public void user_can_view_books_only_between_to_rps_price(int int1, int int2) {
		List<WebElement> lists = so.getListElementNoSale();
		for (WebElement webElement : lists) {
			String text = webElement.getText();
			String[] number = text.split("₹");
			String[] getN = number[1].split("\\.");
			System.out.println(getN[0]);
			int value = Integer.valueOf(getN[0]);
			if (value > int1 && value < int2) {
				checkedSale = true;
			} else {
				checkedSale = false;
			}
		}
		Assert.assertTrue(checkedSale);

		List<WebElement> listsNoSale = so.getListElementNoSale();

		for (WebElement webElement : listsNoSale) {
			String text = webElement.getText();
			String[] number = text.split("₹");
			String[] getN = number[1].split("\\.");
			System.out.println(getN[0]);
			int value = Integer.valueOf(getN[0]);

			if (value > int1 && value < int2) {
				checkedNoSale = true;
			} else {
				checkedNoSale = false;
			}
		}
		Assert.assertTrue(checkedNoSale);
	}

	@When("Click any of the product links available in the product category")
	public void click_any_of_the_product_links_available_in_the_product_category() throws InterruptedException {
		cate = new CategoryObject(driver);
		cate.clickCategory();
	}

	@Then("Now user can view only that particular product")
	public void now_user_can_view_only_that_particular_product() {
		cate.checkProduct();
	}

	@When("Click on Sort by Popularity item in Default sorting dropdown")
	public void click_on_sort_by_popularity_item_in_default_sorting_dropdown() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sorting = new SortingObject(driver);
		sorting.sortByPopularity();
		
	}

	@Then("Now user can view the popular products only")
	public void now_user_can_view_the_popular_products_only() throws IOException {
		WebElement result = driver.findElement(By.xpath("//ul[@class='products masonry-done']"));
		sorting.ScreenShot(result);
	}

	@When("Click on Sort by Average ratings in Default sorting dropdown")
	public void click_on_sort_by_average_ratings_in_default_sorting_dropdown()
			throws IOException, InterruptedException {
		sorting = new SortingObject(driver);
		sorting.sortByAverage();
	}
	
	@When("Click on Sort by Newness ratings in Default sorting dropdown")
	public void click_on_sort_by_newness_ratings_in_default_sorting_dropdown() {
		sorting = new SortingObject(driver);
		sorting.sortByNewness();
	}

	@When("Click on Sort by Low to High Item  in Default sorting dropdown")
	public void click_on_sort_by_low_to_high_item_in_default_sorting_dropdown() {
		sorting = new SortingObject(driver);
		sorting.sortByLowToHigh();
	}

	@When("Click on Sort by High to Low Item  in Default sorting dropdown")
	public void click_on_sort_by_high_to_low_item_in_default_sorting_dropdown() {
		sorting = new SortingObject(driver);
		sorting.sortByHighToLow();
	}
	
	@When("Click on the Add To Basket button which adds that book to your basket")
	public void click_on_the_add_to_basket_button_which_adds_that_book_to_your_basket() throws InterruptedException {
	    buy = new BuyObject(driver);
		buy.clickMultipleBtnAdd(3);
	    
	}
	
	@Then("User can view that Book in the Menu item with price.")
	public void user_can_view_that_book_in_the_menu_item_with_price() throws IOException {
		 buy = new BuyObject(driver); 
		buy.ScreenShotPrice();
	}

	@When("Now click on View Basket link which navigates to proceed to check out page.")
	public void now_click_on_view_basket_link_which_navigates_to_proceed_to_check_out_page() {
		 buy = new BuyObject(driver);
		buy.clickCart();
	}

	@When("Now user can find total and subtotal values just above the Proceed to Checkout button.")
	public void now_user_can_find_total_and_subtotal_values_just_above_the_proceed_to_checkout_button() {
		 buy = new BuyObject(driver);
		WebElement total = buy.getTotal();
	  WebElement subtotal = buy.getSubtotal();
	  Assert.assertTrue(total.isDisplayed());
	  Assert.assertTrue(subtotal.isDisplayed());
	}

	@Then("The total always smaller than subtotal because taxes are added in the subtotal")
	public void the_total_always_smaller_than_subtotal_because_taxes_are_added_in_the_subtotal() {
		 buy = new BuyObject(driver);
		int totalNumber = buy.gettotalNumber();
	    int subtotalNumber = buy.getsubtotalNumber();
	    boolean flag;
	    if(totalNumber > subtotalNumber) {
	    	flag = true;
	    }else {
	    	flag = false;
	    }
	    
	    Assert.assertTrue(flag);
	}

	@When("Now click on Proceed to Check out button which navigates to payment gateway page.")
	public void now_click_on_proceed_to_check_out_button_which_navigates_to_payment_gateway_page() {
		 buy = new BuyObject(driver);
		buy.clickCheckOut();
	}

	@Then("User can view Billing Details,Order Details,Additional details and Payment gateway details.")
	public void user_can_view_billing_details_order_details_additional_details_and_payment_gateway_details() {
		Assert.assertEquals("Billing Details", driver.findElement(By.xpath("//h3[.='Billing Details']")).getText());
	}

	@When("Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.")
	public void now_user_can_fill_his_details_in_billing_details_form_and_can_opt_any_payment_in_the_payment_gateway_like_direct_bank_transfer_cheque_cash_or_paypal() {
		 buy = new BuyObject(driver);
		buy.setFirstName("Luu");
	    buy.setLastName("Long");
	    buy.setCompanyName("Fsoft");
	    buy.setEmail("ngoclong@gmail.com");
	    buy.setPhone("0123456789");
	    buy.setAddress("Ha Noi");
	    buy.setPostCode("15000");
	    buy.setCity("Ha Noi");
	    
	}

	@When("Now click on Place Order button to complete process")
	public void now_click_on_place_order_button_to_complete_process() {
		 buy = new BuyObject(driver);
		buy.clickOrder();
	}

	@Then("On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.")
	public void on_clicking_place_order_button_user_completes_his_process_where_the_page_navigates_to_order_confirmation_page_with_order_details_bank_details_customer_details_and_billing_details() {
	   Assert.assertEquals(buy.checkOrderSuccess(), "Thank you. Your order has been received.");
	}
	
	

	@After
	public void closeBrowse() {
		driver.quit();
	}
}