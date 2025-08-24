package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");// добавили в корзину два товара
    }

    @Test
    public void checkProductInCart() {
        addProductToCart();
        productsPage.open(); // открыли корзину
        cartPage.isProductInCart("Sauce Labs Backpack");// проверили товар в корзине
        cartPage.isProductInCart("Sauce Labs Bike Light");
    }

    @Test
    public void useToRemove() {
        checkProductInCart();
        cartPage.useRemove();
        cartPage.isProductInCart("Sauce Labs Backpack");
    }
}

