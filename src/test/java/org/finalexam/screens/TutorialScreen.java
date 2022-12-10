package org.finalexam.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.finalexam.configuration.mobile.MobileDriverManager;

/**
 * Object of the first screen that appears when we open the application.
 *
 * @author Jordan.González
 */
public class TutorialScreen extends MobileDriverManager {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Jordan.González
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Get Started\").resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/permission_primary_btn\")")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\").resourceIdMatches(\".*button1\")")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.packageinstaller:id/permission_allow_button\")")
    private AndroidElement allowButton;

    /**
     * @author Jordan.González
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * @author Jordan.González
     * Share Location permissions process.
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }
}
