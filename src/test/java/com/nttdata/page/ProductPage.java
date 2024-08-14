package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores para el popup y agregar al carrito
    private By agregarCarritoButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    private By popupMensaje = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[1]/h4[1]/i[1]");
    private By popupMontoTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");

    // Constructor que recibe el WebDriver
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Espera explícita de 10 segundos
    }

    // Método para agregar producto al carrito
    public void agregarProductoAlCarrito(int cantidad) {
        WebElement addToCartButton = driver.findElement(agregarCarritoButton);
        addToCartButton.click();
        // Implementa lógica adicional para seleccionar cantidad si es necesario
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
