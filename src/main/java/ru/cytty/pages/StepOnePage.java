package ru.cytty.pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepOnePage extends BaseAuthorizedPage {
    static Faker faker = new Faker();

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error")
    WebElement labelError;
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    WebElement titleStepOnePage;
    @FindBy(id = "cancel")
    WebElement cancelButton;


    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим Имя {firstName}")
    public StepOnePage enterFirstName() {
        firstName.click();
        firstName.sendKeys(faker.name().fullName());
        return this;
    }
    @Step("Вводим Фамилию {lastName}")
    public StepOnePage enterLastName() {
        lastName.click();
        lastName.sendKeys(faker.name().lastName());
        return this;
    }
    @Step("Вводим адрес {postalCode}")
    public StepOnePage enterPostalCode() {
        postalCode.click();
        postalCode.sendKeys(faker.code().toString());
        return this;
    }
    @Step("Продолжаем оформление заказа без ввода данных адресата")
    public StepOnePage clickToContinueErrorButton() {
        continueButton.click();
        assertThat(existsElement(labelError), equalTo(true));
        return this;
    }
    @Step("Продолжаем оформление заказа после ввода данных адресата")
    public StepTwoPage clickToContinueButton() {
        continueButton.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
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
