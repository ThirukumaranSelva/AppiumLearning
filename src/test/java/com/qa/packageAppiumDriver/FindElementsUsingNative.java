package com.qa.packageAppiumDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class FindElementsUsingNative {
    public static void main(String[] args) {

        //ANDROID
        AppiumDriver driver=AppiumDriverClass.initializeDriver("Android");

        WebElement text=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(text.getText());
        WebElement index=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().index(2)"));
        System.out.println(index.getText());
        WebElement resourceId=driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(2);
        System.out.println(resourceId.getText());
        WebElement className=driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(className.getText());
        WebElement graphics=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Graphics\")"));
        System.out.println(graphics.getText());

        //IOS
       // AppiumDriver driver=AppiumDriverClass.initializeDriver("iOS");

        WebElement text1=driver.findElement(AppiumBy.iOSNsPredicateString("new UiSelector().text(\"Accessibility\")"));
        System.out.println(text1.getText());
        WebElement index1=driver.findElement(AppiumBy.iOSNsPredicateString("new UiSelector().index(2)"));
        System.out.println(index1.getText());
        WebElement resourceId1=driver.findElements(AppiumBy.iOSNsPredicateString("new UiSelector().resourceId(\"android:id/text1\")")).get(2);
        System.out.println(resourceId1.getText());
        WebElement className1=driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(className1.getText());
        WebElement graphics1=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Graphics\")"));
        System.out.println(graphics1.getText());

    }
}
