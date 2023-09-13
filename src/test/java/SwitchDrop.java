import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SwitchDrop {
    @BeforeAll
    static void before() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void dropSwitch() {
        open("");
        $("#content").$$("ul li").findBy(text("Drag and Drop")).$("a").click();
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        sleep(1000);

    }
}
