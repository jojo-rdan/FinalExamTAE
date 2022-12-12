package org.finalexam.utils.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebData {
    private String url;
    private String browser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public WebData() {
        this.url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        this.browser = "chrome";
        this.firstName = "Jordan";
        this.lastName = "Gonzalez";
        this.email = "chutaen1034@gmail.com";
        this.password = "Benjamin2022*";
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
