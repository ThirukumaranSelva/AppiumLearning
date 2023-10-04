package com.qa.packageAppiumDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Arrays;

public class ElementActions {

    @AndroidFindBy (accessibility = "Views")
    static WebElement views;

    @AndroidFindBy(accessibility = "TextFields")
    static WebElement textFields;

    @AndroidFindBy(id = "io.appium.android.apis:id/edit")
    static WebElement enterText;

    public ElementActions(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws InterruptedException {
        AppiumDriver driver = AppiumDriverClass.initializeDriver("Android");

        //driver.findElement(AppiumBy.accessibilityId("Views")).click();

        ElementActions elementActions=new ElementActions(driver);
        views.click();

        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(481, 1998);
        Point end = new Point(550, 275);
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start.getX(),
                                start.getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));


        final PointerInput FINGER1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start1 = new Point(454, 2032);
        Point end1 = new Point(543, 426);
        Sequence swipe1 = new Sequence(FINGER1, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start1.getX(),
                                start1.getY()))
                .addAction(FINGER1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                end1.getX(),
                                end1.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe1));

        textFields.click();
        enterText.sendKeys("Thiru entered Test.");


//        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
//        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("Text");
    }
}
