package com.qa.packageBrowser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBrowserDriver {
   public static AppiumDriver appiumBrowserSession(String platformName) {
       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
       desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);

       URL appiumURL;
       try {
           appiumURL = new URL("http://0.0.0.0:4723");
       } catch (MalformedURLException e) {
           throw new RuntimeException(e);
       }

       switch (platformName) {
           case "Android" -> {
               desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S8+");
               desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
               desiredCapabilities.setCapability(MobileCapabilityType.UDID, "ce10171ab374340704");
               desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
               desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
               desiredCapabilities.setCapability("Timeout", 3000);
               return new AndroidDriver(appiumURL, desiredCapabilities);
           }
           case "iOS" -> {
               desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
               desiredCapabilities.setCapability(MobileCapabilityType.UDID, "<ce10171ab374340704>");
               desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
               desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
               return new IOSDriver(appiumURL, desiredCapabilities);
           }
           default -> {
               System.out.println("Enter valid Platform");
           }
       }
       return null;
   }
}
