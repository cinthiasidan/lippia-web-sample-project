package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.CartHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends PageSteps {



    @Given("El cliente se encuentra en la página de SHOPPING-CART")
    public void elClienteSeEncuentraEnLaPáginaDeSHOPPINGCART() {
        Injector._page(CartHomePage.class).verifyScreenCart();
    }

    @When("el cliente hace click en el boton (.*)")
    public void elClienteHaceClickEnElBotonProceedToCheckout(String button) {
        Injector._page(CartHomePage.class).clickShopButton(button);
    }

    @Then("se redirecciona a la pantalla (.*)")
    public void seRedireccionaALaPantallaAUTHENTICATION(String pantalla) {
        Injector._page(CartHomePage.class).redirectShopScreen(pantalla);
    }


    @When("el cliente hace click en el check (.*)")
    public void elClienteHaceClickEnElCheckTermsOfService() {
        Injector._page(CartHomePage.class).chkClick();
    }



    @And("El cliente hace click en el boton Sign In")
    public void elClienteHaceClickEnElBotonSignIn() {
    }
}
