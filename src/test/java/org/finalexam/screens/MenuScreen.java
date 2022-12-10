package org.finalexam.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.finalexam.configuration.mobile.MobileDriverManager;

import java.time.Duration;

/**
 * Menu screen.
 *
 * @author Jordan.González
 */
public class MenuScreen extends MobileDriverManager {

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Jordan.González
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\"Privacy & Legal button\"));")
    private AndroidElement privacyAndLegalElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Privacy & Legal button\")")
    private AndroidElement privacyAndLegalButton;

    /**
     * @author Jordan.González
     * Navigate to Privacy And Legal Screen from DashBoard Screen.
     */
    public PrivacyAndLegalScreen goToPrivacyAndLegalScreen() {
        isElementAvailable(privacyAndLegalElement, Duration.ofSeconds(10));
        click(privacyAndLegalButton);
        return new PrivacyAndLegalScreen(driver);
    }
}
