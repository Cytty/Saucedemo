package ru.cytty.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.cytty.utils.TabUtils.switchToTheNextTab;

public class BaseAuthorizedPage extends BasePage {
    final static Logger logger = LoggerFactory.getLogger(BaseAuthorizedPage.class);

    public BaseAuthorizedPage(final WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    //hat
    @Getter
    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenuButton;
    @Getter
    @FindBy(className = "app_logo")
    WebElement logoLabel;
    @Getter
    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    @Getter
    @FindBy(css = "#shopping_cart_container > a > span ") //  .shopping_cart_badge
    WebElement cartBadge;
    //basement
    @Getter
    @FindBy(css = "#page_wrapper > footer > ul >li.social_twitter")
    WebElement twitterButton;
    @Getter
    @FindBy(css = "#page_wrapper > footer > ul >li.social_facebook")
    WebElement facebookButton;
    @Getter
    @FindBy(css = "#page_wrapper > footer > ul >li.social_linkedin")
    WebElement linkedInButton;
    @Getter
    @FindBy(className = "footer_copy")
    WebElement labelBasement;
    @Getter
    @FindBy(className = "footer_robot")
    WebElement imgRobot;
    @Getter
    //sideMenu
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;
    @Getter
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsButton;
    @Getter
    @FindBy(id = "about_sidebar_link")
    WebElement aboutButton;
    @Getter
    @FindBy(id = "reset_sidebar_link")
    WebElement resetButton;
    @Getter
    @FindBy(id = "react-burger-cross-btn")
    WebElement exitSideButton;


    public BaseAuthorizedPage checkTitleSite() {
        assertThat(driver.getTitle(), equalTo("Swag Labs"));
        return this;
    }

    //hut
    //hut-side
    @Step("Нажимаем кнопку бокового меню")
    public BaseAuthorizedPage clickSideMenuButton() {
        sideMenuButton.click();
        return this;
    }

    public BaseAuthorizedPage checkSideMenuButton() {
        assertThat(existsElement(sideMenuButton), equalTo(true));
        return this;
    }

    //hut-lodo
    public BaseAuthorizedPage checkLogoLabel() {
        assertThat(existsElement(logoLabel), equalTo(true));
        return this;
    }

    //hut-cart
    public BaseAuthorizedPage checkCartButton() {
        assertThat(existsElement(cartButton), equalTo(true));
        return this;
    }
    @Step("Переходим в корзину")
    public CartPage clickToCartButton() {
        cartButton.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return new CartPage(driver);
    }

    public BaseAuthorizedPage checkBadgeCartButton() {
        assertThat(existsElement(cartBadge), equalTo(true));
        return this;
    }

    public BaseAuthorizedPage checkNoBadgeCartButton() {
        //  assertThat(existsElement(cartBadge), equalTo(false)); - так тест не работает
        assertThat(driver.findElements(By.cssSelector(".shopping_cart_badge")).size(), equalTo(0));
        return this;
    }

    //side
    //side-allitems
    public BaseAuthorizedPage checkSideAllItemsButton() {
        assertThat(existsElement(allItemsButton), equalTo(true));

        return this;
    }

    public BaseAuthorizedPage checkSideLabelAllItemsButton() {
        assertThat(allItemsButton.getAccessibleName(), equalTo("ALL ITEMS"));
        return this;
    }
    @Step("Нажимаем кнопку перехода в каталог в боковом меню")
    public InventoryPage clickSideAllItemsButton() {
        allItemsButton.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return new InventoryPage(driver);
    }

    //side-about
    public BaseAuthorizedPage checkSideAboutButton() {
        assertThat(existsElement(aboutButton), equalTo(true));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelAboutButton() {
        assertThat(aboutButton.getAccessibleName(), equalTo("ABOUT"));
        return this;
    }
    @Step("Нажимаем кнопку About в боковом меню")
    public void clickSideAboutButton() {
        aboutButton.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://saucelabs.com/"));
      }

    //side-logout
    public BaseAuthorizedPage checkSideLogoutButton() {
        assertThat(existsElement(logoutButton), equalTo(true));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelLogoutButton() {
        assertThat(logoutButton.getAccessibleName(), equalTo("LOGOUT"));
        return this;
    }
    @Step("Нажимаем кнопку Logout в боковом меню")
    public LoginPage clickSideLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    //side-reset
    public BaseAuthorizedPage checkSideResetAppStateButton() {
        assertThat(existsElement(resetButton), equalTo(true));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelResetAppStateButton() {
        assertThat(resetButton.getAccessibleName(), equalTo("RESET APP STATE"));
        return this;
    }
    @Step("Нажимаем кнопку  ResetAppState в боковом меню")
    public BaseAuthorizedPage clickSideResetAppStateButton() {
        resetButton.click();
        assertThat(existsElement(cartBadge), equalTo(true));
        return this;
    }

    public BaseAuthorizedPage checkSideCloseMenuButton() {
        assertThat(existsElement(exitSideButton), equalTo(true));
        return this;
    }
    @Step("Нажимаем кнопку  закрытия бокового меню")
    public BaseAuthorizedPage clickSideCloseMenuButton() {
        exitSideButton.click();
        return this;
    }

    //basement
    //basement-twitter
    public BaseAuthorizedPage checkTwitterButton() {
        assertThat(existsElement(twitterButton), equalTo(true));
        return this;
    }
    @Step("Нажимаем кнопку  twitter")
    public void goToTwitter()  {
        logger.info("Идем в твиттер");
        twitterButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
    }

    //basement-facebook
    public BaseAuthorizedPage checkFacebookButton() {
        assertThat(existsElement(facebookButton), equalTo(true));
        return this;
    }
    @Step("Нажимаем кнопку  facebook")
    public void goToFacebook() {
        logger.info("Идем в фейсбук");
        facebookButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
    }

    //basement-linkedIn
    public BaseAuthorizedPage checkLinkedInButton() {
        assertThat(existsElement(linkedInButton), equalTo(true));
        return this;
    }
    @Step("Нажимаем кнопку  linkedin")
    public void goToLinkedIn() {
        logger.info("Идем в линдкин");
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
    }

    //basement-text
    public BaseAuthorizedPage checkLabelInBasement() {
        assertThat(labelBasement.getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        return this;
    }

    //basement-imgRobot
    public BaseAuthorizedPage checkImgInBasement() {
        assertThat(existsElement(imgRobot), equalTo(true));
        return this;
    }
    @Step("Обнуляем корзину и разлогиниваемся")
    public LoginPage zeroing() {
        sideMenuButton.click();
        resetButton.click();
        logoutButton.click();
        return new LoginPage(driver);
    }


}
