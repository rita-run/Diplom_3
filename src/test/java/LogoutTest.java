import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTest extends BaseTest {
    OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);

    @Test
    @DisplayName("Logout test")
    public void logoutTest() {
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.assertThatConstructorPageIsLoaded();
        orderConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.clickLogoutButton();
        loginPage.assertThatLoginPageIsLoaded();
    }
}
