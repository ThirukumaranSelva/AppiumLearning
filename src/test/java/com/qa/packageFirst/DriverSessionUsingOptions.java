package com.qa.packageFirst;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSessionUsingOptions {
    public static void main(String[] args) throws MalformedURLException {
        String appURL = System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "ResourcesForAppium" + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options androidOptions=new UiAutomator2Options()
                .setApp(appURL)
                .setPlatformName("Android")
                .setPlatformVersion("11")
                .setUdid("emulator-5556")
                .setAutomationName("UIAutomator2");

        URL serverURL = new URL("http://0.0.0.0:4723");
        AppiumDriver driver = new AndroidDriver(serverURL, androidOptions);
    /*
        XCUITestOptions options=new XCUITestOptions()
                .setApp("<appURLiOS>")
                .setPlatformName("iOS")
                .setPlatformVersion("")
                .setUdid("emulator-5556");

*/
    }
}

