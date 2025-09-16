package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompleteTest extends BaseTest {

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
    @Test(testName = "Финальная проверка всех параметров и тестов")
    public void checkOverview() {
        SoftAssert softAssert = new SoftAssert();
        loginStep.auth("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
        productsPage.open();
        checkoutPage.open()
                .login("Max", "Alex", "123456");
        softAssert.assertEquals(overviewPage.findPrice(), "Total: $43.18", "It is different ");
        softAssert.assertEquals(overviewPage.findTax(), "Tax: $3.20", "It is different");
        driver.findElement(By.id("finish")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText(),
                "Thank you for your order!");
        softAssert.assertAll();
    }
}
