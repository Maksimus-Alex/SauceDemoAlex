import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BAseTest {

    @Test
    public void scriptCartTest() {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("#login-button")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[1]/a/div")).click();
            driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            String nameProduct = driver.findElement(By.className("inventory_item_name")).getText();
            String priceProduct = driver.findElement(By.className("inventory_item_price")).getText();
            Assert.assertEquals("Sauce Labs Onesie", nameProduct);
            Assert.assertEquals("$7.99", priceProduct);
    }
}

