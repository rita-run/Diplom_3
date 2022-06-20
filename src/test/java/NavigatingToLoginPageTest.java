import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToLoginPageTest {
    @Before
    public void init() {
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
