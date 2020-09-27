package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopHomePage extends PageBaseShop {



    public ShopHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String BUTTON_SIGNIN_CSS_SELECTOR = "#header > div.nav > div > div > nav > div.header_user_info > a";
    private final String INPUT_EMAIL_ID = "email";
    private final String INPUT_PASS_ID = "passwd";
    private final String BUTTON_SIGNIN_ID = "SubmitLogin";
    private final String TITLE_H1_CSS_SELECTOR ="#center_column > h1";
    private final String SLIDER_INDEX_ID = "slider_row";
    private final String FORM_LOGIN_ID = "login_form";

    public void go() {
        navigateToCompleteURL();
    }

    public void clickButton(String button){
        switch (button){
            case "Sign in":
                loginButtonClick();
                break;
        }
    }

    public void loginButtonClick(){

        if(isElementPresentAndDisplayed(By.id(FORM_LOGIN_ID))){
            clickElement(By.id(BUTTON_SIGNIN_ID));
        }

        if(isElementPresentAndDisplayed(By.id(SLIDER_INDEX_ID))){
            clickElement(By.cssSelector(BUTTON_SIGNIN_CSS_SELECTOR));
        }
    }
    public void completeEmail(String email){
        completeField(By.id(INPUT_EMAIL_ID), email);
    }

    public void completePass(String pass){
        completeField(By.id(INPUT_PASS_ID), pass);
    }

    public void clickSignInButton2(){
        clickElement(By.id(BUTTON_SIGNIN_ID));
    }

    public void redirectScreen(String pantalla){
        switch (pantalla){
            case "Login":
                verifyLoginScreen();
                break;
            case "My Account":
                verifyHome();
                break;
        }
    }

    public void verifyLoginScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"AUTHENTICATION");
    }

    public void verifyHome(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"MY ACCOUNT");;
    }

    public void verifyIndex(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(SLIDER_INDEX_ID)),  "El elemento no es visible");
    }



}
