package com.qa.packageAppiumDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindByClass {
    @AndroidFindBy(accessibility = "Animation")
    @iOSXCUITFindBy(id = "Animation")
    @FindBy(id = "Animation")
    static WebElement accessibilityId;

    @iOSXCUITFindBy(id = "Accessibility")
    static WebElement iOSAccessibilityId;

    public FindByClass(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public static void main(String[] args) {
        AppiumDriver driver=AppiumDriverClass.initializeDriver("Android");

        FindByClass findByClass=new FindByClass(driver);
       /*
        //Normal way
        WebElement animation=driver.findElement(AppiumBy.accessibilityId("Animation"));
        System.out.println(animation.getText());
*/
        System.out.println(accessibilityId.getText());


    }
}
