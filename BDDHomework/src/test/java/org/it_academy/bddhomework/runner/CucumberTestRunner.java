package org.it_academy.bddhomework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestRunner.html",
                "json:target/cucumber-reports/CucumberTestRunner.json",
                "junit:target/cucumber-reports/CucumberTestRunner.xml"},
        monochrome = true,
        glue = "org.it_academy.bddhomework",
        features = "src/test/resources/org.it_academy.bddhomework.features"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

