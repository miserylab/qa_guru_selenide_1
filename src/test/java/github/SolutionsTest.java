package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void EnterprisePageShouldHaveHeader() {
        Configuration.browserSize = "1920x1080";

        // Откройте главную страницу в Github
        open("/");
        // Команда hover для Solutions.
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        // Нажатие пункта Enterprise в выпадающем меню Solutions
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        // Проверка загрузки нужной страницы
        $("div.enterprise-hero h1").shouldHave(text("Build like the best"));
    }
}
