package ru.cytty.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepTwoPage extends BaseAuthorizedPage {

    @FindBy(className = "summary_info_label")
    WebElement paymentInformation;
    @FindBy(id = "finish")
    WebElement finishButton;


    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    public StepTwoPage checkStepTwoPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

    public StepTwoPage checkFieldInformation() {
        assertThat(existsElement(paymentInformation), equalTo(true));
        return this;
    }

    public StepTwoPage checkLabelInformation() {
        assertThat(paymentInformation.getText(), equalTo("Payment Information:"));
        return this;
    }
    @Step("Завершаем оформление заказа")
    public CompletePage clickToFinishButton() {
        finishButton.click();
        return new CompletePage(driver);
    }

}
