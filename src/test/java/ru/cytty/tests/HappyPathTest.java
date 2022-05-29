package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;

@Severity(SeverityLevel.CRITICAL)
@Feature("Тесты счастливого пути")
@Story("Тесты счастливого пути")
public class HappyPathTest extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(HappyPathTest.class);

    @Test
    @Description("Тест счастливого пути обычного пользователя")
    void happyPathPositiveTest() {
        logger.info("Тест счастливого пути обычного пользователя");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkCartButton();
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .clickToCartButton()
                .checkCartPageUrl()
                .checkBackpackInTheCart()
                .clickToCheckoutButton()
                .checkStepOnePageUrl()
                .checkFirstNamePlaceholder()
                .enterFirstName()
                .checkLastNamePlaceholder()
                .enterLastName()
                .checkPostalCodePlaceholder()
                .enterPostalCode()
                .clickToContinueButton()
                .checkStepTwoPageUrl()
                .checkFieldInformation()
                .checkLabelInformation()
                .clickToFinishButton()
                .checkCompletePageUrl()
                .checkLabelCompleteOnPage()
                .clickSideMenuButton()
                .clickSideLogoutButton();
        logger.info("Тест счастливого пути обычного пользователя завершен");

    }

    @Test
    @Description("Тест счастливого пути проблемного пользователя")
    void happyPathProblemUserPositiveTest() {
        logger.info("Тест счастливого пути проблемного пользователя (падает)");
        logger.info("ник " + problemUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkCartButton();
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .clickToCartButton()
                .checkCartPageUrl()
                .checkBackpackInTheCart()
                .clickToCheckoutButton()
                .checkStepOnePageUrl()
                .checkFirstNamePlaceholder()
                .enterFirstName()
                .checkLastNamePlaceholder()
                .enterLastName()
                .checkPostalCodePlaceholder()
                .enterPostalCode()
                .clickToContinueButton()
                .checkStepTwoPageUrl()
                .checkFieldInformation()
                .checkLabelInformation()
                .clickToFinishButton()
                .checkCompletePageUrl()
                .checkLabelCompleteOnPage()
                .clickSideMenuButton()
                .clickSideLogoutButton();
        logger.info("Тест счастливого пути проблемного пользователя завершен");

    }

    @Test
    @Description("Тест счастливого пути пользователя с медленным интернетом")
    void happyPathPerformanceUserPositiveTest() {
        logger.info("Тест счастливого пути пользователя с медленным интернетом");
        logger.info("ник " + performanceUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkCartButton();
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .clickToCartButton()
                .checkCartPageUrl()
                .checkBackpackInTheCart()
                .clickToCheckoutButton()
                .checkStepOnePageUrl()
                .checkFirstNamePlaceholder()
                .enterFirstName()
                .checkLastNamePlaceholder()
                .enterLastName()
                .checkPostalCodePlaceholder()
                .enterPostalCode()
                .clickToContinueButton()
                .checkStepTwoPageUrl()
                .checkFieldInformation()
                .checkLabelInformation()
                .clickToFinishButton()
                .checkCompletePageUrl()
                .checkLabelCompleteOnPage()
                .clickSideMenuButton()
                .clickSideLogoutButton();
        logger.info("Тест счастливого пути пользователя с медленным интернетом завершен");
    }

}
