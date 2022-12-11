package pageObjects;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public BillPaymentPage billPaymentPage;
	public WebDriver driver;

	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public LandingPage getLandingPage()  {
	
	 landingPage= new LandingPage(driver);
	 return landingPage;
	}
	
	public BillPaymentPage billPayment()
	{
		billPaymentPage = new BillPaymentPage(driver);
		return billPaymentPage;
	}
}
