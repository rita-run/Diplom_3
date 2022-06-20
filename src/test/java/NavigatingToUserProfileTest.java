import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToUserProfileTest {
    @Before
    public void init() {
        Configuration.startMaximized = true;
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
    @DisplayName("Navigating to the User Profile page test")
    public void navigatingToUserProfileTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        OrderConstructorPage newConstructorPage = loginPage.goToOrderConstructorPage();
        newConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.assertThatProfilePageIsLoaded();
    }
}
