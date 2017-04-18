package myprojects.automation.assignment3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

    public void beforeAlertAccept(WebDriver driver) {
    }

    public void afterAlertAccept(WebDriver driver) {
    }

    public void afterAlertDismiss(WebDriver driver) {
    }

    public void beforeAlertDismiss(WebDriver driver) {
    }

    public void beforeNavigateTo(String var1, WebDriver var2) {
        System.out.println("Navigate to " + var1);
    }

    public void afterNavigateTo(String var1, WebDriver var2) {
    }

    public void beforeNavigateBack(WebDriver var1) {
    }

    public void afterNavigateBack(WebDriver var1) {
    }

    public void beforeNavigateForward(WebDriver var1) {
    }

    public void afterNavigateForward(WebDriver var1) {
    }

    public void beforeNavigateRefresh(WebDriver var1) {
    }

    public void afterNavigateRefresh(WebDriver var1) {
    }

    public void beforeFindBy(By var1, WebElement var2, WebDriver var3) {
        System.out.println("Should be " + var1);
    }

    public void afterFindBy(By var1, WebElement var2, WebDriver var3) {
        System.out.println("Element found");
    }

    public void beforeClickOn(WebElement var1, WebDriver var2) {
        if (var1.getText().equals("")) {
            System.out.println("Should click " + var1.getTagName());
        } else {
            System.out.println("Should click " + var1.getText());
        }
    }

    public void afterClickOn(WebElement var1, WebDriver var2) {
        System.out.println("Clicked successful");
    }

    public void beforeChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3) {
    }

    public void afterChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3) {
    }

    public void beforeScript(String var1, WebDriver var2) {
    }

    public void afterScript(String var1, WebDriver var2) {
    }

    public void onException(Throwable var1, WebDriver var2) {
    }
}
