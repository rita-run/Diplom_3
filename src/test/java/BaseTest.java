import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class BaseTest {
    @BeforeClass
    public static void browserSetUp() {
        String browserNumber = System.getProperty("browserNumber");
        if (browserNumber != null && browserNumber.equals("browser_1")) {
            ChromeOptions options = new ChromeOptions();
            File file = new File("src/test/resources/yandexdriver");
            ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(file).build();
            ChromeDriver yandex = new ChromeDriver(service, options);
            WebDriverRunner.setWebDriver(yandex);
        } else {
            Configuration.browser = "chrome";
        }
        Configuration.startMaximized = true;
    }

    @AfterClass
    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}
