package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;

@Severity(SeverityLevel.CRITICAL)
@Feature("Tесты на функционал корзины сайта https://www.saucedemo.com/ для проблемного пользователя")
@Story("Tесты на функционал корзины сайта https://www.saucedemo.com/ для проблемного пользователя")
@Epic("Проблемный пользователь")
public class CartPageProblemUserTests extends BaseTest {
    final  static Logger logger = LoggerFactory.getLogger(CartPageProblemUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("логин " + problemUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
        logger.info("Tесты на функционал корзины сайта https://www.saucedemo.com/ для проблемного пользователя");

    }

    @Test
    @Description("Проверка сценария 'положить 6 товаров - убрать все товары, находясь в корзине'")
    void itemsToCartIntoCartOnCartTests() {
        logger.info("Проверка сценария 'положить 6 товаров - убрать все товары, находясь в корзине'");
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .clickAddBikeLightToCartButton()
                .clickAddBoltTShirtToCartButton()
                .clickAddFleeceJacketToCartButton()
                .clickAddOnesieToCartButton()
                .clickAddTShirtRedToCartButton()

                .clickToCartButton()

                .checkBackpackInTheCart()
                .checkBikeLightInTheCart()
                .checkBoltTShirtInTheCart()
                .checkFleeceJacketInTheCart()
                .checkOnesieInTheCart()
                .checkTShirtRedInTheCart()

                .clickRemoveBackpackButton()
                .clickRemoveBikeLightButton()
                .clickRemoveBoltTShirtButton()
                .clickRemoveFleeceJacketButton()
                .clickRemoveTShirtRedButton()
                .clickRemoveOnesieButton()

                .checkNoBackpackInTheCart()
                .checkNoBikeLightInTheCart()
                .checkNoBoltTShirtInTheCart()
                .checkNoFleeceJacketInTheCart()
                .checkNoOnesieInTheCart()
                .checkNoTShirtRedInTheCart()

                .clickContinueShoppingButton();
        logger.info("Проверка сценария 'положить 6 товаров - убрать все товары, находясь в корзине' завершена");
    }

    @Test
    @Description("Проверка сценария 'положить 6 товаров - убрать все товары, находясь в каталоге'")
    void itemsToCartIntoCartOnInventoryTests() {
        logger.info("Проверка сценария 'положить 6 товаров - убрать все товары, находясь в каталоге'");
        new InventoryPage(driver)
                .clickAddBackpackToCartButton()
                .clickAddBikeLightToCartButton()
                .clickAddBoltTShirtToCartButton()
                .clickAddFleeceJacketToCartButton()
                .clickAddOnesieToCartButton()
                .clickAddTShirtRedToCartButton()

                .clickRemoveBackpackButton()
                .clickRemoveBikeLightButton()
                .clickRemoveBoltTShirtButton()
                .clickRemoveFleeceJacketButton()
                .clickRemoveTShirtRedButton()
                .clickRemoveOnesieButton()

                .checkAddBackpackToCartButton()
                .checkAddBikeLightToCartButton()
                .checkAddBoltTShirtToCartButton()
                .checkAddFleeceJacketToCartButton()
                .checkAddOnesieToCartButton()
                .checkAddTShirtRedToCartButton()

                .clickToCartButton()

                .checkNoBackpackInTheCart()
                .checkNoBikeLightInTheCart()
                .checkNoBoltTShirtInTheCart()
                .checkNoFleeceJacketInTheCart()
                .checkNoOnesieInTheCart()
                .checkNoTShirtRedInTheCart()

                .clickContinueShoppingButton();
        logger.info("Проверка сценария 'положить 6 товаров - убрать все товары, находясь в каталоге' завершена");
    }
}
