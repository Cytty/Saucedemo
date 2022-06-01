package ru.cytty.tests.tech;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cytty.pages.InventoryPage;
import ru.cytty.pages.LoginPage;
import ru.cytty.tests.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Технические тесты")
@Severity(SeverityLevel.BLOCKER)
@Feature("Тесты на удаление/добавление cookie")
@Story("Тесты на удаление/добавление cookie")
public class CookiesTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(CookiesTests.class);


    @Test
    @Description("Тест на обнуление куки при входе с другим логином. (Обычного на заблокироавнного)")
    void setCookiesTest1() {
        logger.info("Тест на обнуление куки при входе с другим логином. (Обычного на заблокироавнного)");
        logger.info("вход с  " + getUsername());
        logger.info("пароль " + getPassword());
        InventoryPage inventoryPage = new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .clickAddBackpackToCartButton();
        assertThat(inventoryPage.getCartBadge().getText(), equalTo("1"));
        getDriver().manage().deleteAllCookies();
        logger.info("вход с  " + getLockedUsername());
        getDriver().manage().addCookie(new Cookie("session-username", "locked_out_user", "/"));
        new LoginPage(getDriver())
                .checkErrorLockedUser();
        logger.info("Тест на обнуление куки при входе с другим логином завершен. (Обычного на заблокироавнного)");
    }

    @Test
    @Description("Тест на обнуление куки при входе с другим логином. (Обычного на медленного)")
    void setCookiesTes2() {
        logger.info("Тест на обнуление куки при входе с другим логином. (Обычного на медленного)");
        logger.info("вход с  " + getUsername());
        logger.info("пароль " + getPassword());
        InventoryPage inventoryPage = new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .clickAddBackpackToCartButton();
        assertThat(inventoryPage.getCartBadge().getText(), equalTo("1"));
        getDriver().manage().deleteAllCookies();
        logger.info("вход с  " + getPerformanceUsername());
        getDriver().manage().addCookie(new Cookie("session-username", "performance_glitch_user", "/"));
        assertThat(inventoryPage.getCartBadge().getText(), equalTo("0"));
        logger.info("Тест на обнуление куки при входе с другим логином завершен. (Обычного на медленного)");
    }

    @Test
    @Description("Тест на обнуление куки при входе с другим логином. (Медленного на проблемного)")
    void setCookiesTest3() {
        logger.info("Тест на обнуление куки при входе с другим логином. (Медленного на проблемного)");
        logger.info("вход с  " + getPerformanceUsername());
        logger.info("пароль " + getPassword());
        InventoryPage inventoryPage = new LoginPage(getDriver())
                .enterLogin(getPerformanceUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .clickAddBackpackToCartButton();
        assertThat(inventoryPage.getCartBadge().getText(), equalTo("1"));
        getDriver().manage().deleteAllCookies();
        logger.info("вход с  " + getUsername());
        getDriver().manage().addCookie(new Cookie("session-username", "problem_user", "/"));
        assertThat(inventoryPage.getCartBadge().getText(), equalTo("0"));
        logger.info("Тест на обнуление куки при входе с другим логином завершен. (Медленного на проблемного)");

    }

    @AfterEach
    void tearDown() {
        getDriver().get(getBaseUrl());
        new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .zeroing()
                .enterLogin(getProblemUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .zeroing()
                .enterLogin(getPerformanceUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .zeroing();
    }

}
