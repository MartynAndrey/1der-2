package it.sevenbits.UI;

import com.google.common.collect.ImmutableSet;
import it.sevenbits.UI.pages.PromoLinksPage;
import it.sevenbits.UI.pages.SignInPage;
import it.sevenbits.UI.pages.Tutorial;
import it.sevenbits.UI.pages.TargetLinksPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;
import static it.sevenbits.TestSettings.EN_LOCALE;

public class TargetLinksPageTest {
    public String companyName = "testador";
    public String promoLinkUrl = "https://testador.1derlink.7bits.it/";
    public String promoLinkDomain = "https://testador.1derlink.7bits.it";
    public String promoLinkPath = "/";


    @BeforeClass
    public void init(){
        Configurator.setupChrome("1920x1080", EN_LOCALE);

        SignInPage.start();

        SignInPage.setEmail("heytest1@rambler.ru");
        SignInPage.setPassword("Ppp1234#");
        SignInPage.clickSignInButton();

        Tutorial.clickDontShowAgainCheckbox();
        Tutorial.clickIntroSkipButton();
    }

    @BeforeMethod
    public void startPage(){
        PromoLinksPage.start();
        PromoLinksPage.clickFirstPromoLinkButton();}

    @AfterMethod
    public void finishPage() {
        PromoLinksPage.finish();
    }

    @Test
    public void testLoadTargetLinksPage() {
        String expected = "Add new target";
        String actual = TargetLinksPage.getAddTargetLinkLabelText();
        assertEquals(actual,expected);
    }

    @Test
    public void testTitleTargetLinksPage() {
        String expected = companyName;
        String actual = TargetLinksPage.getTitleOfPage();
        assertEquals(actual,expected);
    }

    @Test
    public void testReturnOPromoLinksPage() {
        TargetLinksPage.clickBackToPromoLinkButton();
        String expected = "Create a new promotional link";
        String actual = PromoLinksPage.getAddPromoLinkLableText();
        assertEquals(actual,expected);
    }

    @Test
    public void testAddTargetLinkButtonEnabled() {
        assertTrue(TargetLinksPage.isAddTArgetLinkButtonEnabled());
    }

    @Test
    public void testAddTargetLinkLabel() {
        String expected = "Add new target";
        String actual = TargetLinksPage.getAddTargetLinkLabelText();
        assertEquals(actual, expected);
    }

    @Test
    public void testAddTargetLinkErrorEnabled() {
        assertTrue(!TargetLinksPage.isAddTargetLinkLabelHaveError());
    }

    @Test
    public void testTargetLinksTableHeader() {
        String expected = "Targets for " + promoLinkPath;
        String actual = TargetLinksPage.getTargetLinksTableHeader();
        assertEquals(actual, expected);
    }

    @Test
    public void testTurnOnAllTargetLinks() {
        for (int i = 0; i < TargetLinksPage.getTargetsCount(); i++) {
            if (!TargetLinksPage.getTargetItemToggleSwitchPosition(i))
                TargetLinksPage.clickTargetItemToggle(i);
        }

        int switchOnCount = 0;
        for (int i = 0; i < TargetLinksPage.getTargetsCount(); i++) {
            if (TargetLinksPage.getTargetItemToggleSwitchPosition(i))
                switchOnCount++;
        }

        int[] expected = {0, 1};
        boolean d = Arrays.asList(expected).contains(switchOnCount);

        assertTrue(Arrays.asList(expected).contains(switchOnCount));
    }
}
