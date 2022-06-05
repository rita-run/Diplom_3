package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {
    private SelenideElement nameField = $$(byXpath("//input[@name = 'name']")).get(0);
    private SelenideElement emailField = $$(byXpath("//input[@name = 'name']")).get(1);
    private SelenideElement passField = $(byXpath("//input[@name = 'Пароль']"));
    private SelenideElement signUpButton = $(byText("Зарегистрироваться"));
    private SelenideElement invalidPasswordMessage = $(byText("Некорректный пароль"));
    private SelenideElement loginButton = $(byText("Войти"));
    public void waitForLoadRegisterPage() {
        $(byClassName("Auth_login__3hAey")).shouldBe(visible);
    }

    public void sendTheSignUpForm(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passField.setValue(password);
        signUpButton.click();
    }

    public void checkInvalidPassMessage() {
        invalidPasswordMessage.shouldBe(visible);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public LoginPage goToTheLoginPage(){
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }
}
