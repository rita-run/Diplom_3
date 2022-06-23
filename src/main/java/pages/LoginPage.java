package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private final SelenideElement constructorButton = $(byText("Конструктор"));
    private final SelenideElement signUpButton = $(byText("Зарегистрироваться"));
    private final SelenideElement emailField = $(byXpath("//input[@name = 'name']"));
    private final SelenideElement passField = $(byXpath("//input[@name = 'Пароль']"));
    private final SelenideElement loginButton = $(byText("Войти"));

    public void assertThatLoginPageIsLoaded() {
        $(byTextCaseInsensitive("Вход")).shouldBe(visible);
    }

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void sendTheLoginForm(String email, String password) {
        emailField.setValue(email);
        passField.setValue(password);
        loginButton.click();
    }

    public RegisterPage goToTheRegisterPage() {
        clickSignUpButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.assertThatRegisterPageIsLoaded();
        return registerPage;
    }

    public OrderConstructorPage goToOrderConstructorPage() {
        OrderConstructorPage orderConstructorPage = page(OrderConstructorPage.class);
        orderConstructorPage.assertThatConstructorPageIsLoaded();
        return orderConstructorPage;
    }

}

