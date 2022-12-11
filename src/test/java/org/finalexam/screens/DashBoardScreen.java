package org.finalexam.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.finalexam.configuration.mobile.MobileDriverManager;

import java.time.Duration;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * DashBoard screen.
 *
 * @author Jordan.González
 */
public class DashBoardScreen extends MobileDriverManager {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Jordan.González
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Map, Tab, 2of5\")")
    private AndroidElement mapButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"More Options, Tab, 5of5\")")
    private AndroidElement menuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Buy tickets, Reserve Dining, Tab, 3of5\")")
    private AndroidElement addPlansButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Check Dining Availability, 1 of 7, button\")")
    private AndroidElement checkDiningAvailabilityButton;

    /**
     * @author Jordan.González
     * Navigate to Map Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(mapButton);
        return new MapScreen(driver);
    }

    /**
     * @author Jordan.González
     * Navigate to Menu Screen from DashBoard Screen.
     */
    public MenuScreen goToMenuScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(menuButton);
        return new MenuScreen(driver);
    }

    /**
     * @author Jordan.González
     * Validate if dining availability is displayed.
     */
    public boolean isDiningAvailabilityOptionDisplayed(){
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(addPlansButton);
        return isElementAvailable(checkDiningAvailabilityButton);
    }
}
