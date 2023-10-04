package com.qa.packageHybrid;

import com.google.common.collect.ImmutableMap;
import com.qa.packageAppiumDriver.AppiumDriverClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class WebView {
    @AndroidFindBy(accessibility = "Views")
    static WebElement views;
    @AndroidFindBy(id = "android:id/list")
    static WebElement list;
    @AndroidFindBy(accessibility = "WebView2")
    static WebElement webView;
    @AndroidFindBy(id = "i_am_a_textbox")
    static WebElement textBox;
    @AndroidFindBy(xpath = "//*[text(contains(),\"This page is a Second Selenium sandbox\")]")
    static WebElement text;
    @AndroidFindBy(xpath = "//a[@id=\"i am a link\"]")
    static WebElement link;
    public WebView(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverClass.initializeDriver("Android");
        new WebView(driver);
        views.click();


        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)list).getId(),
                "direction","up",
                "percent",1.0
        ));
        webView.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Set<String> contextHandles=((SupportsContextSwitching)driver).getContextHandles();
        Iterator<String> iterator=contextHandles.iterator();
        for(String s:contextHandles)
        {
            System.out.println(s);
        }
        ((SupportsContextSwitching) driver).context(contextHandles.toArray()[1].toString());
        String expected="This page is a Second Selenium sandbox";
        String actual=text.getText();
        System.out.println(actual);
        if(actual.equalsIgnoreCase(expected)) System.out.println("Passed!");
        else System.out.println("Failed!");
        ((SupportsContextSwitching) driver).context(contextHandles.toArray()[0].toString());
    }
}
