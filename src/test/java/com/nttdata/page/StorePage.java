package com.nttdata.page;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private By inputBusqueda = By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/input[2]");
    private By mensajeNoResultados = By.xpath("//h4[@id='product-search-no-matches']");

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
        // Encuentra el campo de búsqueda e ingresa el término "Autos"
        WebElement campoBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(inputBusqueda));
        campoBusqueda.clear(); // Limpia el campo de búsqueda si hay algún texto
        campoBusqueda.sendKeys("Autos");
        campoBusqueda.sendKeys(Keys.ENTER);

        // Espera y verifica el mensaje de error si no se encuentran resultados
        try {
            WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeNoResultados));
            return mensajeError.getText();
        } catch (NoSuchElementException e) {
            return "No se encontró el mensaje de error";
        }
    }

}
