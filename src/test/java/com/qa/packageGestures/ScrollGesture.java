package com.qa.packageGestures;

import com.google.common.collect.ImmutableMap;
import com.qa.packageAppiumDriver.AppiumDriverClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class ScrollGesture {
    @AndroidFindBy(accessibility = "Views")
    static WebElement views;
    @AndroidFindBy(id = "android:id/content")
    static WebElement content;
    @AndroidFindBy(accessibility = "Animation")
    static WebElement animation;

    ScrollGesture(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverClass.initializeDriver("Android");
        new ScrollGesture(driver);

        views.click();


       /* driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)content).getId(),"direction","down","percent",1.0
        ));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)content).getId(),"direction","up","percent",1.0
        ));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)animation).getId(),"direction","down","percent",1.0
        ));
*/
        boolean b = true;
        while (b) {
            b = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    //"elementId",((RemoteWebElement)animation).getId(),
                    "left", 100,
                    "top", 100,
                    "width", 600,
                    "height", 600,
                    "direction", "down", "percent", 1.0
            ));
        }
        do {
            b = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    //"elementId",((RemoteWebElement)animation).getId(),
                    "right", 100,
                    "top", 2000,
                    "width", 600,
                    "height", 600,
                    "direction", "up", "percent", 1.0
            ));
        }while (b==true);




        /*
         * Scroll:
         * - move till the <Entered % eg. 0.75%> of current screen size
         * - Start with down
         * - iterating is possible
         * - we can scroll element one by one
         *
         * Swipe:
         * - move till the end of the Screen
         * - start with up
         * */
    }
}
