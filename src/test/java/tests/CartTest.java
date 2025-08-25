package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(testName = "Добавить товар в корзину", priority = 1)
    public void addProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");// добавили в корзину два товара
    }

    @Test(testName = "Проверка наличия товара в корзине", priority = 3)
    public void checkProductInCart() {
        addProductToCart();
        productsPage.open(); // открыли корзину
        cartPage.isProductInCart("Sauce Labs Backpack");// проверили товар в корзине
        cartPage.isProductInCart("Sauce Labs Bike Light");
    }

    @Test(testName = "Удалить товар из корзины", priority = 2, dependsOnMethods = "addProductToCart")
    public void useToRemove() {
        checkProductInCart();
        cartPage.useRemove();
        cartPage.isProductInCart("Sauce Labs Backpack");
    }
}

