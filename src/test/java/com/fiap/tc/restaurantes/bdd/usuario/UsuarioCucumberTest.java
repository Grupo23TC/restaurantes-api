package com.fiap.tc.restaurantes.bdd.usuario;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/usuario")
@CucumberOptions(
    glue = "com.fiap.tc.restaurantes.bdd.usuario",
    plugin = {"pretty", "html:target/cucumber-reports/usuario.html"},
    dryRun = false
)
public class UsuarioCucumberTest {
}
