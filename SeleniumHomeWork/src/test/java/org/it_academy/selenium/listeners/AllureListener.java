package org.it_academy.selenium.listeners;

import io.qameta.allure.Allure;
import org.it_academy.selenium.framework.WebDriverDiscovery;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListener extends TestListenerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AllureListener.class);

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.info("Executing listener on failure");

        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.info("Executing listener on skipped");

        takeScreenshot();
    }

    private void takeScreenshot(){
        WebDriver driver = WebDriverDiscovery.getDriver();

        try {
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e){
            logger.error(e.getStackTrace().toString());
        }
    }
}
