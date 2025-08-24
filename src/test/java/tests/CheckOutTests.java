package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTests extends BaseTest {

    @Test
    public void checkAll() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("Max", "Alex", "123456");
    }

    @Test
    public void checkCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("Max", "Alex", "");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение о тесте не соответствует");
    }

    @Test
    public void checkLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("Max", "", "123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение о тесте не соответствует");
    }

    @Test
    public void checkFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("", "Alex", "123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение о тесте не соответствует");
    }

    @Test
    public void checkAllString() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("", "", "");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение о тесте не соответствует");
    }

    @Test
    public void checkTestString() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("Test", "Test", "Test");
    }
}
