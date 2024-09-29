package com.fiap.tc.restaurantes.bdd;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberOptions(
    glue = "com.fiap.tc.restaurantes.bdd",
    plugin = {"pretty", "html:target/cucumber-reports/system-test.html"},
    dryRun = false
)
public class CucumberTest {
}
