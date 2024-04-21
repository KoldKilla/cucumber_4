package org.ibs.tests;

import org.ibs.page.GoodsPage;
import org.ibs.page.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TestAddGoods extends BaseTest {
    MainPage mainPage = new MainPage(driver);
    GoodsPage goodsPage = new GoodsPage(driver);


    @Test
    void addExoticFruitInGoodsList() {
        mainPage.sandboxButtonClick().goodsButtonClick();
        goodsPage.addButtonClick()
                .giveNameGood(exoticFruitName)
                .typeGoodFruitClick()
                .checkboxExoticClick()
                .saveButtonClick();
        WebElement table = driver.findElement(By.xpath("//tr[5]"));
        Assertions.assertEquals(exoticFruitNameResult, table.getText(), "Товар не добавился");

    }

    @Test
    void addNotExoticFruitInGoodsList() {
        mainPage.sandboxButtonClick().goodsButtonClick();
        goodsPage.addButtonClick()
                .giveNameGood(notExoticFruitName)
                .typeGoodFruitClick()
                .saveButtonClick();
        WebElement table = driver.findElement(By.xpath("//tr[6]"));
        Assertions.assertEquals(notExoticFruitNameResult, table.getText(), "Товар не добавился");

    }


    @Test
    void addExoticVegetableInGoodsList()  {
        mainPage.sandboxButtonClick().goodsButtonClick();
        goodsPage.addButtonClick()
                .giveNameGood(exoticVegetableName)
                .typeGoodVegetableClick()
                .checkboxExoticClick()
                .saveButtonClick();
        WebElement table = driver.findElement(By.xpath("//tr[8]"));
        Assertions.assertEquals(exoticVegetableNameResult, table.getText(), "Товар не добавился");

    }

    @Test
    void addNotExoticVegetableInGoodsList() {
        mainPage.sandboxButtonClick().goodsButtonClick();
        goodsPage.addButtonClick()
                .giveNameGood(notExoticVegetableName)
                .typeGoodVegetableClick()
                .saveButtonClick();
        WebElement table = driver.findElement(By.xpath("//tr[7]"));
        Assertions.assertEquals(notExoticVegetableNameResult, table.getText(), "Товар не добавился");

    }


}
