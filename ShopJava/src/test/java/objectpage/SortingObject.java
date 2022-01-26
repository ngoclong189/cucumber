/*
@author Admin
@Date Jan 19, 2022

*/
package objectpage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SortingObject {
	WebDriver driver;
	@FindBy(name = "orderby")
	WebElement selectSort;

	@FindBy(xpath = "//ul[@class='products masonry-done']")
	WebElement resultSortByPopular;

	public SortingObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sortByPopularity() {
		Select select = new Select(selectSort);
		select.selectByVisibleText("Sort by popularity");
	}
	public void sortByAverage() {
		Select select = new Select(selectSort);
		select.selectByVisibleText("Sort by average rating");
	}
	
	public void sortByLowToHigh () {
		Select select = new Select(selectSort);
		select.selectByVisibleText("Sort by price: low to high");
	}
	public void sortByHighToLow () {
		Select select = new Select(selectSort);
		select.selectByVisibleText("Sort by price: high to low");
	}
	public void sortByNewness  () {
		Select select = new Select(selectSort);
		select.selectByVisibleText("Sort by newness");
	}

	public void ScreenShot(WebElement result) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm.ss_yyyy.MM.dd");
		LocalDateTime now = LocalDateTime.now();

		File screenshotLocation = result.getScreenshotAs(OutputType.FILE);
		String projectPath = System.getProperty("user.dir");
		FileUtils.copyFile(screenshotLocation,
				new File(projectPath + "\\src\\test\\resources\\screenshotSorting\\checkResult_" + dtf.format(now) + ".png"));
	}
	
	
}
