import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.*;
import static com.codeborne.selenide.Selenide.open;
import java.util.Random;
import java.nio.charset.Charset;
import com.codeborne.selenide.Selenide;


public class SignUpTest {
    private String generateName() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String name = new String(array, Charset.forName("UTF-8"));
        return name;
    }

    @After
    public void closeWindow() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Signing up using valid data test")
    public void validDataSignUpTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        RegisterPage registerPage = loginPage.goToTheRegisterPage();
        registerPage.sendTheSignUpForm(generateName(), generateName() + "gmail.com", "password");
        loginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Signing up using an invalid password")
    public void invalidPassSignUpTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        RegisterPage registerPage = loginPage.goToTheRegisterPage();
        registerPage.sendTheSignUpForm(generateName(), generateName() + "gmail.com", "12345");
        registerPage.checkInvalidPassMessage();
    }
}
