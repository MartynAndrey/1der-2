package it.sevenbits.UI;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static it.sevenbits.TestSettings.*;

public final class Configurator {

    private static void setUpURL(final String size) {
        Configuration.baseUrl = STAGING_URL;
        Configuration.browserSize = size;
    }

    public static void setupChrome(final String size, final String locale) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--accept-lang=" + locale);
        Configuration.browserCapabilities = options;

        setUpURL(size);
        Configuration.browser = "chrome";
    }

    public static void setupFirefox(final String size, final String locale) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", locale);
        FirefoxOptions options = new FirefoxOptions()
                .setProfile(profile);
        Configuration.browserCapabilities = options;

        setUpURL(size);
        Configuration.browser = "firefox";
    }

    public static void setupSafari(final String size) {
        setUpURL(size);
        Configuration.browser = "safari";
    }
}
