package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;

import static ru.cytty.elements.SortingDropDownValues.*;

@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Story("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Epic("Пользователь с медленным интернетом")
public class SortingPerformanceUserTests extends BaseTest {
    static final Logger logger = LoggerFactory.getLogger(SortingPerformanceUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("логин " + performanceUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
    }
    @Test
    @Description("Тест на функцию сортировки AZ")
    void nameAZStandardUserTest() {
        logger.info("Тест на функцию сортировки AZ");
        new InventoryPage( driver)
                .chooseSortingOption(NAME_ASC)
                .checkAZSorting();
        logger.info("Тест на функцию сортировки AZ завершен");

    }

    @Test
    @Description("Тест на функцию сортировки ZA")
    void nameZAStandardUserTest() {
        logger.info("Тест на функцию сортировки ZA");
        new InventoryPage( driver)
                .chooseSortingOption(NAME_DESC)
                .checkZASorting();
        logger.info("Тест на функцию сортировки ZA завершен");
    }

    @Test
    @Description("Тест на функцию сортировки ToHigh")
    void priceToHighStandardUserTest() {
        logger.info("Тест на функцию сортировки ToHigh");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new InventoryPage( driver)
                .chooseSortingOption(PRICE_ASC)
                .checkToHighSorting();
        logger.info("Тест на функцию сортировки ToHigh завершен");
    }

    @Test
    @Description("Тест на функцию сортировки ToLow")
    void priceToLowStandardUserTest() {
        logger.info("Тест на функцию сортировки ToLow у стандартного юзера");
        new InventoryPage( driver)
                .chooseSortingOption(PRICE_DESC)
                .checkToLowSorting();
        logger.info("Тест на функцию сортировки ToLow завершен");
    }

    @AfterAll
    static void endOfSortingTests() {
        logger.info("Тесты на функцию сортировки для пользователя с медленным интернетом завершены");
    }
}


