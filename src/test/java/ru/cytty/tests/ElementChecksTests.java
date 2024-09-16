package ru.cytty.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.BaseAuthorizedPage;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;
import ru.cytty.pages.StepOnePage;

public class ElementChecksTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(ElementChecksTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("АВТОРИЗАЦИЯ");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .clickToCartButton()
                .checkCartPageUrl()
                .clickToCheckoutButton()
                .checkStepOnePageUrl();
        logger.info("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test
    void siteCapElementChecksTests() {
        logger.info("Проверка наличия элементов в шапке сайта");
        new BaseAuthorizedPage(driver)
                .checkSideMenuButton()
                .checkLogoLabel()
                .checkCartButton();
        logger.info("Проверка наличия элементов в шапке сайта завершена");

    }

    @Test
    void masterPageElementChecksTests() {
        logger.info("Проверка наличия элементов на основной странице оформления заказа");
        new StepOnePage(driver)
                .checkContentLabelPage()
                .checkFieldFirstName()
                .checkFirstNamePlaceholder()
                .checkFieldLastName()
                .checkLastNamePlaceholder()
                .checkFieldPostalCode()
                .checkPostalCodePlaceholder()
                .checkContinueButton()
                .checkLabelContinueButton()
                .checkCancelButton()
                .checkLabelCancelButton();
        logger.info("Проверка наличия элементов на основной странице оформления заказа завершена");
    }

    @Test
    void masterPageElementErrorChecksTests() {
        logger.info("Проверка наличия элементов на основной странице оформления заказа при отправлении пустых полей");
        new StepOnePage(driver)
                .clickToContinueErrorButton();
        logger.info("Проверка наличия элементов на основной странице оформления заказа при отправлении пустых полей завершена");

    }

    @Test
    void sideMenuElementChecksTests() {
        logger.info("Проверка наличия элементов в боковом меню сайта");
        new StepOnePage(driver)
                .clickSideMenuButton()
                .checkSideAllItemsButton()
                .checkSideLabelAllItemsButton()
                .clickSideAllItemsButton()
                .clickSideMenuButton()
                .checkSideAboutButton()
                .checkSideLabelAboutButton()
                .checkSideLogoutButton()
                .checkSideLabelLogoutButton()
                .clickSideLogoutButton()//
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .clickToCartButton()
                .checkCartPageUrl()
                .clickToCheckoutButton()
                .checkStepOnePageUrl()
                .checkSideResetAppStateButton()
                .clickSideMenuButton()
                .checkSideLabelResetAppStateButton()
                .clickSideResetAppStateButton()
                .checkSideCloseMenuButton()
                .clickSideCloseMenuButton();
        logger.info("Проверка наличия элементов в боковом меню сайта завершена");

    }

    @Test
    void siteBasementElementChecksTests() {
        logger.info("Проверка наличия элементов в подвале сайта");
        new StepOnePage(driver)
                .checkTwitterButton()
                .checkFacebookButton()
                .checkLinkedInButton()
                .checkLabelInBasement()
                .checkImgInBasement();
        logger.info("Проверка наличия элементов в подвале сайта завершена");
    }

    @AfterAll
    static void afterSuit() {
        logger.info("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html завершены");
    }

}
