package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;
@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты перехода на страницы соц.сетей на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Story("Тесты перехода на страницы соц.сетей на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом")
@Epic("Пользователь с медленным интернетом")
public class BasementPerformanceUserTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(BasementPerformanceUserTests.class);

    @BeforeEach
    void loginSuit() {
        logger.info("Тесты перехода на страницы соц.сетей на сайте https://www.saucedemo.com/");
        logger.info("логин " + performanceUsername);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();

    }

    @Test
    @Description("Наличие элементов в подвале сайта")
    void elementChecksTests() {
        logger.info("Наличие элементов в подвале сайта");
        new InventoryPage(driver)
                .checkTwitterButton()
                .checkFacebookButton()
                .checkLinkedInButton()
                .checkLabelInBasement()
                .checkImgInBasement();
        logger.info("Проверка наличия элементов в подвале сайта завершена");
    }

    @Test
    @Description("Переход на facebook")
    void facebookPerformanceUserTests()  {
        logger.info("Переход на facebook");
        new InventoryPage(driver)
                .goToFacebook();
        logger.info("Проверка перехода на facebook завершена");

    }

    @Test
    @Description("Переход на twitter")
    void twitterPerformanceUserTests() {
        logger.info("Переход на twitter");
        new InventoryPage(driver)
                .goToTwitter();
        logger.info("Проверка перехода на twitter завершена");

    }

    @Test
    @Description("Переход на linkedin")
    void linkedinPerformanceUserTests(){
        logger.info("Переход на linkedin");
        new InventoryPage(driver)
                .goToLinkedIn();
        logger.info("Проверка перехода на linkedin завершена");

    }

    @AfterAll
    static void logout() {
        driver.quit();
        logger.info("Тесты перехода на страницы соц.сетей на сайте https://www.saucedemo.com/ для пользователя с медленным интернетом завершены");
    }
}
