package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.AllureUtils.takeScreenshot;

public class CheckoutPage extends BasePage {

    private final By FIRSTNAME_INPUT = By.id("first-name");
    private final By LASTNAME_INPUT = By.id("last-name");
    private final By ZIPCODE_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE_CHECKOUT = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public CheckoutPage open() {
        driver.get(CHECK_OUT_URL);// метод который открывает
        return this;
    }

    @Step ("Авторизация Checkout")
    public CheckoutPage login(String firstname, String lastname, String code) { // Метод который помогает нам ввойти используя параметры
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(ZIPCODE_INPUT).sendKeys(code);
        takeScreenshot(driver);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    @Step ("Сообщение ошибки")
    public String getErrorMessage() { // метод который выдает нам текст ошибки, если есть ошибка
        return driver.findElement(ERROR_MESSAGE_CHECKOUT).getText();
    }
}
