package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.LoginHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends PageSteps {


    @Given("El cliente se encuentra en la página de Inicio")
    public void elClienteSeEncuentraEnLaPáginaDeInicio() {
        Injector._page(LoginHomePage.class).go();
        Injector._page(LoginHomePage.class).verifyIndex();
    }

    @When("El cliente hace click en el botón (.*)")
    public void elClienteHaceClickEnElBotónSignIn(String button) {
        Injector._page(LoginHomePage.class).clickButton(button);
    }

    @Then("Se redirecciona a la página de (.*)")
    public void seRedireccionaALaPáginaDeLogin(String pantalla) {
        Injector._page(LoginHomePage.class).redirectScreen(pantalla);
    }


    @When("El cliente ingresa su email: (.*)")
    public void elClienteIngresaSuEmailSidanuspGmailCom(String email) {
        Injector._page(LoginHomePage.class).completeEmail(email);
    }

    @And("El cliente ingresa su contraseña: (.*)")
    public void elClienteIngresaSuContraseña(String pass) {

        Injector._page(LoginHomePage.class).completePass(pass);
    }


    @Then("Se muestra el mensaje (.*)")
    public void seMuestraElMensajeMensaje(String message) {
        Injector._page(LoginHomePage.class).verifyMessage(message);
    }
}
