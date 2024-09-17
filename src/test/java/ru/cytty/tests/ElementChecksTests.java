package ru.cytty.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.util.internal.SystemPropertyUtil.contains;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class ElementChecksTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(HappyPathTest.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("АВТОРИЗАЦИЯ");
        logger.info(properties.getProperty("username"));
        logger.info(properties.getProperty("password"));
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys(properties.getProperty("username"));
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo(0)));
        logger.info("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test
    void siteCapElementChecksTests() {
        logger.info("Проверка наличия элементов в шапке сайта");
        assertThat(driver.findElements(By.id("react-burger-menu-btn")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("app_logo")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("shopping_cart_link")).size(), not(equalTo(0)));
        //assertThat(driver.findElements(By.xpath("//*[@id='header_container']/div[2]/span")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.cssSelector("#header_container > div.header_secondary_container > span")).size(), not(equalTo(0)));//
        assertThat(driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText(), equalTo("CHECKOUT: YOUR INFORMATION")); //
        logger.info("Проверка наличия элементов в шапке сайта завершена");
    }

    @Test
    void masterPageElementChecksTests() {
        logger.info("Проверка наличия элементов на основной странице оформления заказа");
        assertThat(driver.findElements(By.id("first-name")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("first-name")).getAttribute("placeholder"), equalTo("First Name"));
        assertThat(driver.findElements(By.id("last-name")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("last-name")).getAttribute("placeholder"), equalTo("Last Name"));
        assertThat(driver.findElements(By.id("postal-code")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("postal-code")).getAttribute("placeholder"), equalTo("Zip/Postal Code"));
        assertThat(driver.findElements(By.id("continue")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("continue")).getAttribute("value"), equalTo("Continue"));
        assertThat(driver.findElements(By.id("cancel")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("cancel")).getText(), equalTo("CANCEL"));
        logger.info("Проверка наличия элементов на основной странице оформления заказа завершена");
    }

    @Test
    void masterPageElementErrorChecksTests() {
        logger.info("Проверка наличия элементов на основной странице оформления заказа при отправлении пустых полей");
        driver.findElement(By.id("continue")).click();
        assertThat(driver.findElements(By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")).getText(), equalTo("Error: First Name is required"));
        logger.info("Проверка наличия элементов на основной странице оформления заказа при отправлении пустых полей завершена");

    }

    @Test
    void sideMenuElementChecksTests() {
        logger.info("Проверка наличия элементов в боковом меню сайта");
        driver.findElement(By.id("react-burger-menu-btn")).click();
        assertThat(driver.findElements(By.id("inventory_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("inventory_sidebar_link")).getAccessibleName(), equalTo("ALL ITEMS"));
        assertThat(driver.findElements(By.id("about_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("about_sidebar_link")).getAccessibleName(), equalTo("ABOUT"));
        assertThat(driver.findElements(By.id("logout_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("logout_sidebar_link")).getAccessibleName(), equalTo("LOGOUT"));
        assertThat(driver.findElements(By.id("reset_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.id("reset_sidebar_link")).getAccessibleName(), equalTo("RESET APP STATE"));
        assertThat(driver.findElements(By.id("react-burger-cross-btn")).size(), not(equalTo(0)));
        logger.info("Проверка наличия элементов в боковом меню сайта завершена");

    }

    @Test
    void siteBasementElementChecksTests() {
        logger.info("Проверка наличия элементов в подвале сайта");
        assertThat(driver.findElements(By.cssSelector("#page_wrapper > footer > ul > li.social_twitter > a")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.cssSelector("#page_wrapper > footer > ul > li.social_facebook > a")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.cssSelector("#page_wrapper > footer > ul > li.social_linkedin > a")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("footer_copy")).size(), not(equalTo(0)));
        assertThat(driver.findElement(By.className("footer_copy")).getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        assertThat(driver.findElements(By.className("footer_robot")).size(), not(equalTo(0)));
        logger.info("Проверка наличия элементов в подвале сайта завершена");
    }

    @AfterAll
    static void afterSuit() {
        logger.info("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html завершены");
    }
}
