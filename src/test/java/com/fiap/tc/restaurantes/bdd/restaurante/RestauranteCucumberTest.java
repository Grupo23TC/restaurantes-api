package com.fiap.tc.restaurantes.bdd.restaurante;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/restaurante")
@CucumberOptions(
    glue = "com.fiap.tc.restaurantes.bdd.restaurante",
    plugin = {"pretty", "html:target/cucumber-reports/restaurante.html"},
    dryRun = false
)
public class RestauranteCucumberTest {
}
