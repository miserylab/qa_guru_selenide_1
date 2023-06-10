package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitSearch {

    @Test
    void jUnitExampleShouldBeInSoftAssertions() {
        Configuration.browserSize = "1920x1080";

        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box").$("[type='button']").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-pages-box").$("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));

    }
}
