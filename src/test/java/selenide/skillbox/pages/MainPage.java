package selenide.skillbox.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import utils.ConfigProperties;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public MainPage open() {
        Selenide.open(ConfigProperties.getProperty("url"));
        return this;
    }

    public void sendUsername(String username) {
        $(By.cssSelector("input"))
                .sendKeys(username);
        $(By.cssSelector("button")).click();
        $(By.cssSelector(".start-screen__res"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Привет, " + username + "!"));
    }
}
