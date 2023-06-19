import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected MacabiHomePage homePage;
    protected FindClinicPage findClinicPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected void navigateToMacabiHomePage() {
        driver.get("https://www.maccabi4u.co.il/");
    }
}
