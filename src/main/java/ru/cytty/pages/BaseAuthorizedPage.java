package ru.cytty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.cytty.utils.TabUtils.switchToTheNextTab;

public class BaseAuthorizedPage extends BasePage {

    public BaseAuthorizedPage(final WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    //hat
    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideMenuButton;
    @FindBy(className = "app_logo")
    private WebElement logoLabel;
    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;
    @FindBy(css = "#shopping_cart_container > a > span")
    private WebElement badgeCartButton;
    //basement
    @FindBy(css = "#page_wrapper > footer > ul >li.social_twitter")
    private WebElement twitterButton;
    @FindBy(css = "#page_wrapper > footer > ul >li.social_facebook")
    private WebElement facebookButton;
    @FindBy(css = "#page_wrapper > footer > ul >li.social_linkedin")
    private WebElement linkedInButton;
    @FindBy(className = "footer_copy")
    private WebElement labelBasement;
    @FindBy(className = "footer_robot")
    WebElement imgRobot;
    //sideMenu
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;
    @FindBy(id = "reset_sidebar_link")
    private WebElement resetButton;
    @FindBy(id = "react-burger-cross-btn")
    private WebElement exitSideButton;


    public BaseAuthorizedPage checkTitleSite() {
        assertThat(driver.getTitle(), equalTo("Swag Labs"));
        return this;
    }

    //hut
    //hut-side
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

    public CartPage clickToCartButton() {
        cartButton.click();
        return new CartPage(driver);
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

    public void clickSideAboutButton() {
        aboutButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("saucelabs.com"));
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

    public BaseAuthorizedPage clickSideResetAppStateButton() {
        resetButton.click();
        assertThat(existsElement(badgeCartButton), equalTo(true));
        return this;
    }

    public BaseAuthorizedPage checkSideCloseMenuButton() {
        assertThat(existsElement(exitSideButton), equalTo(true));
        return this;
    }

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

    public void goToTwitter() {
        twitterButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
    }

    //basement-facebook
    public BaseAuthorizedPage checkFacebookButton() {
        assertThat(existsElement(facebookButton), equalTo(true));
        return this;
    }

    public void goToFacebook() {
        facebookButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
    }

    //basement-linkedIn
    public BaseAuthorizedPage checkLinkedInButton() {
        assertThat(existsElement(linkedInButton), equalTo(true));
        return this;
    }

    public void goToLinkedIn() {
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

   //unlogin
    void tearDown() {
        exitSideButton.click();
        logoutButton.click();
    }

}
