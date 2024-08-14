package com.nttdata.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;

    public static WebDriver getDriver(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Before
    public void setUp(Scenario scenario){
        DriverManager.scenario = scenario;
        getDriver(); // Inicializa el WebDriver si es necesario
    }

    @After
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null; // Limpia el WebDriver después de la prueba
        }
    }

    public static void screenShot(){
        if (driver != null && driver instanceof TakesScreenshot) {
            byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            if (scenario != null) {
                scenario.attach(evidencia, "image/png", "evidencias");
            } else {
                System.out.println("El escenario es null.");
            }
        } else {
            System.out.println("El driver es null o no soporta capturas de pantalla.");
        }
    }
}


