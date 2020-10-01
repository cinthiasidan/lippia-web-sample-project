package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.ShopHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopSteps extends PageSteps {



    @Then("Se redirecciona a la pantalla (.*)")
    public void seRedireccionaALaPantallaDRESSES(String pantalla) {
        Injector._page(ShopHomePage.class).redirectShopScreen(pantalla);
    }


    @When("el cliente hace click en el primer item")
    public void elClienteHaceClickEnElPrimerItem() {
        Injector._page(ShopHomePage.class).clickDressItem();
    }




    @And("el cliente hace click en el botón (.*)")
    public void elClienteHaceClickEnElBotónAddToCard(String button) {
        Injector._page(ShopHomePage.class).clickShopButton(button);
    }



}
