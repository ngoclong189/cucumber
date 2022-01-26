/*
@author Admin
@Date Jan 24, 2022

*/
package pageobject;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Shop']")
	WebElement shop;

	@FindBy(xpath = "//a[.='Home']")
	WebElement home;

	@FindBy(xpath = "(//h3)[2]")
	WebElement Arrivals;

	@FindBy(xpath = "//h1")
	WebElement title;

	@FindBy(xpath = "//button")
	WebElement btnAdd;
	
	@FindBy(xpath = "//a[.='Description']")
	WebElement description;
	
	@FindBy(xpath = "//a[contains(.,'Reviews')]")
	WebElement reviews;
	
	@FindBy(xpath = "(//div[@class='column']/p)[2]")
	WebElement productDescription;
	
	@FindBy(xpath = "//div[@id='comments']/p")
	WebElement comments;
	
	@FindBy(xpath = "//span[@class='amount']")
	WebElement menuItem;
	
	@FindBy(xpath = "//ins/span[@class='woocommerce-Price-amount amount']")
	WebElement priceItem;
	
	@FindBy(xpath = "//a[contains(.,'Proceed to Checkout')]")
	WebElement checkout;
	
	@FindBy(xpath = "//li[@id='wpmenucartli']")
	WebElement item;
	
	@FindBy(xpath = "//tr/td[@class='product-name']")
	WebElement product;
	
	@FindBy(xpath = "//a[@class='showcoupon']")
	WebElement showCoupon;
	
	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement coupon;
	
	@FindBy(xpath = "//input[@name='apply_coupon']")
	WebElement btnCoupon;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li")
	WebElement error;
	
	@FindBy(xpath = "//a[@class='remove']")
	WebElement remove;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']")
	WebElement message;
	
	
	@FindBy(xpath = "//input[@class='input-text qty text']")
	WebElement quantity;
	
	@FindBy(xpath = "//input[@name='update_cart']")
	WebElement updateBasket;
	
	

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickCart() {
		item.click();
	}
	
	public void clickCheckOut() {
		checkout.click();
	}

	public void clickShop() {
		shop.click();
	}

	public void clickHome() {
		home.click();
	}

	public int checkArrival() {
		List<WebElement> lists = driver.findElements(By.xpath(
				"//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-1']/div[contains(@class,'sub_column_post_22')]"));
		int size = lists.size();
		return size;
	}

	public void clickElementArrivals() {
		Arrivals.click();
	}

	public String getTextArrivals() {
		System.out.println(Arrivals.getText());
		return Arrivals.getText();

	}

	public String getTextTitle() {
		System.out.println(title.getText());
		return title.getText();
	}

	public boolean checkBtn() {
		if (btnAdd.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickDescription() {
		description.click();
	}
	public void clickReviews() {
		reviews.click();
	}
	
	public boolean checkDescription() {
		if (productDescription.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkReviews() {
		if (comments.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickBtnAdd() {
		btnAdd.click();
	}
	
	public int getPrice(WebElement price) {
		String text = price.getText();
		String[] number = text.split("₹");
		String[] getN = number[1].split("\\.");
		int num = Integer.parseInt(getN[0]);
		return num;
	}
	
	public String checkbasket() {
		return product.getText();
	}
	public void clickShowCoupon() {
		showCoupon.click();
	}
	
	public void inputCodeInCoupon(String code) {
	coupon.sendKeys(code);
	}
	
	public void clickBtnCoupon() {
		btnCoupon.click();
	}
	
	public void clickRemove() {
		remove.click();
	}
	public String getError() {
		return error.getText();
	}
	
	public boolean checkMessage() {
		if (message.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void changeQuantity() {
		quantity.sendKeys(Keys.ARROW_UP);
	}
	
	public boolean checkUpdateBasket() {
		if (updateBasket.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickUpdateBasket() {
		updateBasket.click();
	}
}
