package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class UserProfilePage {
    private SelenideElement logoutButton = $(byText("Выход"));
    private SelenideElement constructorButton = $(byText("Конструктор"));
    private SelenideElement stellarBurgersLogo = $(byClassName("AppHeader_header__logo__2D0X2"));

    public void assertThatProfilePageIsLoaded(){
        $(byText("В этом разделе вы можете изменить свои персональные данные")).shouldBe(visible);
    }
    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }

    public OrderConstructorPage goToConstructorPage() {
        OrderConstructorPage orderConstructorPage = page(OrderConstructorPage.class);
        orderConstructorPage.assertThatConstructorPageIsLoaded();
        return orderConstructorPage;
    }

    public LoginPage goToTheLoginPage(){
        LoginPage loginPage = page(LoginPage.class);
        loginPage.assertThatLoginPageIsLoaded();
        return loginPage;
    }
}
