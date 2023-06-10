package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {

    @Test
    void andreiSolncevShouldBeTheFirstContributor() {
        Configuration.browserSize = "1920x1080";

        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока Contributors
        $("div.Layout-sidebar").$(byText("Contibutors"))
//        $("div.Layout-sidebar").$(byText("Contibutors")).scrollIntoView(true);
                //.closest(".BorderGrid-cell").$$("ul li").first().hover();
                .closest("h2").sibling(0).$$("li").first().hover();

        // проверка: во всплывающем окне есть текст Andrei Solncev
        sleep(5000);


    }

}
