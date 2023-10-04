package com.qa.packageFirst;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/*
Summary
1. Added dependencies to pom file - java Client
2. Added apk file to Project location
3. set desired capabilities (how to use MobileCapabilityType.<key>)
4. Establishing driver connection form Appium Server
5. Driver session using Options Class
6. Launch Emulator Automatically
7. Appium Inspector walk through
8. Appium Inspector to an Existing Driver Session
9. Locator Strategy


 */
public class FirstProject {
    public static void main(String[] args) throws MalformedURLException {

        //used to set desired capabilities
        String appURL = System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "ResourcesForAppium" + File.separator + "ApiDemos-debug.apk";

        //we can use MobileCapabilityType.<key> or else enter the key directly
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        //desiredCapabilities.setCapability("appium:platformVersion","11");
        //appium:platformVersion -> Not added appium vendor prefix here!  because appium will implicitly do that
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "ce10171ab374340704");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //Set session timeout after launch
        desiredCapabilities.setCapability("Timeout",300);

//        //launch adb automatically
//        desiredCapabilities.setCapability("avd","pixel_5");
//        desiredCapabilities.setCapability("avdLaunchTimeout",60000);

        //desiredCapabilities.setCapability(MobileCapabilityType.APP, appURL);
        desiredCapabilities.setCapability("appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity","io.appium.android.apis.accessibility.AccessibilityNodeProviderActivity");

        //Establishing connection to server
        URL serverURL = new URL("http://0.0.0.0:4723");
        AppiumDriver driver = new AndroidDriver(serverURL, desiredCapabilities);
        System.out.println(driver.getSessionId());


    }
}
