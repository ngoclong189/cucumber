/*
@author Admin
@Date Jan 17, 2022

*/
package objectpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopObject {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Shop']")
	WebElement shop;
	
	@FindBy(xpath = "(//span[contains(@class,'ui-slider-handle')])[1]")
	WebElement firstRdbfilter;
	
	@FindBy(xpath = "(//span[contains(@class,'ui-slider-handle')])[2]")
	WebElement secondRdbfilter;
	
	@FindBy(xpath = "//button[.='Filter']")
	WebElement btnfilter;
	
	@FindBy(xpath = "//div[contains(@class,'ui-slider-range')]")
	WebElement parentFilter;
	
	
	public List<WebElement> getListElementNoSale(){
		
		List<WebElement> lists = driver.findElements(By.xpath("//span/span[contains(@class,'woocommerce-Price-amount')]"));
		
		return lists;
	}
	
	public List<WebElement> getListElementSale(){
		List<WebElement> lists = driver.findElements(By.xpath("//ins/span[contains(@class,'woocommerce-Price-amount')]"));
		return lists;
	}
	
	public ShopObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickShop() {
		shop.click();
	}
	
	public void changeFilter(int first,int second) {
//		double max =500;
//		double min =150;
//		double width = max-min;
//		String changeSecondValue = String.format("%.4f",100-(((max-second)/width)*100));
//		String changeFisrtValue = String.format("%.4f",((first-min)/width)*100);
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		 js.executeScript("arguments[0].style.left= '"+changeFisrtValue+"%'",firstRdbfilter);
//		 JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		 js1.executeScript("arguments[0].style.left='"+changeSecondValue+"%'",secondRdbfilter);
		 
		 
		 Actions act = new Actions(driver);
			act.dragAndDropBy(firstRdbfilter, -1, 0).build().perform();
			act.dragAndDropBy(secondRdbfilter, -28, 0).build().perform();
	}
	public void clickFilter() {
		btnfilter.click();
	}
	
}
