/*
@author Admin
@Date Jan 19, 2022

*/
package objectpage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyObject {
	WebDriver driver;
	
	@FindBy(xpath = "//tr[contains(@class,'cart-subtotal')]/td/span")
	WebElement subtotal;
	
	@FindBy(xpath = "//td/strong/span")
	WebElement total;
	
	@FindBy(xpath = "//a[contains(.,'Proceed to Checkout')]")
	WebElement checkout;
	
	@FindBy(xpath = "//li[@id='wpmenucartli']")
	WebElement item;
	
	@FindBy(id = "billing_first_name")
	WebElement firstName;
	
	@FindBy(id = "billing_last_name")
	WebElement lastName;
	
	@FindBy(id = "billing_company")
	WebElement companyName;
	
	@FindBy(id = "billing_email")
	WebElement email;
	
	@FindBy(id = "billing_phone")
	WebElement phone;
	
	@FindBy(id = "billing_address_1")
	WebElement address;
	
	@FindBy(id = "billing_postcode")
	WebElement postCode;
	
	@FindBy(id = "billing_city")
	WebElement city;
	
	@FindBy(id = "place_order")
	WebElement btnOrder;
	
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	WebElement orderSuccess;
	
	BuyObject b;
	
	public BuyObject() {
	}
	public BuyObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMultipleBtnAdd(int times) throws InterruptedException {
		List<WebElement> lists = driver.findElements(By.xpath("//a[contains(@class,'button product_type_simple add_to_cart_button ajax_add_to_cart')]"));
		Random r = new Random();
	
		for (int i = 0; i <= times; i++) {
			int number = r.nextInt(lists.size());
			System.out.println(number);
			WebElement element = lists.get(number);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			Thread.sleep(2000);
			
		}
	}
	
	public void ScreenShotPrice() throws IOException {
		File screenshotLocation = item.getScreenshotAs(OutputType.FILE);
		String projectPath = System.getProperty("user.dir");
		FileUtils.copyFile(screenshotLocation,
				new File(projectPath + "\\src\\test\\resources\\screenshotSorting\\MenuItemWithPrice.png"));
	}
	
	public void clickCart() {
		item.click();
	}
	
	public String getPrice(WebElement price) {
		String text = price.getText();
		String[] number = text.split("₹");
		String[] getN = number[1].split("\\.");
		return getN[0];
	
	}
	
	public int getsubtotalNumber() {
		b = new BuyObject();
		String price = b.getPrice(subtotal);
		int subtotal = Integer.parseInt(price); 
		System.out.println(subtotal);
		return subtotal;
	}	
	
	public int gettotalNumber() {
		b = new BuyObject();
		String price = b.getPrice(total);
		int total = Integer.parseInt(price); 
		System.out.println(total);
		return total;
	}
	
	public WebElement getTotal() {
		return total;
	}
	public void setTotal(WebElement total) {
		this.total = total;
	}
	public void setSubtotal(WebElement subtotal) {
		this.subtotal = subtotal;
	}
	public WebElement getSubtotal() {
		return subtotal;
	}
	
	public void clickCheckOut() {
		checkout.click();
	}
	
	public void setFirstName(String str) {
		firstName.sendKeys(str);
	}
	
	public void setLastName(String str) {
		lastName.sendKeys(str);
	}
	
	public void setCompanyName(String str) {
		companyName.sendKeys(str);
	}
	
	public void setEmail(String str) {
		email.sendKeys(str);
	}
	
	public void setPhone(String str) {
		phone.sendKeys(str);
	}
	
	public void setAddress(String str) {
		address.sendKeys(str);
	}
	
	public void setPostCode(String str) {
		postCode.sendKeys(str);
	}
	
	public void setCity(String str) {
		city.sendKeys(str);
	}
	
	public void clickOrder() {
		btnOrder.click();
	}
	public String checkOrderSuccess() {
		
		return orderSuccess.getText();
	}
		

	
}
