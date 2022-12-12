package org.finalexam.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Watch extends BasePage {
    @FindBy(css = "section.Carousel")
    private List<WebElement> carouselList;
    @FindBy(css = ".lightbox__closebtn--dark")
    private WebElement xButton;
    @FindBy(id= "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css = ".display-user")
    private WebElement displayUser;
    @FindBy(css = "#global-header > div.container > ul > li.user > div > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logOut;
    @FindBy(xpath = "//body/div[@id='espnfitt']/div[@id='fitt-analytics']/div[1]/main[1]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/div[1]/figure[1]/div[2]/picture[1]/img[1]")
    private WebElement secondCardOnFirstCarousel;

    public Watch(WebDriver driver) {super(driver);}
    public boolean atLeastOneCarouselIsDisplayed(){
        waitForElements(By.cssSelector("ul.Carousel__Inner li"));
        return carouselList.size() > 0;
    }
    public void clickOnSecondCardFirstCarousel(){
        super.waitForVisibility(secondCardOnFirstCarousel);
        clickElement(secondCardOnFirstCarousel);
    }
    public boolean isXButtonDisplayed(){
        super.waitForVisibility(xButton);
        return xButton.isDisplayed();
    }
    public void clickOnXButton(){
        super.waitForVisibility(xButton);
        clickElement(xButton);
    }
    public void previousPage(){
        getDriver().navigate().back();
    }
    public void mouseOverUser() {
        Actions action = new Actions(getDriver());
        super.waitForVisibility(userIcon);
        action.moveToElement(userIcon).perform();
    }
    public boolean isUsernameDisplayed(){
        return displayUser.findElement(By.tagName("span")).isDisplayed();
    }
    public void clickOnLogOutButton(){
        clickElement(logOut);
    }
    public boolean isUsernameNotDisplayed(){
        try {
            displayUser.findElement(By.tagName("span")).isDisplayed();
            return false;
        } catch (StaleElementReferenceException err){
            err.getCause();
            return true;
        }
    }
}
