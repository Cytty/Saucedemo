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
@Feature("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для проблемного пользователя")
@Story("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для проблемного пользователя")
@Epic("Проблемный пользователь")
public class HutProblemTests extends BaseTest{
    final static Logger logger = LoggerFactory.getLogger(HutProblemTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("ник " + problemUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
        logger.info("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для проблемного пользователя");

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
