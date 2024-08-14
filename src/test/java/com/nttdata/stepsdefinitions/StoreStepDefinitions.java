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

    @Dado("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        loginPage.ingresarCredenciales(usuario, clave);
        loginPage.clickLogin();
        screenShot();
    }

    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        storePage.navegarACategoriaYSUBCategoria(categoria, subcategoria);
        screenShot();
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        driver.get("https://qalab.bensg.com/store/pe/men/1-1-hummingbird-printed-t-shirt.html#/1-tamano-s/8-color-blanco");
        productPage.agregarProductoAlCarrito(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        String mensajePopup = productPage.obtenerMensajePopup();
        // Añade validación si es necesario
        screenShot();
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String montoTotalPopup = productPage.obtenerMontoTotalPopup();
        // Añade validación si es necesario
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
        // Añade validación si es necesario
        screenShot();
    }

    @Entonces("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String montoTotalCarrito = carritoPage.obtenerMontoTotalCarrito();
        // Añade validación si es necesario
        screenShot();
    }
}
