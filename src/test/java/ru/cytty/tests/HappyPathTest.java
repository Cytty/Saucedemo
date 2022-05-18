package ru.cytty.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class HappyPathTest extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(HappyPathTest.class);
    static Faker faker = new Faker();

    @Test
    void happyPathPositiveTest() {
        logger.info("Тест Счастливого пути");
        logger.info("АВТОРИЗАЦИЯ");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys(properties.getProperty("username"));
        logger.info(properties.getProperty("username"));
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(properties.getProperty("password"));
        logger.info(properties.getProperty("password"));
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        logger.info("при успешной авторизации заходим на страницу https://www.saucedemo.com/inventory.html");
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo(0)));
        assertThat(driver.getTitle(), equalTo("Swag Labs"));

        logger.info("ВЫБОР ТОВАРА");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        logger.info("мы оказались в корзине https://www.saucedemo.com/cart.html");
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        logger.info("в корзине выбранный товар");
        assertThat(driver.findElements(By.id("item_4_title_link")).size(), not(equalTo(0)));

        logger.info("ВВОД ДАННЫХ");
        driver.findElement(By.id("checkout")).click();
        logger.info("на странице ввода данных https://www.saucedemo.com/checkout-step-one.html");
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        assertThat(driver.findElement(By.id("first-name")).getAttribute("placeholder"), equalTo("First Name"));
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("first-name")).sendKeys(faker.name().fullName());
        assertThat(driver.findElement(By.id("last-name")).getAttribute("placeholder"), equalTo("Last Name"));
        driver.findElement(By.id("last-name")).click();
        driver.findElement(By.id("last-name")).sendKeys(faker.name().lastName());
        assertThat(driver.findElement(By.id("postal-code")).getAttribute("placeholder"), equalTo("Zip/Postal Code"));
        driver.findElement(By.id("postal-code")).click();
        driver.findElement(By.id("postal-code")).sendKeys(faker.code().toString());

        logger.info("ОФОРМЛЕНИЕ ЗАКАЗА");

        driver.findElement(By.id("continue")).click();
        logger.info("мы на странице https://www.saucedemo.com/checkout-step-two.html");
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        assertThat(driver.findElements(By.className("summary_info_label")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.className("summary_info_label")).getText(), equalTo("Payment Information:"));

        driver.findElement(By.id("finish")).click();
        logger.info("мы на странице https://www.saucedemo.com/checkout-complete.html");
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        assertThat(driver.findElements(By.id("checkout_complete_container")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.className("complete-header")).getText(), equalTo("THANK YOU FOR YOUR ORDER"));
        logger.info("Тест Счастливого пути завершен");
    }
}
