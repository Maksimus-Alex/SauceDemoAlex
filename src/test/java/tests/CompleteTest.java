package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompleteTest extends BAseTest {

    @Test
    public void checkOverview() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        checkoutPage.open();
        checkoutPage.login("Max", "Alex", "123456");
        softAssert.assertEquals(overviewPage.findPrice(), "Total: $43.18", "It is different ");
        softAssert.assertEquals(overviewPage.findTax(), "Tax: $3.20", "It is different");
        softAssert.assertAll();
        driver.findElement(By.id("finish")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText(),
                "Thank you for your order!");
    }
}
