package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class OrderConstructorPage {
    private SelenideElement loginButton = $(byText("Войти в аккаунт"));
    private SelenideElement bunsFolder = $(byXpath("//div[span[text()=\"Булки\"]]"));
    private SelenideElement saucesFolder = $(byXpath("//div[span[text()=\"Соусы\"]]"));
    private SelenideElement fillingsFolder = $(byXpath("//div[span[text()=\"Начинки\"]]"));
    private SelenideElement userProfileButton = $(byText("Личный Кабинет"));


    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickUserProfileButton() {
        userProfileButton.click();
    }

    public void assertThatConstructorPageIsLoaded() {
        $(byText("Соберите бургер")).shouldBe(visible);
    }

    public void assertThatFolderSwitchedToSauces() {
        saucesFolder.click();
        $(byXpath("//div[span[text()=\"Соусы\"]]")).should(cssClass("tab_tab_type_current__2BEPc"));
    }

    public void assertThatFolderSwitchedToFillings() {
        fillingsFolder.click();
        $(byXpath("//div[span[text()=\"Начинки\"]]")).should(cssClass("tab_tab_type_current__2BEPc"));
    }

    public void assertThatFolderSwitchedToBuns() {
        bunsFolder.click();
        $(byXpath("//div[span[text()=\"Булки\"]]")).should(cssClass("tab_tab_type_current__2BEPc"));
    }

    public UserProfilePage goToTheUserProfilePage() {
        UserProfilePage userProfilePage = page(UserProfilePage.class);
        userProfilePage.assertThatProfilePageIsLoaded();
        return userProfilePage;
    }

    public LoginPage goToTheLoginPage() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.assertThatLoginPageIsLoaded();
        return loginPage;
    }
}


