package ru.cytty.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.cytty.elements.SortingDropDownValues;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BaseAuthorizedPage {
    @Getter
    @FindBy(css = "#header_container > div.header_secondary_container > div.peek")
    WebElement imgTitlePage;
    @Getter
    @FindBy(css = "#header_container")
    WebElement filterButton;
    @Getter
    @FindBy(css = "#header_container > div.header_secondary_container > div.right_component > span > select")
    WebElement filterAZButton;
    @Getter
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    WebElement titleInventoryPage;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpackButton;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLightButton;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addBoltTShirtButton;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addFleeceJacketButton;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addOnesieButton;
    @Getter
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement addTShirtRedButton;

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
    @FindBy(css = "#item_4_img_link > img")
    WebElement imgBackpack;
    @Getter
    @FindBy(css = "#item_4_title_link")
    WebElement itemBackpack;
    @Getter
    @FindBy(css = "#item_0_title_link")
    WebElement itemBikeLight;
    @Getter
    @FindBy(css = "#item_0_img_link > img")
    WebElement imgBikeLight;
    @Getter
    @FindBy(css = "#item_1_title_link")
    WebElement itemBoltTShirt;
    @Getter
    @FindBy(css = "#item_1_img_link > img")
    WebElement imgBoltTShirt;
    @Getter
    @FindBy(css = "#item_5_title_link")
    WebElement itemFleeceJacket;
    @Getter
    @FindBy(css = "#item_5_img_link > img")
    WebElement imgFleeceJacket;
    @Getter
    @FindBy(css = "#item_2_title_link")
    WebElement itemOnesie;
    @Getter
    @FindBy(css = "#item_2_img_link > img")
    WebElement imgOnesie;
    @Getter
    @FindBy(css = "#item_3_title_link")
    WebElement itemTShirtRed;
    @Getter
    @FindBy(css = "#item_3_img_link > img")
    WebElement imgTShirtRed;
    @Getter
    @FindBy(css = "[data-test = back-to-products]")
    WebElement backToProductsButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkTitleSite() {
        assertThat(driver.getTitle(), equalTo("Swag Labs"));
        return this;
    }

    public InventoryPage checkImgTitlePage() {
        assertThat(existsElement(imgTitlePage), equalTo(true));
        return this;
    }

    public InventoryPage checkFilterButton() {
        assertThat(existsElement(filterButton), equalTo(true));
        return this;
    }

//    // имя опции текстом
//    public InventoryPage chooseSortingOption(String value){
//        filterAZButton.click();
//        By locator = SortingDropDownValues.valueOf(value).getElementLocator();
//        driver.findElement(locator).click();
//        return this;
//    }

    // имя опции типом ENUM
    @Step("Выбираем вариант сортировки товара")
    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        filterButton.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }

    public InventoryPage checkTitleInventoryPage() {
        assertThat(titleInventoryPage.getText(), equalTo("PRODUCTS"));
        return this;
    }

    public InventoryPage checkImgBackpack() {
        assertThat(existsElement(imgBackpack), equalTo(true));
        return this;
    }

    public InventoryPage checkCorrectImgBackpack() {
        assertThat(imgBackpack.getAttribute("src"), equalTo("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg"));
        return this;
    }

    public InventoryPage checkImgBikeLight() {
        assertThat(existsElement(imgBikeLight), equalTo(true));
        return this;
    }

    public InventoryPage checkCorrectImgBikeLight() {
        assertThat(imgBikeLight.getAttribute("src"), equalTo("https://www.saucedemo.com/static/media/bike-light-1200x1500.a0c9caae.jpg"));
        return this;
    }

    public InventoryPage checkImgBoltTShirt() {
        assertThat(existsElement(imgBoltTShirt), equalTo(true));
        return this;
    }

    public InventoryPage checkCorrectImgBoltTShirt() {
        assertThat(imgBoltTShirt.getAttribute("src"), equalTo("https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c0dae290.jpg"));
        return this;
    }

    public InventoryPage checkImgFleeceJacket() {
        assertThat(existsElement(imgFleeceJacket), equalTo(true));
        return this;
    }

    public InventoryPage checkCorrectImgFleeceJacket() {
        assertThat(imgFleeceJacket.getAttribute("src"), equalTo("https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.439fc934.jpg"));
        return this;
    }

    public InventoryPage checkImgOnesie() {
        assertThat(existsElement(imgOnesie), equalTo(true));
        return this;
    }

    public InventoryPage checkCorrectImgOnesie() {
        assertThat(imgOnesie.getAttribute("src"), equalTo("https://www.saucedemo.com/static/media/red-onesie-1200x1500.1b15e1fa.jpg"));
        return this;
    }

    public InventoryPage checkImgTShirtRed() {
        assertThat(existsElement(imgTShirtRed), equalTo(true));
        return this;
    }

    public InventoryPage checkCorrectImgTShirtRed() {
        assertThat(imgTShirtRed.getAttribute("src"), equalTo("https://www.saucedemo.com/static/media/red-tatt-1200x1500.e32b4ef9.jpg"));
        return this;
    }
    @Step("Заходим на страницу товара Backpack")
    public InventoryPage goPageBackpack() {
        itemBackpack.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=4"));
        return this;
    }
    @Step("Заходим на страницу товара Bike Light")
    public InventoryPage goPageBikeLight() {
        itemBikeLight.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=0"));
        return this;
    }
    @Step("Заходим на страницу товара Bolt T-Shirt")
    public InventoryPage goPageBoltTShirt() {
        itemBoltTShirt.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=1"));
        return this;
    }
    @Step("Заходим на страницу товара Fleece Jacket")
    public InventoryPage goPageFleeceJacket() {
        itemFleeceJacket.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=5"));
        return this;
    }
    @Step("Заходим на страницу товара Onesie (ошибка в наименовании One size)")
    public InventoryPage goPageOnesie() {
        itemOnesie.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=2"));
        return this;
    }
    @Step("Заходим на страницу товара T-Shirt Red")
    public InventoryPage goPageTShirtRed() {
        itemTShirtRed.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=3"));
        return this;
    }
    @Step("Возвращаемся со страницы товара в каталог товаров")
    public InventoryPage backToProducts() {
        backToProductsButton.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }
    @Step("Кладем в корзину Backpack в каталоге")
    public InventoryPage clickAddBackpackToCartButton() {
        addBackpackButton.click();
        return this;
    }
    @Step("Убираем из корзины Backpack в каталоге")
    public InventoryPage clickRemoveBackpackButton() {
        removeBackpackButton.click();
        return this;
    }
    @Step("Кладем в корзину Bike Light ")
    public InventoryPage clickAddBikeLightToCartButton() {
        addBikeLightButton.click();
        return this;
    }
    @Step("Убираем из корзины Bike Light в каталоге")
    public InventoryPage clickRemoveBikeLightButton() {
        removeBikeLightButton.click();
        return this;
    }
    @Step("Кладем в корзину Bolt T-Shirt")
    public InventoryPage clickAddBoltTShirtToCartButton() {
        addBoltTShirtButton.click();
        return this;
    }
    @Step("Убираем из корзины Bolt T-Shirt в каталоге")
    public InventoryPage clickRemoveBoltTShirtButton() {
        removeBoltTShirtButton.click();
        return this;
    }
    @Step("Кладем в корзину Fleece Jacket")
    public InventoryPage clickAddFleeceJacketToCartButton() {
        addFleeceJacketButton.click();
        return this;
    }
    @Step("Убираем из корзины Fleece Jacket в каталоге")
    public InventoryPage clickRemoveFleeceJacketButton() {
        removeFleeceJacketButton.click();
        return this;
    }
    @Step("Кладем в корзину Onesie (ошибка в наименовании One size)")
    public InventoryPage clickAddOnesieToCartButton() {
        addOnesieButton.click();
        return this;
    }
    @Step("Убираем из корзины Onesie в каталоге (ошибка в наименовании One size) ")
    public InventoryPage clickRemoveOnesieButton() {
        removeOnesieButton.click();
        return this;
    }
    @Step("Кладем в корзину T-Shirt Red")
    public InventoryPage clickAddTShirtRedToCartButton() {
        addTShirtRedButton.click();
        return this;
    }
    @Step("Убираем из корзины T-Shirt Red в каталоге")
    public InventoryPage clickRemoveTShirtRedButton() {
        removeTShirtRedButton.click();
        return this;
    }

    public InventoryPage checkAddBackpackToCartButton() {
        assertThat(existsElement(addBackpackButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-sauce-labs-backpack")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddBikeLightToCartButton() {
        assertThat(existsElement(addBikeLightButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-sauce-labs-bike-light")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddBoltTShirtToCartButton() {
        assertThat(existsElement(addBoltTShirtButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-sauce-labs-bolt-t-shirt")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddFleeceJacketToCartButton() {
        assertThat(existsElement(addFleeceJacketButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-sauce-labs-fleece-jacket")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddOnesieToCartButton() {
        assertThat(existsElement(addOnesieButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-sauce-labs-onesie")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddTShirtRedToCartButton() {
        assertThat(existsElement(addTShirtRedButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-test.allthethings()-t-shirt-(red)")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkRemoveBikeLightButton() {
        assertThat(existsElement(removeBikeLightButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-sauce-labs-bike-light")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkRemoveBoltTShirtToCartButton() {
        assertThat(existsElement(removeBoltTShirtButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-sauce-labs-bolt-t-shirt")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkRemoveFleeceJacketToCartButton() {
        assertThat(existsElement(removeFleeceJacketButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-sauce-labs-fleece-jacket")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkRemoveOnesieToCartButton() {
        assertThat(existsElement(removeOnesieButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-sauce-labs-onesie")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkRemoveTShirtRedToCartButton() {
        assertThat(existsElement(removeTShirtRedButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkRemoveBackpackButton() {
        assertThat(existsElement(removeBackpackButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-to-cart-sauce-labs-backpack")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAZSorting() {
        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductNamesTest = new ArrayList<>();
        listOfProductNamesTest.add(itemBackpack.getAccessibleName());
        listOfProductNamesTest.add(itemBikeLight.getAccessibleName());
        listOfProductNamesTest.add(itemBoltTShirt.getAccessibleName());
        listOfProductNamesTest.add(itemFleeceJacket.getAccessibleName());
        listOfProductNamesTest.add(itemOnesie.getAccessibleName());
        listOfProductNamesTest.add(itemTShirtRed.getAccessibleName());

        for (int i = 0; i < listOfProductNamesTest.size(); i++) {
            assertThat(listOfProductNamesTest.get(i), equalTo(listOfProductNames.get(i)));
        }
        return this;
    }

    public InventoryPage checkZASorting() {
        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductNamesTest = new ArrayList<>();
        listOfProductNamesTest.add(itemTShirtRed.getAccessibleName());
        listOfProductNamesTest.add(itemOnesie.getAccessibleName());
        listOfProductNamesTest.add(itemFleeceJacket.getAccessibleName());
        listOfProductNamesTest.add(itemBoltTShirt.getAccessibleName());
        listOfProductNamesTest.add(itemBikeLight.getAccessibleName());
        listOfProductNamesTest.add(itemBackpack.getAccessibleName());


        for (int i = 0; i < listOfProductNamesTest.size(); i++) {
            assertThat(listOfProductNamesTest.get(i), equalTo(listOfProductNames.get(i)));
        }
        return this;
    }

    public InventoryPage checkToHighSorting() {
        List<String> listOfProductPrices = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductPricesTest = new ArrayList<>();
        listOfProductPrices.add(itemOnesie.getAccessibleName());
        listOfProductPrices.add(itemBikeLight.getAccessibleName());
        listOfProductPrices.add(itemBoltTShirt.getAccessibleName());
        listOfProductPrices.add(itemTShirtRed.getAccessibleName());
        listOfProductPrices.add(itemBackpack.getAccessibleName());
        listOfProductPrices.add(itemFleeceJacket.getAccessibleName());

        for (int i = 0; i < listOfProductPricesTest.size(); i++) {
            assertThat(listOfProductPricesTest.get(i), equalTo(listOfProductPrices.get(i)));
        }
        return this;
    }

    public InventoryPage checkToLowSorting() {
        List<String> listOfProductPrices = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductPricesTest = new ArrayList<>();
        listOfProductPrices.add(itemFleeceJacket.getAccessibleName());
        listOfProductPrices.add(itemBackpack.getAccessibleName());
        listOfProductPrices.add(itemTShirtRed.getAccessibleName());
        listOfProductPrices.add(itemBoltTShirt.getAccessibleName());
        listOfProductPrices.add(itemBikeLight.getAccessibleName());
        listOfProductPrices.add(itemOnesie.getAccessibleName());

        for (int i = 0; i < listOfProductPricesTest.size(); i++) {
            assertThat(listOfProductPricesTest.get(i), equalTo(listOfProductPrices.get(i)));
        }
        return this;
    }
}
