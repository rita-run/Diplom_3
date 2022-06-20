import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToConstructorTest {
    UserProfilePage userProfilePage;

    @Before
    public void init() {
        Configuration.startMaximized = true;
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage orderConstructorPage = loginPage.goToOrderConstructorPage();
        orderConstructorPage.clickUserProfileButton();
        userProfilePage = orderConstructorPage.goToTheUserProfilePage();
    }

    @After
    public void logout() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.clickLogoutButton();
        LoginPage loginPage = userProfilePage.goToTheLoginPage();
        loginPage.clickConstructorButton();
        loginPage.goToOrderConstructorPage();
    }

    @Test
    @DisplayName("Navigating to Constructor page using constructor button test")
    public void navigatingToConstructorUsingConstructorButton() {
        userProfilePage.clickConstructorButton();
        OrderConstructorPage orderConstructorPage = userProfilePage.goToConstructorPage();
        orderConstructorPage.assertThatConstructorPageIsLoaded();
    }

    @Test
    @DisplayName("Navigating to Constructor page using logo button test")
    public void navigatingToConstructorUsingLogo() {
        userProfilePage.clickStellarBurgersLogo();
        OrderConstructorPage orderConstructorPage = userProfilePage.goToConstructorPage();
        orderConstructorPage.assertThatConstructorPageIsLoaded();
    }
}
