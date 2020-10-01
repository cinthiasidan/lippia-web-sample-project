package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class CartHomePage extends PageBaseShop {



    public CartHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }


    private final String H1_TITLE_CART_ID="cart_title";
    private final String TABLE_DETAIL_ID="cart_summary";
    private final String BUTTON_PROCEED_SUMMARY_CSS_SELECTOR="#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span";
    private final String FORM_LOGIN_CART_ID="login_form";
    private final String BUTTON_SIGNIN_CART_CSS_SELECTOR="#SubmitLogin > span";
    private final String H1_ADDRESSES_CSS_SELECTOR="#center_column > h1";
    private final String BUTTON_PROCEED_ADDRESS_CSS_SELECTOR="#center_column > form > p > button > span";
    private final String FORM_SHIPPING_ID="form";
    private final String CHK_TERMS_SERVICE_ID="cgv";
    private final String BUTTON_PROCEED_SHIPPING_CSS_SELECTOR="#form > p > button";
    private final String BUTTON_BANKWIRE_CSS_SELECTOR="#HOOK_PAYMENT > div:nth-child(1) > div > p > a";
    private final String BUTTON_CHEKE_CSS_SELECTOR="#HOOK_PAYMENT > div:nth-child(2) > div > p > a";
    private final String BUTTON_I_COMFIRM_CSS_SELECTOR="#cart_navigation > button";
    private final String TITULO_H3_BANK_CSS_SELECTOR="#center_column > form > div > h3";


    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreenCart(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(H1_TITLE_CART_ID)));
    }

    public void clickShopButton(String button){
        switch (button){
            case "Proceed to Checkout":
                proceedButtonClick();
                break;
            case "Pay by Bank Wire":
                bankWireButtonClick();
                break;
            case "I COMFIRM":
                iComfirmButtonClick();
                break;
            case "Sign In":
                SigninButtonClick();
                break;

        }
    }

    public void proceedButtonClick(){
        if(isElementPresentAndDisplayed(By.id(TABLE_DETAIL_ID))){
            clickElement(By.cssSelector(BUTTON_PROCEED_SUMMARY_CSS_SELECTOR));
        }
        if(isElementPresentAndDisplayed(By.cssSelector(H1_ADDRESSES_CSS_SELECTOR))){
            clickElement(By.cssSelector(BUTTON_PROCEED_ADDRESS_CSS_SELECTOR));
        }
        if(isElementPresentAndDisplayed(By.id(FORM_SHIPPING_ID))){
            clickElement(By.cssSelector(BUTTON_PROCEED_SHIPPING_CSS_SELECTOR));
        }

    }

    public void chkClick(){
        clickElement(By.id(CHK_TERMS_SERVICE_ID));
    }

    public void bankWireButtonClick(){
        clickElement(By.cssSelector(BUTTON_BANKWIRE_CSS_SELECTOR));
    }

    public void iComfirmButtonClick(){
        clickElement(By.cssSelector(BUTTON_I_COMFIRM_CSS_SELECTOR));
    }

    public void SigninButtonClick(){
        clickElement(By.cssSelector(BUTTON_SIGNIN_CART_CSS_SELECTOR));

    }


    public void redirectShopScreen(String pantalla){
        switch (pantalla){
            case "AUTHENTICATION":
                verifyScreenAuthentication();
                break;
            case "ADDRESSES":
                verifyScreenAddresses();
                break;
            case "SHIPPING":
                verifyScreenShipping();
                break;
            case "PAYMENTS":
                verifyScreenPayments();
                break;
            case "BANK-WIRE PAYMENT":
                verifyScreenBankWire();
                break;
            case "ORDER CONFIRMATION":
                verifyScreenConfirmation();
                break;
        }
    }

    public void verifyScreenAuthentication(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(FORM_LOGIN_CART_ID)));
    }

    public void verifyScreenAddresses(){
        Assert.assertEquals(getWebElement(By.cssSelector(H1_ADDRESSES_CSS_SELECTOR)).getText(), "Addresses");
    }

    public void verifyScreenShipping(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(FORM_SHIPPING_ID)));
    }

    public void verifyScreenPayments(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.cssSelector(BUTTON_BANKWIRE_CSS_SELECTOR)), "No se encuentra el boton Bank wire");
        Assert.assertTrue(isElementPresentAndDisplayed(By.cssSelector(BUTTON_CHEKE_CSS_SELECTOR)), "No se encuentra el boton Cheke");
    }

    public void verifyScreenConfirmation(){
        Assert.assertEquals(getWebElement(By.cssSelector(H1_ADDRESSES_CSS_SELECTOR)).getText(), "    Order summary");
    }

    public void verifyScreenBankWire(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.cssSelector(TITULO_H3_BANK_CSS_SELECTOR)), "No se encuentra el titulo");
    }







}
