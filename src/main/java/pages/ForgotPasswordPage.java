package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    private final SelenideElement loginButton = $(byText("Войти"));

    public LoginPage goToTheLoginPage(){
        loginButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.assertThatLoginPageIsLoaded();
        return loginPage;
    }
}
