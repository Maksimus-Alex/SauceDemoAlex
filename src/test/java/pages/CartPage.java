package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By REMOVE_BUTTON = By.id("remove-sauce-labs-bike-light");
    private final By TITLE = By.className("title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Продукт в корзине")
    public boolean isProductInCart(String product) {
        // метод isProductInCart возвращает true, если продукт с указанным названием находится в корзине и видим,
        // и false в противном случае.
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']//div[@class='inventory_item_name'" +
                " and text()='" + product + "']"))).isDisplayed();
    }

    @Step("Стереть продукт из корзины")
    public void useRemove() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    @Step("Открыть корзину")
    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    @Step
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}
