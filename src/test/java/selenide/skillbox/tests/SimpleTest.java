package selenide.skillbox.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import selenide.skillbox.pages.MainPage;
import utils.ConfigProperties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class SimpleTest {
    MainPage mainPage = new MainPage();

    @BeforeEach
    public void setup() {
        Configuration.browser = ConfigProperties.getProperty("browser");
        Configuration.baseUrl = ConfigProperties.getProperty("url");
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void endSession() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        clearBrowserCache();
    }

    @Test
    public void checkUsername() {
        mainPage
                .open()
                .sendUsername(ConfigProperties.getProperty("username"));
    }
}
