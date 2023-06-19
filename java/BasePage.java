import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    protected void selectFromDropdown(WebElement webElement, WebElement value) {
        waitAndClick(webElement);
        waitAndClick(value);
    }

    protected void waitAndClick(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    protected void scrollDownToElementAndClick(WebElement element) {
        boolean elementClicked = false;
        while (!elementClicked) {
            scrollPage();

            if (isElementClickable(element)) {
                moveToElement(element);

                element.click();
                elementClicked = true;
            } else {
                addDelay();
            }
        }
    }

    private void scrollPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 150);");
    }

    private boolean isElementClickable(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException ex) {
            return false;
        }
    }

    private void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    private void addDelay() {
        try {
            // Add a delay of 1 second before the next attempt
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
