import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAppointmentTest extends BaseTest {
    @BeforeClass
    public void start() {
        navigateToMacabiHomePage();
        homePage = new MacabiHomePage(driver);
        findClinicPage = new FindClinicPage(driver);
    }

    @Test
    public void verifyIdIsEmptyMessage() {
        homePage.scrollDownAndClickMacabiDentButton();
        homePage.clickOnLocateBranch();
        findClinicPage.enterCityDetailsAndClickSearch();
        findClinicPage.scrollToAndClickOnGetAnAppointment();
        findClinicPage.fillDetailsAboutTheAppointment();
        findClinicPage.submitAppointmentDetails();
        findClinicPage.chooseAppointment();
        findClinicPage.continueWithoutId();
        findClinicPage.validateErrorMessage();
    }
}
