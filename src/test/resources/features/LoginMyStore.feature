#language: es
Característica: Product - Store

  @Escenario1
  Escenario: Validación con credenciales válidas
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "cindyk.20@hotmail.com" y clave "*cindy123"
    Cuando navego a la categoría "CLOTHES" y subcategoría "MEN"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el título de la página del carrito
    Y vuelvo a validar el cálculo de precios en el carrito

    @Escenario2
    Escenario: Validación con credenciales inválidas
      Dado estoy en la página de la tienda
      Y me logueo con mi usuario "cindyk.20@hotmail.com" y clave "cindy123"
      Entonces debería ver un mensaje de error de autenticación
      Y no debería ser redirigido a la página principal

    @Escenario3
    Escenario: Validación con categoría inexistente
      Dado estoy en la página de la tienda
      Y me logueo con mi usuario "cindyk.20@hotmail.com" y clave "*cindy123"
      Cuando navego a la categoría "Autos"
      Entonces debería ver un mensaje indicando que la categoría no está disponible
      Y la prueba no debería continuar