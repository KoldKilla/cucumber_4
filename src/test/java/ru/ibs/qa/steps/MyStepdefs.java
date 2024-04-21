package ru.ibs.qa.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.ConfProp;
import pages.MainPage;
import pages.ModalWindow;
import pages.TablePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    private static WebDriver driver;

    @io.cucumber.java.Before
    public void настраиваемОкружениеВБраузере() throws Exception{
        System.setProperty ("REMOTE", "true");

        String browser = System.getProperty ("type.browser");
        String browserVersion = System.getProperty ("version.browser");

        if (Boolean.parseBoolean (System.getProperty ("REMOTE"))) {
            DesiredCapabilities capabilities = new DesiredCapabilities ();
            capabilities.setCapability ("browserName", browser);
            capabilities.setCapability ("browserVersion", browserVersion);
            capabilities.setCapability ("selenoid:options", Map.<String, Object>of (
                    "enableVNC", true,
                    "enableVideo", false
            ));
            driver = new RemoteWebDriver(
                    new URL("http://149.154.71.152:4444/wd/hub"),
                    capabilities


            );
        } else {
            System.setProperty ("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver ();

        }
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();
        driver.get ("http://149.154.71.152:8080/");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }


    @And("Открыть сайт QualIT")
    public void test() {
        driver.get("http://localhost:8080");
    }

    @And("Нажать на меню 'Песочница'")
    public void clickSandBoxMenu() {
        new MainPage(driver)
                .clickDropDownMenuSandBox();
    }

    @And("Нажать на меню 'Товары'")
    public void clickItemsMenu() {
        new MainPage(driver)
                .clickDropDownMenuItemsText();
    }

    @And("Нажать на кнопку 'Добавить'")
    public void clickAddButton() {
        new TablePage(driver)
                .clickAddButton();
    }

    @And("В модальном окне ввести текст {string} в поле 'Наименование'")
    public void sendName(String textName) {
        new ModalWindow(driver)
                .sendName(textName);
    }

    @And("В модальном окне нажать меню с типом товара")
    public void clickTypeDropDownMenu(){
        new ModalWindow(driver)
                .clickTypeDropDownMenu();
    }

    @And("В модальном окне выбрать тип 'Фрукт'")
    public void clickFruitType() {
        new ModalWindow(driver)
                .clickFruitType();
    }

    @And("В модальном окне выбрать тип 'Овощ'")
    public void clickVegetableType() {
        new ModalWindow(driver)
                .clickVegetablesType();
    }

    @And("В модальном окне выбрать чекбокс экзотический")
    public void clickExoticCheckBox() {
        new ModalWindow(driver)
                .clickExoticCheckBox();
    }

    @And("Нажимаем на кнопку 'Сохранить'")
    public void clickSaveButton() {
        new ModalWindow(driver)
                .clickSaveButton();
    }

    @Then("Товар добавляется в таблицу, проверить что он добавлен. Проверить отображение: {string}, {string}, {string}")
    public void checkNewRawTable(String expectedNameCellText, String expectedTypeCellText, String expectedExoticCellText) {
        new TablePage(driver)
                .checkNewRawTable(expectedNameCellText, expectedTypeCellText, expectedExoticCellText);
        throw new io.cucumber.java.PendingException();
    }

    @Then("Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров")
    public void checkTable(){
        new TablePage(driver)
                .checkTable("Наименование", "Тип", "Экзотический");
    }
}

