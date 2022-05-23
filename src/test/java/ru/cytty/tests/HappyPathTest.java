package ru.cytty.tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;

public class HappyPathTest extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(HappyPathTest.class);

    @Test
    void happyPathPositiveTest() {
        logger.info("Тест счастливого пути");
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
                .clickItemInCartButton()
                .clickToCartButton()
                .checkCartPageUrl()
                .checkItemInTheCart()
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
                .checkLabelCompleteOnPage();
        logger.info("Тест счастливого пути завершен");

    }
}
