package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTests extends BaseTest {

    @Owner("Stanislaw")
    @Link("")
    @Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Проверка всех строчек", priority = 4)
    public void checkAll() {
        loginStep.auth("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        checkoutPage.open()
                .login("Max", "Alex", "123456");

    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @jdk.jfr.Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Проверка кода на странице Checkout", priority = 3)
    public void checkCode() {
        loginStep.auth("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        checkoutPage.open()
                .login("Max", "Alex", "");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение о тесте не соответствует");
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @jdk.jfr.Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Проверка имени на странице Checkout", priority = 2)
    public void checkLastName() {
        loginStep.auth("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        checkoutPage.open()
                .login("Max", "", "123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение о тесте не соответствует");
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @jdk.jfr.Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Проверка фамилии на странице Checkout", priority = 4, dependsOnMethods = "checkLastName")
    public void checkFirstName() {
        loginStep.auth("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        checkoutPage.open()
                .login("", "Alex", "123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение о тесте не соответствует");
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @jdk.jfr.Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Выявление кода ошибки", priority = 1)
    public void checkAllString() {
        loginStep.auth("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        checkoutPage.open();
        checkoutPage.login("", "", "");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение о тесте не соответствует");
    }

    @Owner("Maksim Aliakseichyk")
    @Link("")
    @jdk.jfr.Description("Тест проверки страницы корзины")
    @Epic("SauceDemo open page")
    @Feature("open page")
    @Story("Opening the page with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("TMS")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Выявление кода ошибки если внести (чужие) параметры ", priority = 5, dependsOnMethods = "checkCode")
    public void checkTestString() {
        loginStep.auth("standard_user", "secret_sauce");// авторизация
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        checkoutPage.open()
                .login("Test", "Test", "Test");
    }
}
