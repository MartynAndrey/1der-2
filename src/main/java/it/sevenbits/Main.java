package it.sevenbits;

import it.sevenbits.UI.Configurator;
import it.sevenbits.UI.pages.PromoLinksPage;
import it.sevenbits.UI.pages.SignInPage;
import it.sevenbits.UI.pages.TargetLinksPage;
import it.sevenbits.UI.pages.Tutorial;

import static it.sevenbits.TestSettings.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Configurator.setupChrome("1920x1080", EN_LOCALE);
        SignInPage.start();

        SignInPage.setEmail("heytest1@rambler.ru");
        SignInPage.setPassword("Ppp1234#");
        SignInPage.clickSignInButton();

        Tutorial.clickDontShowAgainCheckbox();
        Tutorial.clickIntroSkipButton();
        PromoLinksPage.clickFirstPromoLinkButton();

        //PromoLinksPage.clickIntroSkipButton();
        TargetLinksPage.clickBackToPromoLinkButton();

        PromoLinksPage.clickFirstPromoLinkButton();

        String s1 = TargetLinksPage.getTitleOfPage();
        TargetLinksPage.clickAddTargetLinkButton();
        boolean b1 = TargetLinksPage.isAddTargetLinkLabelHaveError();
        String s2 = TargetLinksPage.getErrorMessage();
        String s3 = TargetLinksPage.getAddTargetLinkLabelText();
        TargetLinksPage.setTargetLink("asfdasf");
        TargetLinksPage.clickAddTargetLinkButton();
        boolean b2 = TargetLinksPage.isAddTargetLinkLabelHaveError();
        String s4 = TargetLinksPage.getAddTargetLinkLabelText();
        String s5 = TargetLinksPage.getErrorMessage();
        String s6 = TargetLinksPage.getPromoLinkFromTargetLinksTableHeader();
        int i1 = TargetLinksPage.getTargetsCount();
        String s7 = TargetLinksPage.getTargetItemLink(0);
        String s8 = TargetLinksPage.getTargetItemLink(1);
        boolean b3 = TargetLinksPage.isTargetSwitchOn();
        boolean b4 = TargetLinksPage.getTargetItemToggleSwitchPosition(0);
        boolean b5 = TargetLinksPage.getTargetItemToggleSwitchPosition(1);
        TargetLinksPage.clickTargetItemToggle(0);
        TargetLinksPage.clickTargetItemToggle(1);
        TargetLinksPage.clickTargetItemToggle(0);
        TargetLinksPage.clickTargetItemToggle(1);
        TargetLinksPage.clickTargetItemToggle(1);
        TargetLinksPage.clickTargetItemToggle(0);
        TargetLinksPage.clickTargetItemToggle(1);
        TargetLinksPage.clickTargetItemToggle(0);
    }
}