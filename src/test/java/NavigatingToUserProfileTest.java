import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.OrderConstructorPage;
import pages.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class NavigatingToUserProfileTest {
    @After
    public void closeWindow() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Navigating to the User Profile page test")
    public void navigatingToUserProfileTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        orderConstructorPage.clickLoginButton();
        LoginPage loginPage = orderConstructorPage.goToTheLoginPage();
        loginPage.waitForLoadLoginPage();
        loginPage.sendTheLoginForm("harry1@mail.ru", "password");
        orderConstructorPage.waitConstructorPageLoad();
        UserProfilePage userProfilePage = orderConstructorPage.goToTheUserProfilePage();
        userProfilePage.waitForUserProfileToLoad();
    }
}
