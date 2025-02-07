package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChromeTests {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://automationintesting.online/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Disabled /* <-- remove after calendar selection implementation */
    public void validInput() {
        WebElement roomSelection = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[3]/button"));
        roomSelection.click();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Name");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Lastname");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Email@gmail.com");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("111111111111");

        /* Todo: Calendar date selection */

        WebElement book = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div[2]/div[3]/button[2]"));
        book.click();
        WebElement confirmationDialog = driver.findElement(By.className("ReactModal__Body--open"));
        assertTrue(confirmationDialog.isDisplayed());
    }

    @Test
    public void invalidInput() {
        WebElement roomSelection = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[3]/button"));
        roomSelection.click();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(" ");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(" ");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Email@gmail.com");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(" ");
        WebElement book = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div[2]/div[3]/button[2]"));
        book.click();
        WebElement alert = driver.findElement(By.className("alert"));
        assertTrue(alert.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
