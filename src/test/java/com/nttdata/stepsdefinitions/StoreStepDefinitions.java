package com.nttdata.stepsdefinitions;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import com.nttdata.page.StorePage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import static org.junit.Assert.*;

public class StoreStepDefinitions {

    private WebDriver driver = getDriver(); // Usa el WebDriver de DriverManager
    private StorePage storePage = new StorePage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private CarritoPage carritoPage = new CarritoPage(driver);

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver.get("https://qalab.bensg.com/store"); // Abre la página directamente
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        loginPage.ingresarCredenciales(usuario, clave);
        loginPage.clickLogin();
        screenShot();
    }

    @Entonces("debería ver un mensaje de error de autenticación")
    public void deberiaVerUnMensajeDeErrorDeAutenticacion() {
        String mensajeError = loginPage.obtenerMensajeError();
        assertTrue("El mensaje de error no es visible", mensajeError.contains("Error de autenticación")); // Ajusta el texto según el mensaje de error real
        screenShot();
    }

    @Y("no debería ser redirigido a la página principal")
    public void noDeberiaSerRedirigidoALaPaginaPrincipal() {
        String currentUrl = driver.getCurrentUrl();
        assertFalse("El usuario fue redirigido a la página principal", currentUrl.equals("https://qalab.bensg.com/store/pe/"));
        screenShot();
    }

    @Cuando("navego a la categoría {string}")
    public void navegoALaCategoria(String categoria) {
        storePage.navegarACategoriaYSUBCategoria(categoria, "");
        screenShot();
    }

    @Entonces("debería ver un mensaje indicando que la categoría no está disponible")
    public void deberiaVerUnMensajeIndicandoQueLaCategoriaNoEstaDisponible() {
        String mensajeError = storePage.obtenerMensajeCategoriaNoDisponible();
        assertTrue("El mensaje de categoría no disponible no se muestra correctamente.", mensajeError.contains("No se han encontrado coincidencias con tu búsqueda"));
        screenShot();
    }

    @Y("la prueba no debería continuar")
    public void laPruebaNoDeberiaContinuar() {
        driver.quit();
    }

    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        storePage.navegarACategoriaYSUBCategoria(categoria, subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        driver.get("https://qalab.bensg.com/store/pe/men/1-1-hummingbird-printed-t-shirt.html#/1-tamano-s/8-color-blanco");
        productPage.agregarProductoAlCarrito(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        String mensajePopup = productPage.obtenerMensajePopup();
        assertEquals("El mensaje de confirmación en el popup no es correcto.", "Hay 2 artículos en su carrito.", mensajePopup);
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String montoTotalPopup = productPage.obtenerMontoTotalPopup();
        // Validar que el monto total en el popup es correcto (ajusta el valor esperado según tu aplicación)
        assertEquals("El monto total en el popup no es correcto.", "S/ 38.24", montoTotalPopup);
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        carritoPage.finalizarCompra();
        screenShot();
    }

    @Entonces("valido el título de la página del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String tituloCarrito = carritoPage.obtenerTituloPagina();
        // Validar que el título de la página del carrito es el esperado
        assertEquals("El título de la página del carrito no es correcto.", "CARRITO", tituloCarrito);
        screenShot();
    }

    @Y("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String montoTotalCarrito = carritoPage.obtenerMontoTotalCarrito();
        // Validar que el monto total en el carrito es el esperado
        assertEquals("El monto total en el carrito no es correcto.", "S/ 38.24", montoTotalCarrito);
        screenShot();
    }
}
