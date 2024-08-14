package com.nttdata.page;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores para los filtros de categoría y subcategoría
    private By categoriaDropdown = By.xpath("//*[@id='category-3']/a");
    private By subcategoriaDropdown = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");

    // Constructor que recibe el WebDriver
    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Tiempo de espera de 10 segundos
    }

    // Método para navegar a la categoría y subcategoría especificada
    public void navegarACategoriaYSUBCategoria(String categoria, String subcategoria) {
        // Espera y haz clic en la categoría
        WebElement categoriaElement = wait.until(ExpectedConditions.elementToBeClickable(categoriaDropdown));
        categoriaElement.click();

        // Espera a que la subcategoría sea visible y haz clic en ella
        WebElement subcategoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subcategoriaDropdown));
        subcategoriaElement.click();

    }

    public String obtenerMensajeCategoriaNoDisponible() {
        try {
            // Verifica si se muestra un mensaje de error específico o un estado que indique que la categoría no está disponible
            WebElement mensajeError = driver.findElement(By.xpath("//p[contains(text(), 'no hay productos')]"));
            return mensajeError.getText();
        } catch (NoSuchElementException e) {
            // Asume que la categoría no está disponible si no encuentra el mensaje
            return "La categoría no está disponible";
        }
    }

}
