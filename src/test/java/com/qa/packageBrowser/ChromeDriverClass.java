package com.qa.packageBrowser;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ChromeDriverClass {
    public static void main(String[] args) {
        AppiumDriver driver=AppiumBrowserDriver.appiumBrowserSession("Android");
        driver.get("https://www.youtube.com");
    }
}
