package com.qa.packageAppiumDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverClass extends DesiredCapabilities {

    public static AppiumDriver initializeDriver(String platformName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability("Timeout", 300);

        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        switch (platformName) {
            case "Android" -> {

                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S8+");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "ce10171ab374340704");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                String s = System.getProperty("user.dir") + File.separator + "src" + File.separator + "ResourcesForAppium" + File.separator + "ApiDemos-debug.apk";
                //desiredCapabilities.setCapability(MobileCapabilityType.APP,s);

//                For APIDemos Application
                desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
                desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

//                ForGoogleMapsApplication
//                desiredCapabilities.setCapability("appPackage","com.google.android.apps.maps");
//                desiredCapabilities.setCapability("appActivity","com.google.android.maps.MapsActivity");
                desiredCapabilities.setCapability("Timeout",3000);
                return new AndroidDriver(url, desiredCapabilities);
            }
            case "iOS" -> {
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
                desiredCapabilities.setCapability("simulatorStartupTimeout",180000);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "<ce10171ab374340704>");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                String s = System.getProperty("user.dir") + File.separator + "src" + File.separator + "ResourcesForAppium" + File.separator + "ApiDemos-debug.apk";
                //desiredCapabilities.setCapability(MobileCapabilityType.APP,s);

                desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
                desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

                return new IOSDriver(url, desiredCapabilities);
            }
            default -> {
                try {
                    throw new Exception("Enter Valid PlatformName. Eg. iOS or Android");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
