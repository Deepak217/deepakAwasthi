package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojo.AddUserInfo;
import utils.GenericUtils;



public class BillPaymentPage {
	public WebDriver driver;
	GenericUtils genericUtils;

	public BillPaymentPage(WebDriver driver)
	{
		this.driver = driver;
		genericUtils= new GenericUtils(driver);

	}
	private final By billPayLink = By.xpath("//a[normalize-space()='Bill Pay']");
	private final By payeeName = By.xpath("//input[@name='payee.name']");

	private final By payeeAddress = By.xpath("//input[@name='payee.address.street']");

	private final By payeeAddressCity = By.xpath("//input[@name='payee.address.city']");
	private final By payeeAddressState = By.xpath("//input[@name='payee.address.state']");
	private final By payeZipCode = By.xpath("//input[@name='payee.address.zipCode']");
	private final By payePhoneNumber = By.xpath("//input[@name='payee.phoneNumber']");
	private final By payeAccountNumber = By.xpath("//input[@name='payee.accountNumber']");
	private final By verifyAccount = By.xpath("//input[@name='verifyAccount']");
	private final By amount = By.xpath("//input[@name='amount']");

	private final By sendPayment = By.xpath("//input[@value='Send Payment']");

	private final By successfullPayment=By.xpath("//h1[normalize-space()='Bill Payment Service']");

	public boolean makePayment(AddUserInfo addUserInfoObj)  {

		String account=Integer.toString(genericUtils.getRandomIndex(1000000000));
		genericUtils.clickElement((billPayLink));

		genericUtils.inputDate( payeeName,addUserInfoObj.getFirstName());

		genericUtils.inputDate(payeeAddress,addUserInfoObj.getAddress());

		genericUtils.inputDate(( payeeAddressCity),addUserInfoObj.getCity());

		genericUtils.inputDate(( payeeAddressState),addUserInfoObj.getState());

		genericUtils.inputDate(( payeZipCode),addUserInfoObj.getZipCode());

		genericUtils.inputDate(( payePhoneNumber),addUserInfoObj.getPhoneNumber());

		genericUtils.inputDate(( payeAccountNumber),account);

		genericUtils.inputDate(( verifyAccount),account);

		genericUtils.inputDate(( amount),account);

		genericUtils.clickElement((sendPayment));

		return genericUtils.isElementPresent(successfullPayment);

	}




}
