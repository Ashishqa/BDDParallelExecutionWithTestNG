package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
    private By productsPageHeader=By.className("title");
    private By productList= By.xpath("//div[@id='inventory_container']//child::div[@class='inventory_item']");
    private By productTitle= By.xpath("//div[@id='inventory_container']//child::div[@class='inventory_item']//child::div[@class='inventory_item_label']//a");
    private By productDescription=By.xpath("//div[@id='inventory_container']//child::div[@class='inventory_item']//child::div[@class='inventory_item_label']//div[@class='inventory_item_desc']");
    private By productPrice= By.xpath("//div[@id='inventory_container']//child::div[@class='inventory_item']//child::div[@class='inventory_item_price']");
    private By productAddToCart= By.xpath("//div[@id='inventory_container']//child::div[@class='inventory_item']//child::button");
    private By checkout= By.className("shopping_cart_link");
    private By checkOutButton= By.id("checkout");
   	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getPageHeaderTitle()
	{
		return getPageHeader(productsPageHeader);
	}
	
	public int getProductSize()
	{
		return getElements(productList).size();
	}
	
	public String getProductTitle(int productNumber)
	{
		return getElements(productTitle).get(productNumber).getText();
	}
	
	public String getProductDescription(int productNumberDescription)
	{
		return getElements(productDescription).get(productNumberDescription).getText();
	}
	
	public String getProductPrice(int productNumberPrice)
	{
		return getElements(productPrice).get(productNumberPrice).getText();
	}
	
	public String getProductAddToCart(int productNumberAddToCart)
	{
		return getElements(productAddToCart).get(productNumberAddToCart).getText();
	}
	
	private void clickProductAddToCart(int productNumberAddToCart)
	{
		getElements(productAddToCart).get(productNumberAddToCart).click();
	}
	
	public CheckoutPage AddToCartProduct(int productNumberAddToCart)
	{
		clickProductAddToCart(productNumberAddToCart);
		clickElement(checkout);
		clickElement(checkOutButton);
		return getInstance(CheckoutPage.class);
	}
	
	
}
