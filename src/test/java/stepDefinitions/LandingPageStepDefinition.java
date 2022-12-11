package stepDefinitions;


import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;



import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import pageObjects.BillPaymentPage;
import pageObjects.LandingPage;
import pojo.AddUserInfo;
import utils.APIResources;
import utils.TestContextSetup;
import utils.TestDataBuild;
import utils.Utils;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class LandingPageStepDefinition extends Utils {
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	BillPaymentPage billPaymentPage;

	AddUserInfo addUserInfoObj = null;
	TestDataBuild testDataBuild = new TestDataBuild();


	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.billPaymentPage=testContextSetup.pageObjectManager.billPayment();

	}

	@Given("User is on Parabank Landing page")
	public void user_is_on_green_cart_landing_page() {

		Assert.assertTrue(landingPage.getTitleLandingPage().contains("ParaBank"));
	}

	@When("Register user on Parabank site")
	public void register_user() throws InterruptedException {
		boolean isRegistered=landingPage.registerUser(addUserInfoObj);
		Assert.assertTrue("User registered Successfully",isRegistered);
	}

	@Then("user make payment to sender")
	public void user_make_payment() throws InterruptedException {
		boolean isPaymentSuccessful=billPaymentPage.makePayment(addUserInfoObj);
		Assert.assertTrue("Payment made successfully",isPaymentSuccessful);

	}
	@When("user calls {string} with {string} http request to generate {string} info")
	public void user_calls_with_http_request(String resource, String method, String user) throws IOException {

		res = given().spec(requestSpecification());
		APIResources resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource());
		assertEquals(response.getStatusCode(), 200);
		HashMap<Object, Object> userInfo = (HashMap<Object, Object>) getJsonPath(response, "results").get(0);
		addUserInfoObj	= testDataBuild.addUserInfoObj(userInfo);


	}
}
