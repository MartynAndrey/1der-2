package it.sevenbits.UI;

import it.sevenbits.ExcelDataProviders;
import it.sevenbits.UI.pages.ForgotPasswordPage;
import it.sevenbits.UI.pages.PromoLinksPage;
import it.sevenbits.UI.pages.SignInPage;
import it.sevenbits.UI.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static it.sevenbits.TestSettings.*;
import static com.codeborne.selenide.Condition.visible;

public class SignInPageTest {

    @BeforeClass
    public void init(){
        Configurator.setupChrome("1920x1080", EN_LOCALE);
    }

    @Test
    public void testLoadSignInPage() {
        SignInPage.load();
        String expected = "Sign in";
        String actual = SignInPage.getTitleOfPage();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testLoadSignUpPage() {
        SignInPage.load();
        SignInPage.clickOnSignUpLink();
        String expected = "Sign up";
        String actual = SignUpPage.getTitleOfPage();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testLoadForgotPasswordPage() {
        SignInPage.load();
        SignInPage.clickOnForgotPasswordLink();

        String expected = "Password recovery";
        String actual = ForgotPasswordPage.getTitleOfPage();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCheckVisiblePassword() {
        SignInPage.load();
        SignInPage.setPassword("12password34");
        SignInPage.clickOnPasswordToggleButton();

        Assert.assertTrue(SignInPage.isPasswordVisible());
    }

    @Test
    public void testCheckInvisiblePassword() {
        SignInPage.load();
        SignInPage.setPassword("12password34");
        SignInPage.clickOnPasswordToggleButton();
        SignInPage.clickOnPasswordToggleButton();

        Assert.assertTrue(!SignInPage.isPasswordVisible());
    }

    @Ignore
    @Test
    public void testCorrectEmailPassSignIn() {
        SignInPage.load();
        SignInPage.setEmail("heytest1@rambler.ru");
        SignInPage.setPassword("Ppp1234#");
        SignInPage.clickSignInButton();
        PromoLinksPage.getAddButton().shouldBe(visible);
    }

    /*
    @Test (dataProvider = "incorrectEmailPass", dataProviderClass = ExcelDataProviders.class)
    public void testIncorrectEmailPassSignIn(String email, String password) {
        SignInPage.load();
        SignInPage.setEmail(email);
        SignInPage.setPassword(password);
        SignInPage.clickSignInButton();
        SignInPage.getError().shouldBe(visible);
    }

     */

    @DataProvider(name = "incorrectEmailPass")
    public static Object[][] emailPass() {
        return new Object[][] {
                {"", "pass"},
                {"a", "pass"},
                {"abcde", "pass"},
                {"bob@gmail,com", "pass"},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@example.com", "pass"},
                {"alice@mail.com", "password"},
                {"alice@mail.com", "verylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordverylongpasswordvery"},
                {"alice@mail.com", ""}

        };
    }

    @Test (dataProvider = "incorrectEmailPass")
    public void testIncorrectEmailPassSignIn(String email, String password) {
        SignInPage.load();
        SignInPage.setEmail(email);
        SignInPage.setPassword(password);
        SignInPage.clickSignInButton();
        SignInPage.getError().shouldBe(visible);
    }

}
