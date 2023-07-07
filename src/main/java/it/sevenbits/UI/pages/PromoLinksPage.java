package it.sevenbits.UI.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;

import static com.codeborne.selenide.Selenide.*;
import static it.sevenbits.TestSettings.*;

public class PromoLinksPage {
    private static final SelenideElement titleOfPage = $(byCssSelector("h2.header__title"));
    private static final SelenideElement addForm = $(byCssSelector(".add-form"));
    private static final SelenideElement addPromoLinkButton = addForm.$(byCssSelector(".add-form__button"));
    private static final SelenideElement addPromoLinkLabel = addForm.$(byCssSelector(".add-form__input label"));
    private static final SelenideElement firstPromoLinkButton = $(byCssSelector(".row_text-wrapper"));
    private static final SelenideElement firstPromoLinkDomain = $(byCssSelector(".row_text-wrapper span"));
    public static String getTitleOfPage(){
        return titleOfPage.innerText();
    }

    public static void clickFirstPromoLinkButton() {
        firstPromoLinkButton.click();
    }

    public static void start() {
        open(STAGING_SIGNIN_URL);
    }

    public static void finish() {
        closeWindow();
    }

    public static SelenideElement getAddPromoLinkButton(){
        return addPromoLinkButton;
    }

    public static String getAddPromoLinkLableText() {
        return addPromoLinkLabel.innerText();
    }
}
