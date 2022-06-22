import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

public class LogoutTest {
    OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);

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

    @AfterClass
    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Logout test")
    public void logoutTest() {
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.assertThatConstructorPageIsLoaded();
        orderConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.clickLogoutButton();
        loginPage.assertThatLoginPageIsLoaded();
    }
}
