import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LacatorsTest extends BAseTest {

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElements(By.id("user-name"));
        driver.findElements(By.name("user-name"));
        driver.findElements(By.className("form_group"));
        driver.findElements(By.tagName("div"));
        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.findElements(By.linkText("Sauce Labs Backpack"));
        driver.findElements(By.partialLinkText("Backpack"));
        driver.findElements(By.xpath("//*[@id=inventory_container]")); // по атрибуту
        driver.findElements(By.xpath("//span[text()='Sauce Labs Bike Ligt']"));// по тексту
        driver.findElements(By.xpath("//*[contains(@id,'inventory')]"));// частичое совпадение атрибута
        driver.findElements(By.xpath("//tag[contains(text(),'Bike')]"));// частичное совпадение текста
        driver.findElements(By.xpath("//*[text()='Sauce Labs Bike Ligt']//ancestor::div"));// Ancestor т.е. выбирает предков текущего узла
        driver.findElements(By.xpath("//div//*[text()='Sauce Labs Bike Ligt']"));// descendant является осью, которая позволяет выбрать всех потомков текущего узла, включая потомков на всех уровнях вложенности
        driver.findElements(By.xpath("//tag[text()='Sauce Labs Bike Ligt']/following::*"));//ниже текущего элемента по дереву (на всех уровнях и слоях), но исключая собственных потомков
        driver.findElements(By.xpath("//button[text()='Add to cart']/parent::div"));//Выбирает верхний (родительский) узел (по отношению к текущему узлу)
        driver.findElements(By.xpath("//button[text()='Add to cart']/preceding::div"));//Preceding аналогичен Following, но в обратную сторону, то есть все элементы выше указанного.
    }

}


