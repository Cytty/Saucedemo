package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.LoginPage;
import ru.cytty.pages.StepOnePage;
@Severity(SeverityLevel.BLOCKER)
@Feature("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для проблемного пользователя")
@Story("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для проблемного пользователя")
@Epic("Проблемный пользователь")
public class StepOnePageProblemUserTests extends BaseTest{
    final static Logger logger = LoggerFactory.getLogger(StepOnePageProblemUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("ник " + problemUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .clickToCartButton()
                .checkCartPageUrl()
                .clickToCheckoutButton()
                .checkStepOnePageUrl();
        logger.info("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для проблемного пользователя");

    }
    @Description("Проверка наличия элементов на основной странице оформления заказа")
    @Test
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
    void errorSendChecksTests() {
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
        logger.info("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для Проблемного юзераа завершены");
    }

}
