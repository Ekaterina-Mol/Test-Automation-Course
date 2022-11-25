package org.it_academy.selenium.listeners;

import io.qameta.allure.Allure;
import org.it_academy.selenium.framework.WebDriverDiscovery;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("Executing listener on failure");

        this.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("Executing listener on skipped");

        this.takeScreenshot();
    }

    private void takeScreenshot(){
        WebDriver driver = WebDriverDiscovery.getDriver();

        try {
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
