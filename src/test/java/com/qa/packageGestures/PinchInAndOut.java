package com.qa.packageGestures;

import com.google.common.collect.ImmutableMap;
import com.qa.packageAppiumDriver.AppiumDriverClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class PinchInAndOut {

    @AndroidFindBy(accessibility = "Views")
    static WebElement views;
    @AndroidFindBy(accessibility = "Gallery")
    static WebElement gallery;
    @AndroidFindBy(accessibility = "1. Photos")
    static WebElement photos;
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]")
    static WebElement imageXpath;
    @AndroidFindBy(id = "android:id/list")
    static WebElement list;

    @AndroidFindBy(id = "io.appium.android.apis:id/gallery")
    static WebElement galleryList;

    PinchInAndOut(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws InterruptedException {
        AppiumDriver driver = AppiumDriverClass.initializeDriver("Android");
        PinchInAndOut pinchInAndOut=new PinchInAndOut(driver);
        //pinchInAndOut(driver);
        swipeGesture(driver);

    }

    public static void pinchInAndOut(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(5000);
        // Java
//        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
//               "left",500,"top",200,"Width",300,"height",300,"percent",0.75
//        ));


        Thread.sleep(5000);
        // Java
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 500, "top", 200, "Width", 300, "height", 300, "percent", 0.75
        ));
    }

    public static void swipeGesture(AppiumDriver driver) {

        views.click();

        // Java
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
               // "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId",((RemoteWebElement)list).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.executeScript("mobile: swipeGesture",ImmutableMap.of(
                "elementId",((RemoteWebElement)list).getId(),
                "direction","down",
                "percent",0.75));

        gallery.click();
        photos.click();
/*
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)imageXpath).getId(),
                "direction","left",
                "percent",0.75
        ));

*/
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)galleryList).getId(),
                "direction","left",
                "percent",0.75
                ));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)galleryList).getId(),
                "direction","right",
                "percent",0.75
        ));

    }
}
