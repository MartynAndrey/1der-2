package it.sevenbits.UI;

import it.sevenbits.UI.pages.PromoLinksPage;
import it.sevenbits.UI.pages.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;

public class SignInPageTest {

    @BeforeClass
    public void init(){
        Configurator.setupChrome("1920x1080");
    }

    @Test
    public void userCanLoginWithCorrectEmailPass() {
        SignInPage.load();
        SignInPage.setEmail("heytest1@rambler.ru");
        SignInPage.setPassword("Ppp1234#");
        SignInPage.clickSignInButton();
        PromoLinksPage.getAddButton().shouldBe(visible);
    }
}
