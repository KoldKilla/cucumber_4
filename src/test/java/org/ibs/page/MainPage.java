package org.ibs.page;
import org.ibs.tests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public static WebDriver driver;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(BaseTest.driver, this);
        driver = webDriver;
    }

    @FindBy(xpath = "//a [@id='navbarDropdown']")
    private WebElement sandboxButton;

    @FindBy(xpath ="//a [@href='/food']" )
    private WebElement goodsButton;

    @FindBy(xpath = "//a [@id='reset']")
    private WebElement resetDataButton;

    @FindBy(xpath = "//h5[contains(text(),\"Список товаров\")]")
    private WebElement titleGoodsPage;

    public MainPage sandboxButtonClick() {
        sandboxButton.click();
        return this;
    }
    public MainPage goodsButtonClick() {
        goodsButton.click();
        return this;
    }

    public MainPage resetDataButtonClick() {
        resetDataButton.click();
        return this;
    }
    public MainPage titleGoodsPageIsDisplayed() {
        Assertions.assertEquals(
                      "Список товаров", titleGoodsPage.getText(),
                    "Страница http://localhost:8080/food не загрузилась");
        return this;
    }


}
