package com.qa.packageAppiumDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;

public class FindElementsClass {
    public static void main(String[] args) {
        AppiumDriver driver=AppiumDriverClass.initializeDriver("Android");

        WebElement animation= driver.findElement(AppiumBy.accessibilityId("Animation"));
        System.out.println(animation.getText());

        WebElement xpath=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]"));
        System.out.println(xpath.getText());

        WebElement id=driver.findElements(AppiumBy.id("android:id/text1")).get(2);
        System.out.println(id.getText());

        WebElement className=driver.findElements(AppiumBy.className("android.widget.TextView")).get(3);
        System.out.println(className.getText());



    }
}
