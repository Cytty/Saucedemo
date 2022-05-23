package ru.cytty.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class StepOnePage extends BaseAuthorizedPage {
    static Faker faker = new Faker();

    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    private WebElement labelError;
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement titleStepOnePage;
    @FindBy(id = "cancel")
    private WebElement cancelButton;


    public StepOnePage(WebDriver driver) {
        super(driver);
    }


    public StepOnePage enterFirstName() {
        firstName.click();
        firstName.sendKeys(faker.name().fullName());
        return this;
    }

    public StepOnePage enterLastName() {
        lastName.click();
        lastName.sendKeys(faker.name().lastName());
        return this;
    }

    public StepOnePage enterPostalCode() {
        postalCode.click();
        postalCode.sendKeys(faker.code().toString());
        return this;
    }

    public StepOnePage clickToContinueErrorButton() {
        continueButton.click();
        assertThat(labelError.getText(), equalTo("Error: First Name is required"));
        return this;
    }

    public StepTwoPage clickToContinueButton() {
        continueButton.click();
        return new StepTwoPage(driver);
    }


    public StepOnePage checkStepOnePageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        return this;
    }

    public StepOnePage checkContentLabelPage() {
        assertThat(titleStepOnePage.getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
        return this;
    }

    public StepOnePage checkFieldFirstName() {
        assertThat(existsElement(firstName), equalTo(true));
        return this;
    }

    public StepOnePage checkFirstNamePlaceholder() {
        assertThat(firstName.getAttribute("placeholder"), equalTo("First Name"));
        return this;
    }

    public StepOnePage checkFieldLastName() {
        assertThat(existsElement(lastName), equalTo(true));
        return this;
    }

    public StepOnePage checkLastNamePlaceholder() {
        assertThat(lastName.getAttribute("placeholder"), equalTo("Last Name"));
        return this;
    }

    public StepOnePage checkFieldPostalCode() {
        assertThat(existsElement(postalCode), equalTo(true));
        return this;
    }

    public StepOnePage checkPostalCodePlaceholder() {
        assertThat(postalCode.getAttribute("placeholder"), equalTo("Zip/Postal Code"));
        return this;
    }

    public StepOnePage checkCancelButton() {
        assertThat(existsElement(cancelButton), equalTo(true));
        return this;
    }

    public StepOnePage checkLabelCancelButton() {
        assertThat(cancelButton.getText(), equalTo("CANCEL"));
        return this;
    }

    public StepOnePage checkContinueButton() {
        assertThat(existsElement(continueButton), equalTo(true));
        return this;
    }

    public StepOnePage checkLabelContinueButton() {
        assertThat(continueButton.getAttribute("value"), equalTo("Continue"));
        return this;
    }

}
