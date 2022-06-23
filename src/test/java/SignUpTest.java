import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.RegisterPage;

import org.apache.commons.lang3.RandomStringUtils;
import static com.codeborne.selenide.Selenide.open;

public class SignUpTest extends BaseTest {
    String generatedName = RandomStringUtils.randomAlphanumeric(7);

    @Test
    @DisplayName("Signing up using valid data test")
    public void validDataSignUpTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        RegisterPage registerPage = loginPage.goToTheRegisterPage();
        registerPage.sendTheSignUpForm(generatedName, generatedName + "@gmail.com", "password");
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
        registerPage.sendTheSignUpForm(generatedName, generatedName + "@gmail.com", "12345");
        registerPage.assertThatInvalidPassMessageIsShown();
    }
}
