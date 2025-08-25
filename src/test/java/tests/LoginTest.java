package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Авторизация", priority = 4)
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(testName = "Авторизация без пароля", priority = 5, dependsOnMethods = "checkLogin")
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение о тесте не соответствует");
    }

    @Test(testName = "Авторизация без пароля", priority = 2,
            dependsOnMethods = "checkLogin",
            retryAnalyzer = RetryTest.class)
    public void checkPasswordWithoutLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение о тесте не соответствует");
    }

    @Test(testName = "Авторизация без пароля", priority = 3,
            dependsOnMethods = "checkLogin",
            retryAnalyzer = RetryTest.class)
    public void checkPasswordAndLoginTest() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение о тесте не соответствует");
    }

    @DataProvider(name = "Проверка логина с негативными данными")
    public Object[][] loginData() { // метод двухмерный массив объектов ДИПЛОМНАЯ РАБОТА, использовать
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(testName = "Проверка логина с негативными данными",
            dataProvider = "Проверка логина с негативными данными", priority = 1)
    public void paramNegativeTest(String user, String password, String expectedErrorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedErrorMessage,
                "Сообщение о тесте не соответствует");
    }


}

