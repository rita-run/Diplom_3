import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import static com.codeborne.selenide.Selenide.open;

import java.util.Random;

public class SignUpTest {

    @Before
    public void init() {
        Configuration.startMaximized = true;
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
