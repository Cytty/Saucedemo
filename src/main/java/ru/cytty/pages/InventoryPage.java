package ru.cytty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BaseAuthorizedPage {

    @FindBy(css = "#header_container > div.header_secondary_container > div.peek")
    private WebElement imgTitlePage;
    @FindBy(css = "#header_container")
    private WebElement filterButton;
    @FindBy(css = "#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(1)")
    private WebElement filterAZButton;
    @FindBy(css = "#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(2)")
    private WebElement filterZAButton;
    @FindBy(css = "#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(3)")
    private WebElement filterToHighButton;
    @FindBy(css = "#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(4)")
    private WebElement filterToLowButton;
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement titleInventoryPage;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement cartButton;
    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div > a")
    private WebElement firstPlaceFilter;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage clickItemInCartButton() {
        cartButton.click();
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

    public InventoryPage clickFilterButton() {
        filterButton.click();
        assertThat(filterAZButton.getText(), equalTo("Name (A to Z)"));
        assertThat(filterZAButton.getText(), equalTo("Name (Z to A)"));
        assertThat(filterToHighButton.getText(), equalTo("Price (low to high)"));
        assertThat(filterToLowButton.getText(), equalTo("Price (high to low)"));
        return this;
    }

    public InventoryPage checkTitleInventoryPage() {
        assertThat(titleInventoryPage.getText(), equalTo("PRODUCTS"));
        return this;
    }

}
