package org.finalexam.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.finalexam.configuration.mobile.MobileDriverManager;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Map screen.
 *
 * @author Jordan.González
 */
public class MapScreen extends MobileDriverManager {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Jordan.González
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Hotels, Category, 10of11, button\")")
    private AndroidElement hotelOption;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    /**
     * @author Jordan.González
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * @author Jordan.González
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * @author Jordan.González
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * @author Jordan. González
     * return true if Show Hotel Option element is displayed in screen, otherwise false.
     */
    public boolean hotelOptionIsDisplayed(){
        click(categoryList);
        return isElementAvailable(hotelOption);
    }

}
