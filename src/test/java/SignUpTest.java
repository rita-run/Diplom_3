import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import static com.codeborne.selenide.Selenide.open;

import java.io.File;
import java.util.Random;

public class SignUpTest {
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

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String generateName() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return builder.toString();
    }

    @Test
    @DisplayName("Signing up using valid data test")
    public void validDataSignUpTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        RegisterPage registerPage = loginPage.goToTheRegisterPage();
        registerPage.sendTheSignUpForm(generateName(), generateName() + "@gmail.com", "password");
        LoginPage newLoginPage = registerPage.goToTheLoginPage();
        newLoginPage.assertThatLoginPageIsLoaded();
    }

    @Test
    @DisplayName("Signing up using an invalid password")
    public void invalidPassSignUpTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        RegisterPage registerPage = loginPage.goToTheRegisterPage();
        registerPage.sendTheSignUpForm(generateName(), generateName() + "@gmail.com", "12345");
        registerPage.assertThatInvalidPassMessageIsShown();
    }
}
