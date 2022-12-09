package org.finalexam.configuration.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    protected final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        initElements(driver, this);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }
    public void typeOnInput(WebElement element, String text) {element.sendKeys(text);}
    public void waitForVisibility(WebElement element) {wait.until(ExpectedConditions.visibilityOf(element));}
    public void waitForClickable(WebElement element) {wait.until(ExpectedConditions.elementToBeClickable(element));}
    public void waitForElements(By element){wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));}
    public void switchToIframe(WebElement element) {
        waitForVisibility(element);
        getDriver().switchTo().frame(element);
    }
}
