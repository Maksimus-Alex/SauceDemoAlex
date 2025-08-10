package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By FIRSTNAME_INPUT = By.id("first-name");
    private final By LASTNAME_INPUT = By.id("last-name");
    private final By ZIPCODE_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE_CHECKOUT = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(CHECK_OUT_URL);// метод который открывает
    }

    public void login(String firstname, String lastname, String code) { // Метод который помогает нам ввойти используя параметры
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(ZIPCODE_INPUT).sendKeys(code);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage() { // метод который выдает нам текст ошибки, если есть ошибка
        return driver.findElement(ERROR_MESSAGE_CHECKOUT).getText();
    }
}
