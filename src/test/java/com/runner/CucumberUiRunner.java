package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/ui_features", glue = "com.ui.stepdefinations", monochrome = true, dryRun = false, tags = "@login", plugin = {"pretty", "html:target/index.html"})
public class CucumberUiRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
