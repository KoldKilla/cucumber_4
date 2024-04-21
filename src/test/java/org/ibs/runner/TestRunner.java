package org.ibs.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;



@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui"),
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.ibs.steps" ),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm, pretty")
})
public class TestRunner {

}