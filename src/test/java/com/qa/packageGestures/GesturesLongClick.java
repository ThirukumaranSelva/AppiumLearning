package com.qa.packageGestures;

import com.google.common.collect.ImmutableMap;
import com.qa.packageAppiumDriver.AppiumDriverClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;


public class GesturesLongClick {

    @AndroidFindBy(accessibility ="Views" )
    static WebElement views;
    @AndroidFindBy(accessibility = "Drag and Drop")
    static WebElement dragAndDrop;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    static WebElement dragAndDropElement;

    @AndroidFindBy(id ="io.appium.android.apis:id/drag_result_text" )
    static WebElement droppedText;

    GesturesLongClick(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    static void longClickGesture(AppiumDriver driver) {
        views.click();
        dragAndDrop.click();

        // Java
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) dragAndDropElement).getId(),"duration",1000
        ));

        //CoOrdinates
//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                //"elementId", ((RemoteWebElement) dragAndDropElement).getId()
//                "x", 119, "y", 558, "duration", 1000));
    }

    static void clickGesture(AppiumDriver driver){
        views.click();
        // Java
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) dragAndDrop).getId()
        ));
    }
    static void dragAndDrop(AppiumDriver driver){
        views.click();
        dragAndDrop.click();
        // Java
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) dragAndDropElement).getId(),
                "endX", 649,
                "endY", 662
        ));
        String expectedText="Dropped!";
        String text=droppedText.getText();
        if (text.equalsIgnoreCase(expectedText)){
            System.out.println("Code Passed!");
        }else System.out.println("Failed!");

    }
    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverClass.initializeDriver("Android");
        GesturesLongClick gesturesLongClick=new GesturesLongClick(driver);
       // longClickGesture(driver);
//        clickGesture(driver);
        dragAndDrop(driver);

    }
}
