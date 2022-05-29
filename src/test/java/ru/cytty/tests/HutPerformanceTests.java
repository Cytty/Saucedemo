package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.BaseAuthorizedPage;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;

@Severity(SeverityLevel.NORMAL)
@Feature("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Story("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Epic("Пользователь с медленным интернетом")
public class HutPerformanceTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(HutPerformanceTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("ник " + performanceUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
        logger.info("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для пользователя с медленным интернетом");

    }

    @Test
    @Description("Проверка отображения бейджа корзины")
    void siteCapElementChecksTests() {
        logger.info("Проверка отображения бейджа корзины");
        new BaseAuthorizedPage(driver)
                .checkNoBadgeCartButton();
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .checkBadgeCartButton()
                .clickSideMenuButton()
                .clickSideResetAppStateButton()
                .checkNoBadgeCartButton();
        logger.info("Проверка отображения бейджа корзины завершена");

    }

    @Test
    @Description("Проверка наличия элементов в шапке сайта")
    void checksBadgeTests() {
        logger.info("Проверка наличия элементов в шапке сайта");
        new BaseAuthorizedPage(driver)
                .checkBadgeCartButton()
                .checkLogoLabel()
                .checkCartButton();
        logger.info("Проверка наличия элементов в шапке сайта завершена");

    }

}
