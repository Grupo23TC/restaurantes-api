package com.fiap.tc.restaurantes.bdd.mesa;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("Cucumber")
@SelectClasspathResource("features/mesa/mesa.feature")
@CucumberOptions(
    glue = {"com.fiap.tc.restaurantes.bdd.mesa", "com.fiap.tc.restaurantes.bdd.restaurante"},
    plugin = {"pretty", "html:target/cucumber-reports/mesa.html"},
    dryRun = false
)
public class MesaCucumberTest {
}
