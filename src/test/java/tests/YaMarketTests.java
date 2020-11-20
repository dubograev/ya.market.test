package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YaMarketTests {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    void searchForPhilipsAutoCoffee() {
        open("https://market.yandex.ru/");

        $("#pokupki").click();
        $("#pokupki").$(byText("Покупка на Маркете")).click();
        $("#header-search").val("philips").pressEnter();
        $("#pokupki").parent().shouldHave(text("Покупки"));
        $("[type=search]").shouldHave(value("philips"));

        $$("[data-auto=intent-link]").findBy(text("Бытовая техника")).click();
        $$("[data-auto=intent-link]").findBy(text("Мелкая техника для кухни")).click();
        $$("[data-auto=intent-link]").findBy(text("Кухонные приборы для приготовления напитков")).click();
        $$("[data-auto=intent-link]").findBy(text("Кофеварки и кофемашины")).click();
        $("[data-apiary-widget-name='@marketplace/SearchBreadcrumbs']").shouldHave(text("Кофеварки и кофемашины"));
    }
}
