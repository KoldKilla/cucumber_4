package org.ibs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MainPage;
import pages.ModalWindow;
import pages.TablePage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    private static WebDriver driver;

    private static final manager.DriverManager driverManager = manager.DriverManager.getDriverManager();

    private final manager.TestPropManager props = manager.TestPropManager.getTestPropManager();

    @And("Открыть сайт QualIT")
    public void test() {
        if ("remote".equalsIgnoreCase(props.getProperty("driver.type"))) {
            driverManager.getDriver().get(props.getProperty("selenoid.url"));
        }
        driverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().get(props.getProperty("base.url"));
    }

    @And("Нажать на меню 'Песочница'")
    public void clickSandBoxMenu() {
        new MainPage(driverManager.getDriver())
                .clickDropDownMenuSandBox();
    }

    @And("Нажать на меню 'Товары'")
    public void clickItemsMenu() {
        new MainPage(driverManager.getDriver())
                .clickDropDownMenuItemsText();
    }

    @And("Нажать на кнопку 'Добавить'")
    public void clickAddButton() {
        new TablePage(driverManager.getDriver())
                .clickAddButton();
    }

    @And("В модальном окне ввести текст {string} в поле 'Наименование'")
    public void sendName(String textName) {
        new ModalWindow(driverManager.getDriver())
                .sendName(textName);
    }

    @And("В модальном окне нажать меню с типом товара")
    public void clickTypeDropDownMenu(){
        new ModalWindow(driverManager.getDriver())
                .clickTypeDropDownMenu();
    }

    @And("В модальном окне выбрать тип 'Фрукт'")
    public void clickFruitType() {
        new ModalWindow(driverManager.getDriver())
                .clickFruitType();
    }

    @And("В модальном окне выбрать тип 'Овощ'")
    public void clickVegetableType() {
        new ModalWindow(driverManager.getDriver())
                .clickVegetablesType();
    }

    @And("В модальном окне выбрать чекбокс экзотический")
    public void clickExoticCheckBox() {
        new ModalWindow(driverManager.getDriver())
                .clickExoticCheckBox();
    }

    @And("Нажимаем на кнопку 'Сохранить'")
    public void clickSaveButton() {
        new ModalWindow(driverManager.getDriver())
                .clickSaveButton();
    }

    @Then("Товар добавляется в таблицу, проверить что он добавлен. Проверить отображение: {string}, {string}, {string}")
    public void checkNewRawTable(String expectedNameCellText, String expectedTypeCellText, String expectedExoticCellText) {
        new TablePage(driverManager.getDriver())
                .checkNewRawTable(expectedNameCellText, expectedTypeCellText, expectedExoticCellText);
        throw new io.cucumber.java.PendingException();
    }

    @Then("Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров")
    public void checkTable(){
        new TablePage(driverManager.getDriver())
                .checkTable("Наименование", "Тип", "Экзотический");
    }
}
