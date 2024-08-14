package com.nttdata.page;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {
    private By emailInput = By.id("field-email");
    private By passwordInput = By.id("field-password");
    private By loginButton = By.xpath("//*[@id='submit-login']");

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos
    }

    public void ingresarCredenciales(String usuario, String clave) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(usuario);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(clave);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}

