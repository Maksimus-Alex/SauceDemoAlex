package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Тест открытия страницы корзины", description = "Прверка открытия страницы корзины")
    public void checkCartIsOpened() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        cartPage.open();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Открытие корзины не выполнено");
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Добавить товар в корзину", priority = 1)
    public void addProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");// добавили в корзину два товара
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Проверка наличия товара в корзине", priority = 3)
    public void checkProductInCart() {
        addProductToCart();
        productsPage.open(); // открыли корзину
        cartPage.isProductInCart("Sauce Labs Backpack");// проверили товар в корзине
        cartPage.isProductInCart("Sauce Labs Bike Light");
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Удалить товар из корзины", priority = 2, dependsOnMethods = "addProductToCart")
    public void useToRemove() {
        checkProductInCart();
        cartPage.useRemove();
        cartPage.isProductInCart("Sauce Labs Backpack");
    }
}

