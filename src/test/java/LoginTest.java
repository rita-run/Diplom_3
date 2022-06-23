import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

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
    @DisplayName("Login after navigating to the Login page from the Order Constructor page via login button test")
    public void loginViaLoginButtonTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.assertThatConstructorPageIsLoaded();
    }

    @Test
    @DisplayName("Login after navigating to the Login page from the Order Constructor page via profile button test")
    public void loginViaProfileButtonTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.clickUserProfileButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.assertThatConstructorPageIsLoaded();
    }

}
