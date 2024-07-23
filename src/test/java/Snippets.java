import com.codeborne.selenide.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import javax.annotation.Nonnull;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_common_examples() {

        open("https://google.com"); //абсолютный URL
        open("customer/orders"); //гибкий запуск теста в различных средах, BaseURL указывается в коде отдельно
        open("/", AuthenticationType.BASIC, new BasicAuthCredentials("","user","password"));

        Selenide.back(); //стрелочки "вперед/назад"
        Selenide.refresh(); //кнопка "обновить"

        Selenide.clearBrowserCookies();//очистка кэша
        Selenide.clearBrowserLocalStorage();//очистка хранилища
        executeJavaScript("sessionStorage.clear;");//очистка данных текущей сессии

        Selenide.confirm();//ОК в диалоговом окне предупреждения
        Selenide.dismiss();//Cancel в диалоговом окне предупреждения

        Selenide.closeWindow();
        Selenide.closeWebDriver();

        Selenide.switchTo().frame("new"); //переход по фреймам, выполняется после Selenide.switchTo().defaultContent();
        Selenide.switchTo().defaultContent(); //возврат из текущего фрейма для перехода в другой или для выхода в основной DOM

        Selenide.switchTo().window("The Internet");

        var cookie = new Cookie("foo","bar");//установить cookie
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

    }


    void selectors_examples() {

        $("div").click();
        element("div").click();

        $("div",2).click(); //3-й div

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull tex")).click();

        $(byTagAndText("div","full text")).click();
        $(withTagAndText("div","ull text")).click();

        $("").parent(); //родительский элемент
        $("").sibling(1);//брат-сестра вниз по дереву
        $("").preceding(1);//брат-сестра вверх по дереву
        $("").closest("div");
        $("").ancestor("div"); //предок, то же самое, что и closest
        $("div:last-child");// последний ребенок, псевдокласс
        //$("div:visible");// все видимые div

        $("div").$("h1").find(byText("abc")).click();
        $(byAttribute("abc","x")).click();
        $("[abc=x]").click();

        $(byId("my text")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();

    }

    void actions_examples() {

        $("").click();
        $("").doubleClick();
        $("").contextClick();//клик правой кнопкой мышки

        $("").hover();//подвести мышку к элементу, но не нажимать на элемент

        $("").setValue("text");//запись текста в поле ввода текста
        $("").append("text");//добавление текста в поле ввода текста, к уже существующему тексту, в конец
        $("").clear();
        $("").setValue(""); //clear

        $("").sendKeys("c");// горячая клавиша С на элементе
        actions().sendKeys("c").perform();// горячая клавиша С в приложении
        actions().sendKeys(Keys.chord(Keys.CONTROL,"f"));// CTRL+f
        $("html").sendKeys(Keys.chord(Keys.CONTROL,"f"));//доступ через корневой элемент html, если actions не работает
        $("").sendKeys(" ");// нажать пробел "пробел"
        $("").sendKeys(Keys.SPACE);

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        //действия с клавиатурой или мышкой
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300,200).release().perform();//нажать и удерживать кнопку мышки, передвинуть на 300 вправо и на 200 вниз, отпустить кнопку мышки, выполнить все действия

        //устаревшие опции часто не работают в современных фрейворках
        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_ortion");

    }

    void assertions_examples() {

        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);

        $("").shouldBe(visible, Duration.ofSeconds(30));//длинные таймауты

    }

    void conditions_examples() {

        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));//наличие больших букв
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[8-9]abc$"));//соответствует ли формат чего-либо определенным правилам

        $("").shouldHave(cssClass("red"));//содержится ли в элементе класс "red"
        $("").shouldHave(cssValue("font-size","12"));//размеры и стиль текста
        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name","example"));
        $("").shouldHave(attributeMatching("name","[8-9]abc$"));

        $("").shouldBe(checked);//для чекбоксов

        $("").should(exist);//только для проверок в DOM

        //только для отключаемых аттрибутов. Не работает с современными фреймворками
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);


    }

    void collections_examples() {

        $$("div");
        $$x("//div")

        //выбор
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        elements("div").first().click();
        //$("div").click();
        $$("div").last().click();
        $$("div").get(1).click();
        $("div",1).click();
        $$("div").findBy(text("123")).click();

        //ассерты
        $$("div").shouldHave(size(8));
        $$("div").shouldBe(CollectionCondition.empty);


    }

    void file_operations_examples() throws FileNotFoundException {}

    void javascript_examples() {}

}
