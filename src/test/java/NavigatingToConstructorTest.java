import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToConstructorTest {
    @After
    public void closeWindow() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Navigating to Constructor page using constructor button test")
    public void navigatingToConstructorUsingConstructorButton() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.waitConstructorPageLoad();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.clickConstructorButton();
        userProfilePage.goToConstructorPage();
        orderConstructorPage.waitConstructorPageLoad();
    }

    @Test
    @DisplayName("Navigating to Constructor page using logo button test")
    public void navigatingToConstructorUsingLogo() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.waitConstructorPageLoad();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.clickStellarBurgersLogo();
        userProfilePage.goToConstructorPage();
        orderConstructorPage.waitConstructorPageLoad();
    }
}
