package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarritoPage {
    private WebDriver driver;

    // Localizadores para la página del carrito
    private By finalizarCompraButton = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a/i");
    private By tituloPagina = By.tagName("h1");
    private By montoTotalCarrito = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");

    // Constructor que recibe el WebDriver
    public CarritoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para finalizar la compra
    public void finalizarCompra() {
        WebElement button = driver.findElement(finalizarCompraButton);
        button.click();
    }

    // Método para obtener el título de la página del carrito
    public String obtenerTituloPagina() {
        WebElement titleElement = driver.findElement(tituloPagina);
        return titleElement.getText();
    }

    // Método para obtener el monto total en el carrito
    public String obtenerMontoTotalCarrito() {
        WebElement montoElement = driver.findElement(montoTotalCarrito);
        return montoElement.getText();
    }
}

