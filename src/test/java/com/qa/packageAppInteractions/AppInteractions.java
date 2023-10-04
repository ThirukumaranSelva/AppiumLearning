package com.qa.packageAppInteractions;

import com.qa.packageAppiumDriver.AppiumDriverClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AppInteractions {

    @AndroidFindBy(accessibility = "Views")
    static WebElement views;

    AppInteractions(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public static void main(String[] args) {
        AppiumDriver driver= AppiumDriverClass.initializeDriver("Android");
        AppInteractions appInteractions=new AppInteractions(driver);

        views.click();
        driver.quit();
    }
}
