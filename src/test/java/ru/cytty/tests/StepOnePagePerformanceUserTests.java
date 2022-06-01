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
@Severity(SeverityLevel.BLOCKER)
@Feature("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для пользователя с медленным интернетом")
@Story("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для пользователя с медленным интернетом")
@Epic("Пользователь с медленным интернетом")
public class StepOnePagePerformanceUserTests extends BaseTest{
    final static Logger logger = LoggerFactory.getLogger(StepOnePagePerformanceUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("логин " + performanceUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .clickToCartButton()
                .checkCartPageUrl()
                .clickToCheckoutButton()
                .checkStepOnePageUrl();
        logger.info("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для пользователя с медленным интернетом");
    }

    @Test
    @Description("Проверка наличия элементов на основной странице оформления заказа")
    void elementChecksTests() {
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
    @Description("Проверка наличия ошибки при отправлении пустых полей при оформлении заказа")
    void elementErrorChecksTests() {
        logger.info("Проверка наличия ошибки при отправлении пустых полей при оформлении заказа");
        new StepOnePage(driver)
                .clickToContinueErrorButton();
        logger.info("Проверка наличия ошибки при отправлении пустых полей при оформлении заказа завершена");

    }

    @Test
    @Description("Проверка функциональности заполнения полей")
    void sendChecksTests() {
        logger.info("Проверка функциональности заполнения полей");
        new StepOnePage(driver)
                .checkFirstNamePlaceholder()
                .enterFirstName()
                .checkLastNamePlaceholder()
                .enterLastName()
                .checkPostalCodePlaceholder()
                .enterPostalCode()
                .clickToContinueButton()
                .clickSideMenuButton()
                .clickSideAllItemsButton()
                .clickToCartButton()
                .clickToCheckoutButton();
        logger.info("Проверка функциональности заполнения полей завершена");
    }

    @AfterAll
    static void afterSuit() {
        logger.info("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для пользователя с медленным интернетом завершены");
    }

}
