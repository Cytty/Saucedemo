package ru.cytty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompletePage extends BaseAuthorizedPage {

    @FindBy(className = "complete-header")
    WebElement labelCompleteOnPage;


    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public CompletePage checkCompletePageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    public CompletePage checkLabelCompleteOnPage() {
        assertThat(labelCompleteOnPage.getText(), equalTo("THANK YOU FOR YOUR ORDER"));
        return this;
    }

}