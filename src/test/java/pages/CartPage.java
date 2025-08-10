package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By CART_BUTTON = By.className("shopping_cart_link");
    private final By REMOVE_BUTTON = By.id("remove-sauce-labs-bike-light");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.findElement(CART_BUTTON).click();
    }

    public boolean isProductInCart(String product) { // метод isProductInCart возвращает true, если продукт с указанным названием находится в корзине и видим, и false в противном случае.
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']//div[@class='inventory_item_name'" +
                " and text()='" + product + "']"))).isDisplayed();
    }

    public void useRemove() {
        driver.findElement(REMOVE_BUTTON).click();
    }
}
