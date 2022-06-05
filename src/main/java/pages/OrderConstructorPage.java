package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OrderConstructorPage {
    private SelenideElement loginButton = $(byText("Войти в аккаунт"));
    private SelenideElement bunsFolder = $$(byText("Булки")).get(0);
    private SelenideElement saucesFolder = $$(byText("Соусы")).get(0);
    private SelenideElement fillingsFolder = $$(byText("Начинки")).get(0);
    private SelenideElement userProfileButton = $(byText("Личный Кабинет"));


    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickUserProfileButton() {
        userProfileButton.click();
    }
    public void waitConstructorPageLoad(){
        $(byClassName("App_componentContainer__2JC2W")).shouldBe(visible);
    }

    public void switchToSauces(){
        saucesFolder.click();
        $$(byText("Соусы")).get(1).shouldBe(visible);
    }

    public void switchToFillings(){
        fillingsFolder.click();
        $$(byText("Начинки")).get(1).shouldBe(visible);
    }

    public void switchToBuns(){
        bunsFolder.click();
        $$(byText("Булки")).get(1).shouldBe(visible);
    }

    public UserProfilePage goToTheUserProfilePage() {
        UserProfilePage userProfilePage = page(UserProfilePage.class);
        userProfilePage.waitForUserProfileToLoad();
        return userProfilePage;
    }

    public LoginPage goToTheLoginPage(){
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }
}


