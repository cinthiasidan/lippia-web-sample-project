package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.ShopHomePage;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;

public class LoginSteps extends PageSteps {


    @Given("El cliente se encuentra en la página de Inicio")
    public void elClienteSeEncuentraEnLaPáginaDeInicio() {
        Injector._page(ShopHomePage.class).go();
        Injector._page(ShopHomePage.class).verifyIndex();
    }

    @When("El cliente hace click en el botón (.*)")
    public void elClienteHaceClickEnElBotónSignIn(String button) {
        Injector._page(ShopHomePage.class).clickButton(button);
    }

    @Then("Se redirecciona a la página de (.*)")
    public void seRedireccionaALaPáginaDeLogin(String pantalla) {
        Injector._page(ShopHomePage.class).redirectScreen(pantalla);
    }


    @When("El cliente ingresa su email: (.*)")
    public void elClienteIngresaSuEmailSidanuspGmailCom(String email) {
        Injector._page(ShopHomePage.class).completeEmail(email);
    }

    @And("El cliente ingresa su contraseña: (.*)")
    public void elClienteIngresaSuContraseña(String pass) {
        Injector._page(ShopHomePage.class).completePass(pass);
    }


}
