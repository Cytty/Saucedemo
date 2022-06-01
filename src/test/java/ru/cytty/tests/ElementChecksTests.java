package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.BaseAuthorizedPage;
import ru.cytty.pages.LoginPage;
import ru.cytty.pages.StepOnePage;

@Severity(SeverityLevel.CRITICAL)
@Feature("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html для обычного пользователя")
@Story("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html для обычного пользователя")
@Epic("Обычный пользователь")
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
    @Description("Проверка наличия элементов в шапке сайта")
    void siteCapElementChecksTests() {
        logger.info("Проверка наличия элементов в шапке сайта");
        new BaseAuthorizedPage(driver)
                .checkSideMenuButton()
                .checkLogoLabel()
                .checkCartButton();
        logger.info("Проверка наличия элементов в шапке сайта завершена");

    }

    @Test
    @Description("Проверка наличия элементов на основной странице оформления заказа")
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
    @Description("Проверка появления ошибки при отправлении пустых полей оформления заказа")
    void masterPageElementErrorChecksTests() {
        logger.info("Проверка появления ошибки при отправлении пустых полей оформления заказа");
        new StepOnePage(driver)
                .clickToContinueErrorButton();
        logger.info("Проверка появления ошибки при отправлении пустых полей оформления заказа завершена");

    }

    @Test
    @Description("Проверка наличия элементов в боковом меню сайта")
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
    @Description("Проверка наличия элементов в подвале сайта")
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
