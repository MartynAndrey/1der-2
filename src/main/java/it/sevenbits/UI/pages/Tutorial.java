package it.sevenbits.UI.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class Tutorial {
    private static final SelenideElement introSkipButton = $(byCssSelector(".introjs-skipbutton"));
    private static final SelenideElement dontShowAgainCheckbox = $(byCssSelector("input#introjs-dontShowAgain"));
    public static void clickIntroSkipButton(){
        introSkipButton.click();
    }
    public static void clickDontShowAgainCheckbox() {
        dontShowAgainCheckbox.click();
    }
}
