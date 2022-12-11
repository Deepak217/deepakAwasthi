package utils;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {
	public WebDriver driver;

	public int time=5;
	public Logger log;
	pageSynchronization pageSynchronization;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
		pageSynchronization =new pageSynchronization(driver);
		log=  loggerHelper.getLogger(GenericUtils.class);

	}
	

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}

	public void inputDate(By element, String input)
	{

		WebElement inputElement=pageSynchronization.isElementVisible(driver.findElement(element), time);
		inputElement.clear();
		inputElement.sendKeys(input);
		log.info("data to be filled "+input);
	}

	public void clickElement(By element)  {
		WebElement elementClickable=pageSynchronization.isElementVisible(driver.findElement(element) , time);

		elementClickable.click();

		log.info("Element is clicked "+element);
	}

	public  boolean isElementPresent(By by)
	{
		try {
			WebElement element= driver.findElement(by);
			WebElement isPresent = pageSynchronization.isElementVisible(element, time);
			log.info("Element is displayed "+ by);
			return isPresent.isDisplayed();

		}
		catch (NoSuchElementException e)
		{
			log.info("Exception occured "+e.getMessage());
			return false;
		}
	}

	public int getRandomIndex(int size) {
		Random random = new Random();
		return random.nextInt(size);
	}
}
