package org.finalexam.configuration.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    protected final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15L);
        initElements(driver, this);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }
    public void scrollToElement(WebElement element){
        Actions action = new Actions(getDriver());
        action.moveToElement(element);
    }
    public void typeOnInput(WebElement element, String text) {element.sendKeys(text);}
    public void waitForVisibility(WebElement element) {wait.until(ExpectedConditions.visibilityOf(element));}
    public void waitForClickable(WebElement element) {wait.until(ExpectedConditions.elementToBeClickable(element));}
    public void waitForElements(By element){wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));}
}
