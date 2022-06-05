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

    public void waitForUserProfileToLoad(){
        $(byClassName("App_componentContainer__2JC2W")).shouldBe(visible);
    }
    public void logout(){
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
        orderConstructorPage.waitConstructorPageLoad();
        return orderConstructorPage;
    }
}
