package it.sevenbits.UI.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Arrays;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import static it.sevenbits.TestSettings.*;

public class TargetLinksPage {
    private static final SelenideElement titleOfPage = $(byCssSelector("h2.header__title"));
    private static final SelenideElement addForm = $(byCssSelector(".add-form"));
    private static final SelenideElement addTargetLinkButton = addForm.$(byCssSelector(".add-form__button"));
    private static final SelenideElement addTargetLinkLabel = addForm.$(byCssSelector(".add-form__input label"));
    private static final SelenideElement addTargetLinkInput = addForm.$(byCssSelector(".add-form__input input"));
    private static final SelenideElement addTargetLinkError = addForm.$(byCssSelector(".add-form__input p.Mui-error"));
    private static final SelenideElement backToPromoLinkButton = $(byCssSelector(".target__table-header button"));
    private static final SelenideElement targetLinksTableHeader = $(byCssSelector(".target__table-header h3"));
    private static final ElementsCollection targetItems = $$(byCssSelector(".list-item-target"));

    public static String getTitleOfPage(){
        return titleOfPage.innerText();
    }

    public static void clickAddTargetLinkButton(){
        addTargetLinkButton.click();
    }

    public static String getAddTargetLinkLabel() {
        return addTargetLinkLabel.innerText();
    }

    public static Boolean isAddTargetLinkLabelHaveError(){
        String labelClassesString = addTargetLinkLabel.getAttribute("class");
        String[] labelClasses = labelClassesString.split(" ");
        return Arrays.asList(labelClasses).contains(ERROR_CLASS);
    }

    public static void setTargetLink(String targetLink){
        addTargetLinkInput.sendKeys(Keys.CONTROL + "a");
        addTargetLinkInput.sendKeys(Keys.BACK_SPACE);
        addTargetLinkInput.setValue(targetLink);
    }

    public static SelenideElement getError() {
        return addTargetLinkError;
    }

    public static String getErrorMessage() {
        return addTargetLinkError.innerText();
    }

    public static void clickBackToPromoLinkButton() {
        backToPromoLinkButton.click();
    }

    public static String getTargetLinksTableHeader() {
        return targetLinksTableHeader.innerText();
    }

    public static String getPromoLinkFromTargetLinksTableHeader() {
        int i = getTargetLinksTableHeader().indexOf("/");
        return getTargetLinksTableHeader().substring(i);
    }

    public static Integer getTargetsCount() {
        return targetItems.size();
    }

    public static SelenideElement getTargetItem(int index) {
        return targetItems.get(index);
    }

    public static String getTargetItemLink(int index) {
        return getTargetItem(index).$$(byCssSelector("div div")).get(1).innerText();
    }

    public static SelenideElement getTargetItemToggle(int index) {
        return getTargetItem(index).$(byCssSelector("button"));
    }

    public static void clickTargetItemToggle(int index) {
        getTargetItemToggle(index).click();
    }

    public static boolean getTargetItemToggleSwitchPosition(int index) {
        String toggleClassesString = getTargetItemToggle(index).$(byCssSelector("svg")).getAttribute("class");
        String[] toggleClasses = toggleClassesString.split(" ");
        return Arrays.asList(toggleClasses).contains(TOGGLE_SWITCH_ON);
    }
    
    public static boolean isTargetSwitchOn(){
        for (int i = 0; i < getTargetsCount(); i++) {
            if (getTargetItemToggleSwitchPosition(i))
                return true;
        }
        return false;
    }
}
