package ru.cytty.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends BaseAuthorizedPage {

    @Getter
    @FindBy(css = "#item_4_title_link")
    WebElement itemBackpack;
    @Getter
    @FindBy(css = "#item_0_title_link")
    WebElement itemBikeLight;
    @Getter
    @FindBy(css = "#item_1_title_link")
    WebElement itemBoltTShirt;
    @Getter
    @FindBy(css = "#item_5_title_link")
    WebElement itemFleeceJacket;
    @Getter
    @FindBy(css = "#item_2_title_link")
    WebElement itemOnesie;
    @Getter
    @FindBy(css = "#item_3_title_link")
    WebElement itemTShirtRed;
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLightButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeBoltTShirtButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeFleeceJacketButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeOnesieButton;
    @Getter
    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeTShirtRedButton;
    @Getter
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkCartPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }

    public CartPage checkBackpackInTheCart() {
        assertThat(existsElement(itemBackpack), equalTo(true));
        return this;
    }

    public CartPage checkBikeLightInTheCart() {
        assertThat(existsElement(itemBikeLight), equalTo(true));
        return this;
    }

    public CartPage checkBoltTShirtInTheCart() {
        assertThat(existsElement(itemBoltTShirt), equalTo(true));
        return this;
    }

    public CartPage checkFleeceJacketInTheCart() {
        assertThat(existsElement(itemFleeceJacket), equalTo(true));
        return this;
    }

    public CartPage checkOnesieInTheCart() {
        assertThat(existsElement(itemOnesie), equalTo(true));
        return this;
    }
    public CartPage checkTShirtRedInTheCart() {
        assertThat(existsElement(itemTShirtRed), equalTo(true));
        return this;
    }


    public CartPage checkNoBackpackInTheCart() {
        assertThat(driver.findElements(By.cssSelector("#item_4_title_link")).size(), equalTo(0));
        return this;
    }


    public CartPage checkNoBikeLightInTheCart() {
        assertThat(driver.findElements(By.cssSelector("#item_0_title_link")).size(), equalTo(0));
        return this;
    }

    public CartPage checkNoBoltTShirtInTheCart() {
        assertThat(driver.findElements(By.cssSelector("#item_1_title_link")).size(), equalTo(0));
        return this;
    }

    public CartPage checkNoFleeceJacketInTheCart() {
        assertThat(driver.findElements(By.cssSelector("#item_5_title_link")).size(), equalTo(0));
        return this;
    }

    public CartPage checkNoOnesieInTheCart() {
        assertThat(driver.findElements(By.cssSelector("#item_2_title_link")).size(), equalTo(0));
        return this;
    }
    public CartPage checkNoTShirtRedInTheCart() {
        assertThat(driver.findElements(By.cssSelector("#item_3_title_link")).size(), equalTo(0));
        return this;
    }
    @Step("Переходим к оформлению заказа")
    public StepOnePage clickToCheckoutButton() {
        checkoutButton.click();
        return new StepOnePage(driver);
    }
    @Step("Убираем из корзины Backpack в корзине")
    public CartPage clickRemoveBackpackButton() {
        removeBackpackButton.click();
        return this;
    }
    @Step("Убираем из корзины Bike Light в корзине")
    public CartPage clickRemoveBikeLightButton() {
        removeBikeLightButton.click();
        return this;
    }
    @Step("Убираем из корзины Bolt T-Shirt в корзине")
    public CartPage clickRemoveBoltTShirtButton() {
        removeBoltTShirtButton.click();
        return this;
    }
    @Step("Убираем из корзины Fleece Jacket в корзине")
    public CartPage clickRemoveFleeceJacketButton() {
        removeFleeceJacketButton.click();
        return this;
    }
    @Step("Убираем из корзины Onesie в корзине (ошибка в наименовании One size) ")
    public CartPage clickRemoveOnesieButton() {
        removeOnesieButton.click();
        return this;
    }
    @Step("Убираем из корзины T-Shirt Red в корзине")
    public CartPage clickRemoveTShirtRedButton() {
        removeTShirtRedButton.click();
        return this;
    }
    @Step("Возвращаемся из корзины в каталог")
    public InventoryPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new InventoryPage(driver);
    }

    public CartPage checkRemoveBackpackButton() {
        assertThat(existsElement(removeBackpackButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-to-cart-sauce-labs-backpack")).size(), equalTo(0));
        return this;
    }

}
