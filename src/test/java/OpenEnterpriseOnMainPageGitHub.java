import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterpriseOnMainPageGitHub {

    @Test
    void openEnterprise() {
        open("https://github.com/");
        $("header.Header-old.header-logged-out").$(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(exactTextCaseSensitive("The AI-powered developer platform."));

    }

}
