package org.finalexam.configuration.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriverManager(String browser) {
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }
    public WebDriver getDriver(){return driver;}
}
