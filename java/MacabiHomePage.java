import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;


public class MacabiHomePage extends BasePage{
    public MacabiHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".mr-2.mr-2_EL")
    protected WebElement goToMacabiDentButton;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ucPresentation_ancFirstLink")
    protected WebElement locateBranchButton;

    public void scrollDownAndClickMacabiDentButton() {
        scrollDownToElementAndClick(goToMacabiDentButton);
    }

    public void clickOnLocateBranch() {
        String parentWindowHandle = driver.getWindowHandle();

        waitAndClick(locateBranchButton);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
