package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores para el popup y agregar al carrito
    private By agregarCarritoButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    private By inputCantidadButton = By.xpath("//input[@id='quantity_wanted']");
    private By popupMensaje = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[1]");
    private By popupMontoTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");

    // Constructor que recibe el WebDriver
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Espera explícita de 10 segundos
    }

    // Método para agregar producto al carrito
    public void agregarProductoAlCarrito(int cantidad) {
        // Encuentra el campo de cantidad y asegúrate de que esté visible
        WebElement cantidadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputCantidadButton));

        // Haz clic en el campo de cantidad para enfocarlo
        cantidadInput.click();

        // Selecciona  texto en el campo y borrarlo
        cantidadInput.sendKeys(Keys.CONTROL + "a");
        cantidadInput.sendKeys(Keys.BACK_SPACE);     // Borra el texto seleccionado

        // Ingresa la cantidad deseada
        cantidadInput.sendKeys(String.valueOf(cantidad));

        // Haz clic en el botón "Agregar al carrito"
        WebElement addToCartButton = driver.findElement(agregarCarritoButton);
        addToCartButton.click();
    }

    // Método para obtener el mensaje del popup
    public String obtenerMensajePopup() {
        // Esperar a que el mensaje del popup sea visible
        WebElement messagePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupMensaje));
        return messagePopup.getText();
    }

    // Método para obtener el monto total del popup
    public String obtenerMontoTotalPopup() {
        // Esperar a que el monto total en el popup sea visible
        WebElement totalPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupMontoTotal));
        return totalPopup.getText();
    }
}
