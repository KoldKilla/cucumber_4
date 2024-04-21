package org.ibs.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterAll
    static void afterAll() {
        driver.close();
        driver.quit();
    }

    public final String exoticFruitName = "Папайя";
    public final String notExoticFruitName = "Банан";
    public final String exoticVegetableName = "Кивано";
    public final String notExoticVegetableName = "Огурец";

    public final String exoticFruitNameResult = "5 Папайя Фрукт true";
    public final String notExoticFruitNameResult = "6 Банан Фрукт false";
    public final String exoticVegetableNameResult = "8 Кивано Овощ true";
    public final String notExoticVegetableNameResult = "7 Огурец Овощ false";


}