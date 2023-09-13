import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class Hover {
    @BeforeAll
    static void before() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void hover() {
        open("");
        /*$("header").$$("ul li").findBy(text("Solutions")).hover()
                .$$("[class='HeaderMenu-dropdown dropdown-menu rounded m-0 p-0 py-2 py-lg-4 " +
                        "position-relative position-lg-absolute left-0 left-lg-n3 px-lg-4'] li")
                .findBy(text("Enterprise")).click();
         */
        $("header").$(byTagAndText("button", "Solutions")).hover();
        $("header").$(byTagAndText("a", "Enterprise")).click();
        $("main.font-mktg").shouldHave(text("Build like the best"));



        sleep(5000);
    }
}
