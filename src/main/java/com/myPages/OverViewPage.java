package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage extends BasePage {

	private By overViewPageHeaderTitle= By.className("title");
	private By totalItemsInCart= By.className("cart_item");
	private By cartQty= By.xpath("//div[@class='cart_item']//div[@class='cart_quantity']");
	private By itemDescription= By.xpath("//div[@class='cart_item']//div[@class='cart_item_label']//div[@class='inventory_item_desc']");
	private By taxApplied= By.className("summary_tax_label");
	private By totalPrice= By.className("summary_total_label");
	private By finishButton= By.id("finish");
	public OverViewPage(WebDriver driver) {
		super(driver);
	}
	
	public String getOverViewPageHeaderTitle()
	{
		return getPageHeader(overViewPageHeaderTitle);
	}
	
	public int getTotalItemsInCart()
	{
		return getElements(totalItemsInCart).size();
	}

	public String getCartQty(int qty)
	{
		return getElements(cartQty).get(qty).getText();
	}
	
	public String getItemDescription(int itemNumber)
	{
		return getElements(itemDescription).get(itemNumber).getText();
	}
	
	public String getTaxApplied()
	{
		return getElement(taxApplied).getText();
	}
	
	public String getTotalPrice() {
		return getElement(totalPrice).getText();
	}
	
	public CheckOutCompletePage doCheckOut()
	{
		clickElement(finishButton);
		return getInstance(CheckOutCompletePage.class);
	}
}
