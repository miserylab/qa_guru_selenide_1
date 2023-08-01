package com.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void DragAndDropWithSelenideActionsTest() {

        open("/drag_and_drop");
        // не работает
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
//        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(10,0).release().perform();
    }

    @Test
    void DragAndDropWithSelenideDragAndDropCommandTest() {

        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
