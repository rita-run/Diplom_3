import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToUserProfileTest {

    @BeforeClass
    public static void browserSetUp() {
        String browserNumber = System.getProperty("browserNumber");
        if (browserNumber != null && browserNumber.equals("browser_1")) {
            ChromeOptions options = new ChromeOptions();
            File file = new File("src/test/resources/yandexdriver");
            ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(file).build();
            ChromeDriver yandex = new ChromeDriver(service, options);
            WebDriverRunner.setWebDriver(yandex);
        } else {
            Configuration.browser = "chrome";
        }
        Configuration.startMaximized = true;
    }

    @After
    public void logout() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.clickLogoutButton();
        LoginPage loginPage = userProfilePage.goToTheLoginPage();
        loginPage.clickConstructorButton();
        loginPage.goToOrderConstructorPage();
    }

    @AfterClass
    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Navigating to the User Profile page test")
    public void navigatingToUserProfileTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage newConstructorPage = loginPage.goToOrderConstructorPage();
        newConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.assertThatProfilePageIsLoaded();
    }
}
