Feature: Como usuario quiero poder realizar compras en el sitio

  @Cart
  Scenario: El cliente finaliza una compra en el sitio
    Given El cliente se encuentra en la página de SHOPPING-CART
    When el cliente hace click en el boton Proceed to Checkout
    Then se redirecciona a la pantalla AUTHENTICATION

    When El cliente ingresa su email: sidanusp@gmail.com
    And  El cliente ingresa su contraseña: 24680
    And  el cliente hace click en el boton Sign In
    Then se redirecciona a la pantalla ADDRESSES
    
    When el cliente hace click en el boton Proceed to Checkout
    Then  se redirecciona a la pantalla SHIPPING

    When el cliente hace click en el check Terms of Service
    And el cliente hace click en el boton Proceed to Checkout
    Then se redirecciona a la pantalla PAYMENTS

    When el cliente hace click en el boton Pay by Bank Wire
    Then se redirecciona a la pantalla BANK-WIRE PAYMENT

    When el cliente hace click en el botón I COMFIRM
    Then se redirecciona a la pantalla ORDER CONFIRMATION












