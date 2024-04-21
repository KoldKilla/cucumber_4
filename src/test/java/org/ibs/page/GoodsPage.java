package org.ibs.page;
import org.ibs.tests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GoodsPage {
    public static WebDriver driver;

    public GoodsPage(WebDriver webDriver) {
        PageFactory.initElements(BaseTest.driver, this);
        driver = webDriver;
    }
    @FindBy(xpath = "//button[text()='Добавить']")
            private WebElement addButton;

    @FindBy(xpath = "//h5[@class='modal-title']")
            private WebElement titleOfTheWindowForAddingProducts;
   @FindBy(xpath = "//input[@id='name']")
           private WebElement nameGood;
   @FindBy(xpath = "//select[@id='type']")
           private WebElement typeGood;
    @FindBy(xpath = "//option[@value='FRUIT']")
    private WebElement goodTypeFruit;
    @FindBy(xpath = "//option[@value='VEGETABLE']")
    private WebElement goodTypeVegetable;
   @FindBy(id = "exotic")
           private WebElement checkBoxExotic;
   @FindBy(id ="save" )
           private WebElement saveButton;
   public GoodsPage addButtonClick() {
       addButton.click();
       return this;
   }
    public GoodsPage titleOfTheWindowForAddingProductsIsDisplayed() {
        Assertions.assertEquals("Добавление товара", titleOfTheWindowForAddingProducts.getText(),
                "Окно добавления товара не открылось!");
        return this;
    }
    public GoodsPage giveNameGood(String name) {
        nameGood.sendKeys(name);
        return this;
    }
    public GoodsPage typeGoodClick() {
        typeGood.click();
        return this;
    }
    public GoodsPage typeGoodVegetableClick() {
        goodTypeVegetable.click();
        return this;
    }
    public GoodsPage typeGoodFruitClick() {
        goodTypeFruit.click();
        return this;
    }
    public GoodsPage checkboxExoticClick() {
       checkBoxExotic.click();
       return this;
    }
    public GoodsPage saveButtonClick() {
       saveButton.click();
       return this;
    }



}
