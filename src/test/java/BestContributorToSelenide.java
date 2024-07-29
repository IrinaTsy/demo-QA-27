import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {

    @Test

    void andreySolntsev(){

        //запустить тест в броузере firefox
        //Configuration.browser = "firefox";

        //открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");

        //подвести мышку к первому аватару из блока Contributors
        $("div.layout-sidebar").$(Selectors.byText("Contributors"))
                //.closest(".BorderGrid-sell").$$("ul li").first().hover()
                .closest("h2").sibling(0).$$("li").first().hover();
        //проверка: во всплывающем окне есть текст Andrey Solntsev
        $$(".Popover-message").findBy(Condition.visible).shouldHave(text("Andrei Solntsev"));

    }
}
