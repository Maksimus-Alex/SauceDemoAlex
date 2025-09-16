package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.AllureUtils.takeScreenshot;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::div[@class='inventory_item']" +
            "//button[text()='Add to cart']";
    private final By CART_BUTTON = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Открыть иформацию о товаре")
    public ProductsPage open() {
        driver.findElement(CART_BUTTON).click();
        takeScreenshot(driver);
        return this;
    }

    @Step
    public void addYoCart(String product) {
        driver.findElement(By.xpath("//*[text()='" + product + "']/ancestor" +
                "::div[@class='inventory_item']//button[text()='Add to cart']")).click();
        takeScreenshot(driver);
    }

    @Step("Добавить в карту")
    public ProductsPage addToCart(String product, String product1) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product1))).click();
        takeScreenshot(driver);
        return this;
    }
}
