package org.finalexam.pages;

import org.finalexam.utils.data.WebData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    WebData webData = new WebData();
    @FindBy (css = ".promo-banner-container iframe")
    private WebElement promoBanner;
    @FindBy (css = "div.PromoBanner__CloseBtn")
    private WebElement closeBanner;
    @FindBy(id= "global-user-trigger")
    private WebElement userIcon;
    @FindBy(id="Title")
    private WebElement signUpTitle;
    @FindBy(css = "#global-header > div.container > ul > li.user > div > div > ul.account-management > li:nth-child(7) > a")
    private WebElement logInOption;
    @FindBy(css = "#global-header > div.container > ul > li.user > div > div > ul.account-management > li:nth-child(5) > a")
    private WebElement ESPNProfile;
    @FindBy(id = "oneid-iframe")
    private WebElement iframe;
    @FindBy(id = "InputFirstName")
    private WebElement signUpFirstNameInput;
    @FindBy(id = "InputLastName")
    private WebElement signUpLastNameInput;
    @FindBy(id = "InputEmail")
    private WebElement signUpEmailInput;
    @FindBy(id = "password-new")
    private WebElement signUpPasswordInput;
    @FindBy(id = "BtnSubmit")
    private WebElement signUpButtonFromModal;
    @FindBy(id = "close")
    private WebElement closeButton;
    @FindBy(css = "#root > div:nth-child(3) > div > div > div:nth-child(1) > form")
    private WebElement logInModal;
    @FindBy(id = "logo")
    private WebElement logo;
    @FindBy(id = "BtnSubmit")
    private WebElement logInButton;
    @FindBy(id = "AccountDeleteLink")
    private WebElement deleteAccountButton;
    @FindBy(id = "BtnSubmit")
    private WebElement deleteAccountConfirmation;
    @FindBy(id = "BtnSubmit")
    private WebElement okButton;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(id = "InputLoginValue")
    private WebElement emailInput;
    @FindBy(id = "InputPassword")
    private WebElement passwordInput;
    @FindBy(css = "#global-header > div.container > ul > li.user > div > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logOut;
    @FindBy(css = "#global-nav > ul > li.pillar.watch > a")
    private WebElement watchButton;
    @FindBy(css = ".display-user")
    private WebElement displayUser;
    @FindBy(css = "#Title > span")
    private WebElement accountDeactivated;
    @FindBy(css = "p.text-block.text-left")
    private WebElement uniqueElementForDelete;
    @FindBy(id = "TextSuccess")
    private WebElement uniqueElementForDeleteAgain;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void mouseOverUser() {
        Actions action = new Actions(getDriver());
        super.waitForVisibility(userIcon);
        action.moveToElement(userIcon).perform();
    }
    public void clickOnLogInHomePage(){
        clickElement(logInOption);
    }
    public void clickOnESPNProfileHomePage(){
        clickElement(ESPNProfile);
    }
    public void goToIframe() {
        super.waitForVisibility(iframe);
        getDriver().switchTo().frame(iframe);
    }
    public boolean isLogInModalDisplayed(){
        return logInModal.isDisplayed();
    }
    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }
    public boolean isLogInDisplayed(){
        return logInButton.isDisplayed();
    }
    public boolean isSignUpDisplayed(){
        return signUpButton.isDisplayed();
    }
    public boolean isSignUpTitleDisplayed(){
        return signUpTitle.isDisplayed();
    }
    public boolean isFirstNameDisplayed(){
        return signUpFirstNameInput.isDisplayed();
    }
    public boolean isLastNameDisplayed(){
        return signUpLastNameInput.isDisplayed();
    }
    public boolean isEmailDisplayed(){
        return signUpEmailInput.isDisplayed();
    }
    public boolean isPasswordDisplayed(){
        return signUpPasswordInput.isDisplayed();
    }
    public boolean isSignUpButtonDisplayed(){
        return signUpButtonFromModal.isDisplayed();
    }
    public boolean isCloseOptionDisplayed(){
        return closeButton.isDisplayed();
    }
    public void typeFirstName(){
        typeOnInput(signUpFirstNameInput, webData.getFirstName());
    }
    public void typeLastName(){
        typeOnInput(signUpLastNameInput, webData.getLastName());
    }
    public void typeEmail(){
        typeOnInput(signUpEmailInput, webData.getEmail());
    }
    public void typePassword(){
        typeOnInput(signUpPasswordInput, webData.getPassword());
    }
    public void clickOnSignUpButtonFromModal(){
        clickElement(signUpButtonFromModal);
    }
    public void clickOnDeleteAccountButton(){
        super.waitForVisibility(deleteAccountButton);
        clickElement(deleteAccountButton);
    }
    public void getOutIframe(){
        getDriver().switchTo().defaultContent();
        super.wait.until(ExpectedConditions.invisibilityOf(iframe));
    }
    public Watch goToWatchPage(){
        clickElement(watchButton);
        return new Watch(getDriver());
    }
    public void clickOnLogOutButton(){
        clickElement(logOut);
    }
    public boolean isUsernameNotDisplayed(){
        return displayUser.findElement(By.tagName("span")).isDisplayed();
    }
    public void clickOnDeleteAccountConfirmation(){clickElement(deleteAccountConfirmation);}
    public void clickOnSignUpButton(){clickElement(signUpButton);}
    public void clickOnOkButton(){clickElement(okButton);}
    public boolean isTheAccountDeactivated(){
        return accountDeactivated.isDisplayed();
    }
    public boolean isAnUniqueElement(){
        super.waitForVisibility(uniqueElementForDelete);
        return uniqueElementForDelete.isDisplayed();
    }
    public boolean isAnUniqueElementAgain(){
        super.waitForVisibility(uniqueElementForDeleteAgain);
        return uniqueElementForDeleteAgain.isDisplayed();
    }
    public boolean isPromoBannerDisplayed(){
        boolean banner = false;
        if(promoBanner.isDisplayed()){
            super.switchToIframe(promoBanner);
            super.clickElement(closeBanner);
            banner = true;
        }
        return banner;
    }
}