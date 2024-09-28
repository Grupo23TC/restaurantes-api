package com.fiap.tc.restaurantes.bdd.reserva;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/reserva")
@CucumberOptions(
        glue = {"com.fiap.tc.restaurantes.bdd.reserva", "com.fiap.tc.restaurantes.bdd.mesa"},
        plugin = {"pretty", "html:target/cucumber-reports/reserva.html"},
        dryRun = false
)
public class ReservaCucumberTest {
}
