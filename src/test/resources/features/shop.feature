Feature: Como usuario quiero poder realizar compras en el sitio

  @Shop
  Scenario: El cliente realiza una compra en el sitio
    Given El cliente se encuentra en la página de Inicio
    When el cliente hace click en el botón DRESSES
    Then Se redirecciona a la pantalla DRESSES

    When el cliente hace click en el botón Casual Dresses
    Then Se redirecciona a la pantalla Casual Dresses

    When el cliente hace click en el primer item
    Then Se redirecciona a la pantalla detalle del Vestido



    When el cliente hace click en el botón Add To Cart
    And Se redirecciona a la pantalla Product Successfully added
    And el cliente hace click en el botón de Proceed To Checkout
    Then Se redirecciona a la pantalla SHOPPING-CART









