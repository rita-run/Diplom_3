import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.OrderConstructorPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Clicking on the Sauces folder should open the Sauces section test")
    public void switchingToSaucesTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.assertThatFolderSwitchedToSauces();
    }

    @Test
    @DisplayName("Clicking on the Fillings folder should open the Fillings section test")
    public void switchingToFillingsTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.assertThatFolderSwitchedToFillings();
    }

    @Test
    @DisplayName("Clicking on the Buns folder should open the Buns section test")
    public void switchingToBunsTest() {
        OrderConstructorPage orderConstructorPage = open("https://stellarburgers.nomoreparties.site/", OrderConstructorPage.class);
        orderConstructorPage.assertThatFolderSwitchedToBuns();
    }
}
