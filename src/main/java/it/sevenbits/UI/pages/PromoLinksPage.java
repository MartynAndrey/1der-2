package it.sevenbits.UI.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static it.sevenbits.TestSettings.*;

public class PromoLinksPage {
    private static final SelenideElement introSkipButton = $(byCssSelector(".introjs-skipbutton"));

    public static void load() {
        open(STAGING_URL);
    }

    public static void clickIntroSkipButton(){
        introSkipButton.click();
    }
}
