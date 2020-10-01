package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopHomePage extends PageBaseShop {



    public ShopHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String BUTTON_DRESSES_CSS_SELECTOR= "#block_top_menu > ul > li:nth-child(2) > a";
    private final String SPAN_DRESSES_CSS_SELECTOR= "#center_column > div.content_scene_cat > div > div > span";
    private final String LINK_CASUALDRESSES_CSS_SELECTOR= "#subcategories > ul > li:nth-child(1) > div.subcategory-image > a";
    private final String ITEM_DRESS_CSS_SELECTOR= "#center_column > ul > li > div > div.left-block > div > a.product_img_link > img";
    private final String IMAGEN_DETALLE_ID="bigpic";
    private final String BUTTON_ADD_TO_CART_CSS_SELECTOR="#add_to_cart > button > span";
    private final String ICON_SUCCESSFULLY_CSS_SELECTOR="#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2 > i";
    private final String BUTTON_PROCEED_CHECKOUT_CSS_SELECTOR="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a";
    private final String H1_TITLE_CART_ID="cart_title";


    public void go() {
        navigateToCompleteURL();
    }

    public void clickShopButton(String button){
        switch (button){
            case "DRESSES":
                dressesButtonClick();
                break;
            case "Casual Dresses":
                casualDressesButtonClick();
                break;
            case "Add To Cart":
                cartButtonClick();
                break;
            case "Proceed To Checkout":
                checkoutButtonClick();
                break;
        }
    }

    public void dressesButtonClick(){
        clickElement(By.cssSelector(BUTTON_DRESSES_CSS_SELECTOR));
    }

    public void casualDressesButtonClick(){
        waitForElementVisibility(By.cssSelector(LINK_CASUALDRESSES_CSS_SELECTOR));
        clickElement(By.cssSelector(LINK_CASUALDRESSES_CSS_SELECTOR));
    }

    public void cartButtonClick(){
        clickElement(By.cssSelector(BUTTON_ADD_TO_CART_CSS_SELECTOR));

    }

    public void checkoutButtonClick(){
        clickElement(By.cssSelector(BUTTON_PROCEED_CHECKOUT_CSS_SELECTOR));

    }

    public void redirectShopScreen(String pantalla){
        switch (pantalla){
            case "DRESSES":
                verifyScreenDresses();
                break;
            case "Casual Dresses":
                verifyScreenCasualDresses();
                break;
            case "detalle del Vestido":
                verifyDetailScreen();
                break;
            case "Product Successfully added":
                verifySuccessfullyScreen();
                break;
            case "SHOPPING-CART":
                verifyCartScreen();
                break;
        }
    }

    public void verifyScreenDresses(){
        Assert.assertEquals(getWebElement(By.cssSelector(SPAN_DRESSES_CSS_SELECTOR)).getText(), "Dresses");
    }

    public void verifyScreenCasualDresses(){
        Assert.assertEquals(getWebElement(By.cssSelector(SPAN_DRESSES_CSS_SELECTOR)).getText(), "Casual Dresses");
    }

    public void clickDressItem(){
        waitForElementVisibility(By.cssSelector(ITEM_DRESS_CSS_SELECTOR));
        clickElement(By.cssSelector(ITEM_DRESS_CSS_SELECTOR));
    }

    public void verifyDetailScreen(){
        isElementPresentAndDisplayed(By.id(IMAGEN_DETALLE_ID));
    }

    public void verifySuccessfullyScreen(){
        waitForElementVisibility(By.cssSelector(ICON_SUCCESSFULLY_CSS_SELECTOR));
        Assert.assertTrue(isElementPresentAndDisplayed(By.cssSelector(ICON_SUCCESSFULLY_CSS_SELECTOR)), "El mensaje no se desplego");
    }

    public void verifyCartScreen(){
        waitForElementVisibility(By.id(H1_TITLE_CART_ID));
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(H1_TITLE_CART_ID)), "El titulo del cart no aparece");
    }







}
