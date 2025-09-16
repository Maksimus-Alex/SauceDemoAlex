package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static tests.AllureUtils.takeScreenshot;

public class OverviewPage extends BasePage {

    private final By PRODUCT_INFORMATION = By.className("summary_total_label");
    private final By TAX_INFORMATION = By.className("summary_tax_label");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Найти Цену")
    public String findPrice() {
        WebElement price = driver.findElement(PRODUCT_INFORMATION);
        takeScreenshot(driver);
        String priceProduct = price.getText();
        return priceProduct;
    }

    @Step ("Найти скидку")
    public String findTax() {
        WebElement tax = driver.findElement(TAX_INFORMATION);
        takeScreenshot(driver);
        String taxProduct = tax.getText();
        return taxProduct;
    }
}
