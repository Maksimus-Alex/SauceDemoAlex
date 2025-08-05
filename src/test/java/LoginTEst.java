import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTEst extends BAseTest {

    @Test
    public void ckechPositiveLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#login-button")).click();
        String error = driver.findElement(By.cssSelector(".error-message-container > h3:nth-child(1)")).getText();
        Assert.assertEquals(error, "Epic sadface: Password is required");
        driver.navigate().refresh();
    }

    @Test
    public void checkLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        String errorPassword = driver.findElement(By.cssSelector(".error-message-container > h3:nth-child(1)")).getText();
        Assert.assertEquals(errorPassword, "Epic sadface: Username is required");
        driver.navigate().refresh();

    }

    @Test
    public void checkPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.cssSelector("#login-button")).click();
        String errorPasswordAndUsername = driver.findElement(By.cssSelector(".error-message-container > h3:nth-child(1)")).getText();
        Assert.assertEquals(errorPasswordAndUsername, "Epic sadface: Username and password do not match any user in this service");
    }

}

