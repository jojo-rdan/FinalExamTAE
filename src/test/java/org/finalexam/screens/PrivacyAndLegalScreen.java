package org.finalexam.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.finalexam.configuration.mobile.MobileDriverManager;

/**
 * Privacy And Legal screen.
 *
 * @author Jordan.González
 */
public class PrivacyAndLegalScreen extends MobileDriverManager {

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Jordan.González
     */
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/snowball_header_screen_name\")")
    private AndroidElement privacyAndLegalText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/privacy_and_legal_elements\")")
    private AndroidElement optionsList;

    /**
     * @author Jordan.González
     * Validate if Privacy And Legal Screen is displayed.
     */
    public boolean isPrivacyAndLegalScreenDisplayed(){
        return isElementAvailable(privacyAndLegalText);
    }

    /**
     * @author Jordan.González
     * Validate if the screen have six o more options displayed.
     */
    public boolean screenHaveSixOrMoreOptionsDisplayed(){
        return isElementAvailable(optionsList);
    }
}
