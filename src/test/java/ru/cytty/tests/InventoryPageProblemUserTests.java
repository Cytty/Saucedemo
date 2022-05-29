package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;

@Severity(SeverityLevel.TRIVIAL)
@Feature("Tесты для элементов в каталоге товаров сайта https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Story("Tесты для элементов в каталоге товаров сайта https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Epic("Пользователь с медленным интернетом")
public class InventoryPageProblemUserTests extends BaseTest{
    final  static Logger logger = LoggerFactory.getLogger(InventoryPageProblemUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("ник " + performanceUsername);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
        logger.info("Tесты для элементов в шапке сайта https://www.saucedemo.com/ для проблемного юзера");

    }

    @Test
    @Description("Проверка наличия элементов")
    void elementChecksPositiveTests() {
        logger.info("Проверка наличия элементов");
        new InventoryPage(driver)
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkImgTitlePage()
                .checkFilterButton()
                .checkImgBackpack()
                .checkCorrectImgBackpack()
                .checkImgBoltTShirt()
                .checkCorrectImgBikeLight()
                .checkImgFleeceJacket()
                .checkCorrectImgFleeceJacket()
                .checkImgBikeLight()
                .checkCorrectImgBoltTShirt()
                .checkImgOnesie()
                .checkCorrectImgOnesie()
                .checkImgTShirtRed()
                .checkCorrectImgTShirtRed();
        logger.info("Проверка наличия элементов завершена");
    }

    @Test
    @Description("Проверка перехода на страницу товара")
    void imgChecksTests() {
        logger.info("Проверка перехода на страницу товара");
        new InventoryPage(driver)
                .goPageBackpack()    .backToProducts()
                .goPageBikeLight()   .backToProducts()
                .goPageBoltTShirt()  .backToProducts()
                .goPageFleeceJacket().backToProducts()
                .goPageOnesie()      .backToProducts()
                .goPageTShirtRed()   .backToProducts();
        logger.info("Проверка перехода на страницу товара завершена");
    }

    @Test
    @Description("Проверка отображения кнопки 'ADD - REMOVE' при RESET APP. (Тест падает)")
    void addResetRemoveTests() {
        logger.info("Проверка отображения кнопки 'ADD - REMOVE' при RESET APP. (Тест падает)");
        new InventoryPage(driver)
                .checkAddBackpackToCartButton()
                .clickAddBackpackToCartButton()
                .checkRemoveBackpackButton()
                .clickSideMenuButton()
                .clickSideResetAppStateButton();
        new InventoryPage(driver)
                .checkAddBackpackToCartButton();
        logger.info("Проверка отображения кнопки 'ADD - REMOVE' при RESET APP завершена");
    }

    @Test
    @Description("Проверка отображения кнопки 'ADD - REMOVE'")
    void addRemoveTests() {
        logger.info("Проверка отображения кнопки 'ADD - REMOVE'");
        new InventoryPage(driver)
                .checkAddBackpackToCartButton()
                .clickAddBackpackToCartButton()
                .checkRemoveBackpackButton()
                .clickRemoveBackpackButton();
        new InventoryPage(driver)
                .checkAddBackpackToCartButton();
        logger.info("Проверка отображения кнопки 'ADD - REMOVE' завершена");
    }

}