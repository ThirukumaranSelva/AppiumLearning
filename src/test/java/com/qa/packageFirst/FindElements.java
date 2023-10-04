package com.qa.packageFirst;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FindElements {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"ce10171ab374340704");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        //String apkURL=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"ResourcesForAppium"+File.separator+"ApiDemos-debug.apk";
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,apkURL);
        desiredCapabilities.setCapability("appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");

        URL url=new URL("http://0.0.0.0:4723");
        AppiumDriver driver=new AndroidDriver(url,desiredCapabilities);
        driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();
        WebElement click= driver.findElement(AppiumBy.accessibilityId("Accessibility Node Provider"));
        Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(click));
        click.click();


    }
}

