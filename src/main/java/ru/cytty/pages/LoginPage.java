package ru.cytty.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends BasePage {
    @Getter
    @FindBy(id = "user-name")
    private WebElement loginInput;
    @Getter
    @FindBy(name = "password")
    private WebElement passwordInput;
    @Getter
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;
    @Getter
    @FindBy(css = "[data-test='error']")
    WebElement errorLogIn;
    @Getter
    @FindBy(className = "error-button")
    WebElement errorButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Вводим логин {loginName}")
    public LoginPage enterLogin(String loginName) {
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }
    @Step("Вводим пароль {password}")
    public LoginPage enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Кликаем на кнопку 'Авторизоваться'")
    public InventoryPage clickLoginButton()  {
        loginButton.click();
        return new InventoryPage(driver);
    }
    @Step("Чистим поля авторизации")
    public LoginPage cleaningAuthorization() {
        errorButton.click();
        loginInput.clear();
        passwordInput.clear();
        return this;
    }
    public LoginPage checkLoginPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        return this;
    }

    public LoginPage checkErrorLogIn() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        assertThat(errorLogIn.getAccessibleName(), equalTo("Epic sadface: Username and password do not match any user in this service"));
        return this;
    }

    public LoginPage checkErrorLockedUser() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        assertThat(errorLogIn.getAccessibleName(), equalTo("Epic sadface: Sorry, this user has been locked out."));
        return this;
    }
}
