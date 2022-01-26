/*
@author Admin
@Date Jan 18, 2022

*/
package objectpage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryObject {
	WebDriver driver;
	@FindBy(xpath = "//ul/li[contains(@class,'cat-item')]/a")
	List<WebElement> category;
	@FindBy(tagName = "h3")
	WebElement product;
	
	public CategoryObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCategory() throws InterruptedException {
		List<WebElement> lists = category;
		for (WebElement webElement : lists) {
			System.out.println(webElement.getText());
			Actions act = new Actions(driver);
			act.keyDown(Keys.CONTROL).click(webElement).build().perform();
		}
	}
	
	public void checkProduct() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			String childrenId = it.next();	
			driver.switchTo().window(childrenId);
			if(product.isDisplayed()) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}	
		
	}
}
