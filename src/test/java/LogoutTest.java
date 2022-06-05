import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTest {
    @After
    public void closeWindow() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Logout test")
    public void logoutTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.waitConstructorPageLoad();
        orderConstructorPage.clickUserProfileButton();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.logout();
        loginPage.waitForLoadLoginPage();
    }
}
