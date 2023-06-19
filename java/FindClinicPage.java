import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FindClinicPage extends BasePage {
    public FindClinicPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "clinic")
    protected WebElement findClinicField;

    @FindBy(css = ".search_it")
    protected WebElement findClinicSearchButton;

    @FindBy(css = ".btn_blue.nopass_modal")
    protected WebElement getAnAppointmentButton;

    @FindBy(id = "appointmentDiv0")
    protected WebElement appointmentTypeDropdown;

    @FindBy(id = "appointmentDiv4")
    protected WebElement visitTypeDropdown;

    @FindBy(id = "dp1687097460529")
    protected WebElement dateField;

    @FindBy(id = "appointmentDiv5")
    protected WebElement cityOrClinicDropdown;

    @FindBy(css = "[name='step_1_submit']")
    protected WebElement continueToSelectAnAppointmentButton;

    @FindBy(css = ".td.make_appointment_button")
    protected WebElement chooseAppointmentButton;

    @FindBy(css = ".wpcf7-form-control.has-spinner.wpcf7-submit.validate-id-bt")
    protected List<WebElement> listOfContinueButtons;

    @FindBy(css = ".wpcf7-not-valid-tip")
    protected WebElement errorMessage;

    @FindBy(css = "label[for='requested_service1']")
    protected WebElement appointmentOptionNumber1;

    @FindBy(css = "label[for='video_or_regular2']")
    protected WebElement visitOptionNumber2;

    @FindBy(id = "ui-id-61")
    protected WebElement asotaOption;

    public void enterCityDetailsAndClickSearch() {
        wait.until(ExpectedConditions.visibilityOf(findClinicField));
        findClinicField.sendKeys("תל אביב - אסותא רמת החייל");
        findClinicSearchButton.click();
    }

    public void scrollToAndClickOnGetAnAppointment() {
        scrollDownToElementAndClick(getAnAppointmentButton);
    }

    public void fillDetailsAboutTheAppointment() {
        wait.until(ExpectedConditions.elementToBeClickable(appointmentTypeDropdown));
        waitAndClick(appointmentTypeDropdown);
        scrollDownToElementAndClick(appointmentOptionNumber1);
        wait.until(ExpectedConditions.visibilityOf(dateField));
        dateField.sendKeys("03/03/2000", Keys.ENTER);
        selectFromDropdown(visitTypeDropdown, visitOptionNumber2);
        cityOrClinicDropdown.sendKeys("תל אביב - אסותא רמת החיי");
        waitAndClick(asotaOption);
    }

    public void submitAppointmentDetails() {
        waitAndClick(continueToSelectAnAppointmentButton);
    }

    public void chooseAppointment() {
        waitAndClick(chooseAppointmentButton);
    }

    public void continueWithoutId() {
        listOfContinueButtons.get(1).click();
    }

    public void validateErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
    }

}
