package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OverviewTests extends BaseTest {

    @Test(testName = "Проверка информации о товаре в корзине")
    public void checkOverview() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.open();
        checkoutPage.open();
        checkoutPage.login("Max", "Alex", "123456");
        softAssert.assertEquals(overviewPage.findPrice(), "Total: $43.18", "It is different ");
        softAssert.assertEquals(overviewPage.findTax(), "Tax: $3.20", "It is different");
        softAssert.assertAll();
    }
}
