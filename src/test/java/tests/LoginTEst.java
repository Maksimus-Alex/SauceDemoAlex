package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTEst extends BAseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение о тесте не соответствует");
    }

    @Test
    public void checkPasswordWithoutLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение о тесте не соответствует");
    }

    @Test
    public void checkPasswordAndLoginTest() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение о тесте не соответствует");
    }
}

