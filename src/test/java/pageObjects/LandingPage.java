package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojo.AddUserInfo;
import utils.GenericUtils;
import utils.TestContextSetup;
import utils.TestDataBuild;

import java.io.IOException;


public class LandingPage {

	//Page Factory method can also be used to initialize webElement
	public WebDriver driver;
	TestDataBuild testDataBuild;

	TestContextSetup testContextSetup;
	GenericUtils genericUtils;
	public LandingPage(WebDriver driver)  {
		this.driver = driver;
		genericUtils= new GenericUtils(driver);
		testDataBuild= new TestDataBuild();

	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	By increment=   By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");

	By register = By.xpath("//a[text()='Register']");

	By firstName= By.xpath("//input[@id='customer.firstName']");
	By lasName = By.xpath("//input[@id='customer.lastName']");

	By userName= By.xpath("//input[@id='customer.username']");
	By password = By.xpath("//input[@id='customer.password']");

	By confirm =By.xpath("//input[@id='repeatedPassword']");
	By address= By.xpath("//input[@id='customer.address.street']");
	By city = By.xpath("//input[@id='customer.address.city']");
	By state= By.xpath("//input[@id='customer.address.state']");
	By zipCode = By.xpath("//input[@id='customer.address.zipCode']");
	By phone= By.xpath("//input[@id='customer.phoneNumber']");
	By ssn = By.xpath("//input[@id='customer.ssn']");

	By registerButton= By.xpath("//input[@value='Register']");

	By loggedUser=By.xpath("//*[contains(text(),'our account was created successfully')]");


	By userAlreadyExist = By.xpath("//span[@id='customer.username.errors']");
	//5-6

	public boolean registerUser(AddUserInfo addUserInfoObj)  {
		genericUtils.clickElement((register));
		return fillRegisterForm(addUserInfoObj);
	}
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}

	private boolean fillRegisterForm(AddUserInfo addUserInfoObj)  {

		String name=Integer.toString(genericUtils.getRandomIndex(100));
		genericUtils.inputDate(firstName, addUserInfoObj.getFirstName());

		genericUtils.inputDate((lasName),addUserInfoObj.getLastName());
		genericUtils.inputDate((address),addUserInfoObj.getAddress());
		genericUtils.inputDate((city), addUserInfoObj.getCity());
		genericUtils.inputDate((zipCode), addUserInfoObj.getZipCode());
		genericUtils.inputDate((state), addUserInfoObj.getState());
		genericUtils.inputDate((phone), addUserInfoObj.getPhoneNumber());
		genericUtils.inputDate((ssn), addUserInfoObj.getSsn());
		genericUtils.inputDate((userName), addUserInfoObj.getUsername());
		genericUtils.inputDate((password), addUserInfoObj.getPassword());
		genericUtils.inputDate((confirm), addUserInfoObj.getPassword());
		genericUtils.clickElement((registerButton));
		if (addUserInfoObj != null) {
			addUserInfoObj = null;
		}
		if(genericUtils.isElementPresent(userAlreadyExist))
		{
			genericUtils.inputDate((userName), addUserInfoObj.getUsername()+name);
		}
		return  genericUtils.isElementPresent(loggedUser);
	}



}
