package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $$("ul.repo-list li").first().$("a").click();
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));



        //.classname, #id, [attribute]
        // a[href=abc].red - все должо одновременно выполняться - тэг a,у него должен быть атрибут abc
        // и должен быть класс со значением red

        // ARRANGE
        // ACT
        // ASSERT

    }
}
