Feature: Como usuario quiero ingresar mis credenciales para poder acceder al sitio de compras

  @Login
  Scenario: El cliente inicia sesión en el sitio de compras
    Given El cliente se encuentra en la página de Inicio
    When El cliente hace click en el botón Sign In
    Then Se redirecciona a la página de Login


    When El cliente ingresa su email: sidanusp@gmail.com
    And  El cliente ingresa su contraseña: 24680
    And  El cliente hace click en el botón Sign In
    Then Se redirecciona a la página de My Account

  @Login
  Scenario: El cliente intenta iniciar sesión en el sitio de compras
    Given El cliente se encuentra en la página de Inicio
    When El cliente hace click en el botón Sign In
    Then Se redirecciona a la página de Login


    When El cliente ingresa su <email>
    And  El cliente ingresa su <contraseña>
    And  El cliente hace click en el botón Sign In
    Then Se muestra el <mensaje>

    Examples:
    | email             | contraseña | mensaje
    |                   |123333      |An email address required.
    |cinthia@hotmail.com|            |Password is required.
    |sidan@gmail.com    |12345678    |Authentication failed

