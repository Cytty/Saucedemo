package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;
@Severity(SeverityLevel.TRIVIAL)
@Feature("Функциональные тесты бокового меню на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Story("Функциональные тесты бокового меню на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Epic("Пользователь с медленным интернетом")
public class SideMenuPerformanceUserTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(SideMenuPerformanceUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("ник " + performanceUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
    }

    @Test
    @Description("Проверка наличия элементов в боковом меню сайта")
    void sideMenuElementChecksTests() {
        logger.info("Проверка наличия элементов в боковом меню сайта");
        new InventoryPage(driver)
                .clickSideMenuButton()
                .checkSideAllItemsButton()
                .checkSideLabelAllItemsButton()
                .checkSideAboutButton()
                .checkSideLabelAboutButton()
                .checkSideLogoutButton()
                .checkSideLabelLogoutButton()
                .checkSideResetAppStateButton()
                .checkSideLabelResetAppStateButton()
                .checkSideCloseMenuButton()
                .clickSideCloseMenuButton();
        logger.info("Проверка наличия элементов в боковом меню сайта завершена");

    }

    @Test
    @Description("Проверка функции RESET APP STATE")
    void resetAppStatePerformanceUserTests() {
        logger.info("Проверка функции RESET APP STATE");
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .checkBadgeCartButton()
                .clickSideMenuButton()
                .clickSideResetAppStateButton()
                .clickSideCloseMenuButton()
                .checkNoBadgeCartButton();
        logger.info("Проверка функции RESET APP STATE завершена");

    }

    @Test
    @Description("Проверка функции All Items")
    void allItemsPerformanceUserTests() {
        logger.info("Проверка функции All Items");
        new InventoryPage(driver)
                .clickToCartButton()
                .clickSideMenuButton()
                .clickSideAllItemsButton()
                .checkInventoryPageUrl();
        logger.info("Проверка функции All Items завершена");

    }

    @Test
    @Description("Проверка функции About")
    void aboutPerformanceUserTests() {
        logger.info("Проверка функции About");
        new InventoryPage(driver)
                .clickSideMenuButton()
                .clickSideAboutButton();
        logger.info("Проверка функции About завершена");

    }

}
