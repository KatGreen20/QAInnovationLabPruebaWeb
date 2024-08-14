/*package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import com.nttdata.page.StorePage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class StoreSteps extends PageObject {

    // Instancias de las páginas
    LoginPage loginPage;
    StorePage storePage;
    ProductPage productPage;
    CarritoPage carritoPage;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        loginPage.open(); // Se abre la página de login
    }

    @Cuando("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        loginPage.ingresarCredenciales(usuario, clave);
        loginPage.clickLogin();
    }

    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navegoACategoriaYSubcategoria(String categoria, String subcategoria) {
        storePage.navegarACategoriaYSUBCategoria(categoria, subcategoria);
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        productPage.agregarProductoAlCarrito(cantidad);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        String mensajePopup = productPage.obtenerMensajePopup();
        assertThat(mensajePopup, containsString("Producto agregado"));
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String montoTotal = productPage.obtenerMontoTotalPopup();
        // Aquí deberías implementar la lógica para validar el monto total
        // Por ejemplo, podrías comparar con un valor esperado
        assertThat(montoTotal, equalTo("Monto esperado"));
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        carritoPage.finalizarCompra();
    }

    @Entonces("valido el título de la página del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String tituloPaginaCarrito = carritoPage.obtenerTituloPagina();
        assertThat(tituloPaginaCarrito, containsString("Carrito"));
    }

    @Entonces("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String montoTotalCarrito = carritoPage.obtenerMontoTotalCarrito();
        // Aquí deberías implementar la lógica para validar el monto total del carrito
        assertThat(montoTotalCarrito, equalTo("Monto esperado en el carrito"));
    }
}

*/