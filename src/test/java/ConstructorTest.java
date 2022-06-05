import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Test;
import pages.OrderConstructorPage;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    @After
    public void closeWindow() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Switching between Buns, Sauces and Fillings Test")
    public void SectionSwitchingTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        orderConstructorPage.switchToSauces();
        orderConstructorPage.switchToFillings();
        orderConstructorPage.switchToBuns();
    }
}
