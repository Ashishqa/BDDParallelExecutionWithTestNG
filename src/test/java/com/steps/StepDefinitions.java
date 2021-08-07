package com.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.myPages.BasePage;
import com.myPages.CheckOutCompletePage;
import com.myPages.CheckoutPage;
import com.myPages.HomePage;
import com.myPages.LoginPage;
import com.myPages.OverViewPage;
import com.myPages.Page;
import com.utility.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private LoginPage loginPage;
	private HomePage homePage;
	private CheckoutPage checkoutPage;
	private OverViewPage overViewPage;
	private CheckOutCompletePage checkOutCompletePage;
	private Page page;	
	

	@Given("I want to land on Login screen")
	public void i_want_to_land_on_login_screen() {
		page= new BasePage(DriverManager.getDriver());
	  page.getInstance(LoginPage.class).navigateToLoginPage();
	}
	
	@Given("I can see page title {string}")
	public void i_can_see_page_title(String string) {
		assertEquals(page.getInstance(LoginPage.class).getLoginPageTitle(), string,"Login page title is not correct");
	}
	
	@When("I enter my login credential and click on login button")
	public void i_enter_my_login_credential_and_click_on_login_button(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> loginForm = dataTable.asMaps(String.class, String.class);  
	    homePage= page.getInstance(LoginPage.class).doLogin(loginForm.get(0).get("UserName"),loginForm.get(0).get("Password"));
	}
	
	@Then("I should navigate to Home screen and can see header title {string}")
	public void i_should_navigate_to_home_screen_and_can_see_header_title(String string) {
		String homePageHeaderTitle= homePage.getPageHeaderTitle();
		assertEquals(homePageHeaderTitle, string,"Home page title is not correct");
	}
	
	@Then("I can see all the product list with Name")
	public void i_can_see_all_the_product_list_with_name() {
		assertTrue(homePage.getProductTitle(0)!=null,"Product name not appeared");
		assertTrue(homePage.getProductSize()!=0,"There are no items on Product screen");
	}
	
	@Then("I can see all the product with Description")
	public void i_can_see_all_the_product_with_description() {
		assertTrue(homePage.getProductDescription(0)!=null,"Product description not appeared");
	}
	
	@Then("I can see all the product with Price")
	public void i_can_see_all_the_product_with_price() {
		assertTrue(homePage.getProductPrice(0)!=null,"Product price not appeared");
	}
	
	@Then("I can see all the product with {string} button")
	public void i_can_see_all_the_product_with_button(String string) {
		assertEquals(homePage.getProductAddToCart(0),string,"Add to Cart button not appeared");
	}
	
	@When("I add {int} item in Add to Cart button")
	public void i_add_item_in_add_to_cart_button(Integer int1) {
		checkoutPage = page.getInstance(HomePage.class).AddToCartProduct(0);
	}
	
	@Then("I should navigate to Proceed to Checkout screen and can see header title {string}")
	public void i_should_navigate_to_proceed_to_checkout_screen_and_can_see_header_title(String string) {
		assertEquals(checkoutPage.getCheckoutHeaderTitle(), string,"Checkout page title is not correct");
		
	}
	
	@When("I enter my shipping details and click on continue button")
	public void i_enter_my_shipping_details_and_click_on_continue_button(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> shipingInfo = dataTable.asMaps(String.class, String.class);  
		overViewPage= page.getInstance(CheckoutPage.class).enterYourInformation(shipingInfo.get(0).get("FirstName"), shipingInfo.get(0).get("LastName"), shipingInfo.get(0).get("ZipCode"));	
	}
	
	@Then("I should navigate to Proceed to Checkout Over View screen and can see header title {string}")
	public void i_should_navigate_to_proceed_to_checkout_over_view_screen_and_can_see_header_title(String string) {
		assertEquals(overViewPage.getOverViewPageHeaderTitle(), string,"Over view page title is not correct");	
	}
	
	@Then("I can see only one products in the list")
	public void i_can_see_only_one_products_in_the_list() {
		assertTrue(overViewPage.getTotalItemsInCart()==1, "There is more than 1 items in the list");
	}
	
	@Then("I can see description of the product")
	public void i_can_see_description_of_the_product() {
		assertTrue(overViewPage.getItemDescription(0)!=null, "Product item description is not appeared");
	}
	
	@Then("I can see tax applied on the product")
	public void i_can_see_tax_applied_on_the_product() {
		assertTrue(overViewPage.getTaxApplied()!=null, "Tax applied is not appeared");
	}
	
	@Then("I can see total proce of the product")
	public void i_can_see_total_proce_of_the_product() {
		assertTrue(overViewPage.getTotalPrice()!=null, "Total price is not appeared");
	}
	
	@When("I click on finish button")
	public void i_click_on_finish_button() {
		checkOutCompletePage= page.getInstance(OverViewPage.class).doCheckOut();
	}
	
	@Then("I should navigate to Checkout complete screen and can see header title {string}")
	public void i_should_navigate_to_checkout_complete_screen_and_can_see_header_title(String string) {
		assertEquals(checkOutCompletePage.getCheckOutCompleteHeaderTitle(), string,"Check out complete title is not correct");
	}
	
	@Then("I can see {string} message on screen")
	public void i_can_see_message_on_screen(String string) {
		assertEquals(checkOutCompletePage.getSuccessfulOrderMessage(),string,"Successful message is not appeared");
	}
	
	@When("I click on logout")
	public void i_click_on_logout() {
		loginPage= page.getInstance(CheckOutCompletePage.class).doLogOut();
	}
	
	@Then("I should navigate on Login screen again")
	public void i_should_navigate_on_login_screen_again() {
		assertEquals(loginPage.getUrl(), "https://www.saucedemo.com/","User has not redirected on Login screen");
	}


}
