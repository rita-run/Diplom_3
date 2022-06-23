package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {
    private final SelenideElement nameField = $$(byXpath("//input[@name = 'name']")).get(0);
    private final SelenideElement emailField = $$(byXpath("//input[@name = 'name']")).get(1);
    private final SelenideElement passField = $(byXpath("//input[@name = 'Пароль']"));
    private final SelenideElement signUpButton = $(byText("Зарегистрироваться"));
    private final SelenideElement invalidPasswordMessage = $(byText("Некорректный пароль"));
    private final SelenideElement loginButton = $(byText("Войти"));

    public void assertThatRegisterPageIsLoaded() {
        $(byText("Регистрация")).shouldBe(visible);
    }

    public void sendTheSignUpForm(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passField.setValue(password);
        signUpButton.click();
    }

    public void assertThatInvalidPassMessageIsShown() {
        invalidPasswordMessage.shouldBe(visible);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public LoginPage goToTheLoginPage(){
        LoginPage loginPage = page(LoginPage.class);
        loginPage.assertThatLoginPageIsLoaded();
        return loginPage;
    }
}
