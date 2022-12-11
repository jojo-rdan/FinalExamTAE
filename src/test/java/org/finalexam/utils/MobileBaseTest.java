package org.finalexam.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.finalexam.screens.*;
import org.finalexam.utils.capabilities.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBaseTest {
    TutorialScreen tutorialScreen;
    DashBoardScreen dashBoardScreen;
    MapScreen mapScreen;
    MenuScreen menuScreen;
    PrivacyAndLegalScreen privacyAndLegalScreen;

    public static AndroidDriver<AndroidElement> driver;

    public void setUpStartApp() {
        tutorialScreen = new TutorialScreen(getDriver());
    }

    /**
     * SetUp before to run suite of test.
     *
     * @author Jordan.Gonzalez
     */
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }

    /**
     * Close the application after completing the test.
     *
     * @author Jordan.Gonzalez
     */
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * return the driver.
     *
     * @return driver
     * @author Jordan.Gonzalez
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     *
     * @return SignUpOrLogInScreen
     * @author Jordan.Gonzalez
     */
    public DashBoardScreen loadDashBoardScreen() {
        tutorialScreen.startPermissionsProcess();
        return tutorialScreen.shareLocationPermissions();
    }

    public void goToMapScreenProcess() {
        dashBoardScreen.goToMapScreen();
    }
    public void mapScreenValidator() {
        Assert.assertTrue(mapScreen.hotelOptionIsDisplayed(), "Option not displayed");
        Assert.assertTrue(mapScreen.showListIsDisplayed(), "Show List not displayed");
        Assert.assertTrue(mapScreen.categoryIsDisplayed(), "Category not displayed");
        Assert.assertTrue(mapScreen.filterIsDisplayed(), "Filter not displayed");
    }
    public void goToMenuScreen() {
        dashBoardScreen.goToMenuScreen();
    }
    public void goToPrivacyAndLegal() {
        menuScreen.goToPrivacyAndLegalScreen();
    }
    public void privacyAndLegalValidations() {
        Assert.assertTrue(privacyAndLegalScreen.isPrivacyAndLegalScreenDisplayed(), "Screen not displayed");
        Assert.assertTrue(privacyAndLegalScreen.screenHaveSixOrMoreOptionsDisplayed(), "No options displayed");
    }
    public void addPlansValidator() {
        dashBoardScreen.isDiningAvailabilityOptionDisplayed();
    }
}
