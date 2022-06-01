package ru.cytty.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.LoginPage;
@Severity(SeverityLevel.BLOCKER)
@Feature("Тесты на авторизацию в системе")
@Story("Тесты на авторизацию в системе")
public class AuthorizationTests extends BaseTest {
    final Logger logger = LoggerFactory.getLogger(AuthorizationTests.class);


    @Test
    @Description("Тест на авторизацию стандартного юзера")
    void authorisationWithLoginPagePositiveTest() {
        logger.info("Тест на авторизацию стандартного юзера");
        logger.info("логин " + username);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkCartButton()
                .clickSideMenuButton()
                .clickSideLogoutButton();
        logger.info("Тест на авторизацию стандартного юзера завершен");
    }

    @Test
    @Description("Тест на авторизацию незарегистрированного пользователя")
    void authorisationWithLoginPageNegativeTest() {
        logger.info("Тест на авторизацию незарегистрированного пользователя");
        logger.info("логин " + username + "1111");
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(username + "1111")
                .enterPassword(password)
                .clickLoginButton();
        new LoginPage(driver)
                .checkErrorLogIn()
                .cleaningAuthorization();
        logger.info("Тест на авторизацию незарегистрированного пользователя завершен");
    }

    @Test
    @Description("Тест на авторизацию с неправильным паролем")
    void authorisationWithPasswordNegativeTest() {
        logger.info("Тест на авторизацию с неправильным паролем");
        logger.info("логин " + username);
        logger.info("пароль " + password + "1111");
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password + "1111")
                .clickLoginButton();
        new LoginPage(driver)
                .checkErrorLogIn()
                .cleaningAuthorization();
        logger.info("Тест на авторизацию с неправильным паролем завершен");
    }

    @Test
    @Description("Тест на авторизацию заблокированного пользователя")
    void authorisationWithLockedUserPositiveTest() {
        logger.info("Тест на авторизацию заблокированного пользователя");
        logger.info("логин  " + lockedUsername);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(lockedUsername)
                .enterPassword(password)
                .clickLoginButton();
        new LoginPage(driver)
                .checkErrorLockedUser()
                .cleaningAuthorization();
        logger.info("Тест на авторизацию заблокированного пользователя завершен");
    }

    @Test
    @Description("Тест на авторизацию проблемного пользователя")
    void authorisationWithProblemUserPositiveTest() {
        logger.info("Тест на авторизацию проблемного пользователя");
        logger.info("логин " + problemUsername);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkCartButton()
                .clickSideMenuButton()
                .clickSideLogoutButton();
        logger.info("Тест на авторизацию проблемного пользователя завершен");
    }
    @Description("Тест на авторизацию пользователя с медленным интернетом")
    @Test
    void authorisationWithPerformanceUserPositiveTest() {
        logger.info("Тест на авторизацию пользователя с медленным интернетом");
        logger.info("логин " + performanceUsername);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkTitleSite()
                .checkTitleInventoryPage()
                .checkCartButton()
                .clickSideMenuButton()
                .clickSideLogoutButton();
        logger.info("Тест на авторизацию пользователя с медленным интернетом завершен");
    }

    @Test
    @Description("Тест на LOGOUT пользователя с медленным интернетом")
    void logoutPerformanceUserTests() {
        logger.info("Тест на LOGOUT пользователя с медленным интернетом");
        logger.info("логин " + performanceUsername);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(performanceUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .clickSideMenuButton()
                .clickSideLogoutButton()
                .checkLoginPageUrl();
        logger.info("Тест на LOGOUT Перформанс-юзера завершен");
    }

    @Test
    @Description("Тест на LOGOUT проблемного пользователя")
    void logoutProblemUserTests() {
        logger.info("Тест на LOGOUT проблемного пользователя");
        logger.info("ник " + problemUsername);
        logger.info("пароль " + password);
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .clickSideMenuButton()
                .clickSideLogoutButton()
                .checkLoginPageUrl();
        logger.info("Тест на LOGOUT проблемного пользователя завершен");
    }

    @AfterAll
    static void logout() {
        driver.quit();
    }
}
