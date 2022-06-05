import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @After
    public void closeWindow() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Login after navigating to the Login page from the Order Constructor page via login button test")
    public void loginViaLoginButtonTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.waitConstructorPageLoad();
    }

    @Test
    @DisplayName("Login after navigating to the Login page from the Order Constructor page via profile button test")
    public void loginViaProfileButtonTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickUserProfileButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.waitConstructorPageLoad();
    }

    @Test
    @DisplayName("Login after navigating to the Login page from the Register page test")
    public void loginFromRegisterPageTest() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registerPage.clickLoginButton();
        LoginPage loginPage = registerPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.waitConstructorPageLoad();
    }

    @Test
    @DisplayName("Login after navigating to the Login page from the Forgot Password page test")
    public void loginFromForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = forgotPasswordPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.waitConstructorPageLoad();
    }

}
