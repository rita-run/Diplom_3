package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement signUpButton = $(byText("Зарегистрироваться"));
    private SelenideElement emailField = $(byXpath("//input[@name = 'name']"));
    private SelenideElement passField = $(byXpath("//input[@name = 'Пароль']"));
    private SelenideElement loginButton = $(byText("Войти"));

    public void waitForLoadLoginPage() {
        $(byClassName("App_componentContainer__2JC2W")).shouldBe(visible);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void sendTheLoginForm(String email, String password) {
        emailField.setValue(email);
        passField.setValue(password);
        loginButton.click();
    }

    public RegisterPage goToTheRegisterPage(){
        clickSignUpButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.waitForLoadRegisterPage();
        return registerPage;
    }

    public OrderConstructorPage goToOrderConstructorPage(){
        OrderConstructorPage orderConstructorPage = page(OrderConstructorPage.class);
        orderConstructorPage.waitConstructorPageLoad();
        return orderConstructorPage;
    }


}

