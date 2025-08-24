package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {

    private final By PRODUCT_INFORMATION = By.className("summary_total_label");
    private final By TAX_INFORMATION = By.className("summary_tax_label");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String findPrice() {
        WebElement price = driver.findElement(PRODUCT_INFORMATION);
        String priceProduct = price.getText();
        return priceProduct;
    }

    public String findTax() {
        WebElement tax = driver.findElement(TAX_INFORMATION);
        String taxProduct = tax.getText();
        return taxProduct;
    }
}
