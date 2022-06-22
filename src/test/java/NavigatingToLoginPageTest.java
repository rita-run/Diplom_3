import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToLoginPageTest {
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
    @DisplayName("Login after navigating to the Login page from the Register page test")
    public void loginFromRegisterPageTest() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.clickLoginButton();
        LoginPage loginPage = registerPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.assertThatConstructorPageIsLoaded();
    }

    @Test
    @DisplayName("Login after navigating to the Login page from the Forgot Password page test")
    public void loginFromForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.assertThatConstructorPageIsLoaded();
    }
}
