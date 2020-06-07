package com.api.automation.Runner;

import static com.api.automation.helper.Constants.CONFIG_PROPERTY_FILE_PATH;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.api.automation.utils.PropertyUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/stories/apiFeatures",glue={"com.api.automation.steps"},tags="@SmokeTest")
public class E2ERunner {

	@BeforeClass
    public static void setUp() throws IOException {
        System.out.println("Loading Properties from --->" + CONFIG_PROPERTY_FILE_PATH);
        PropertyUtil.loadProperies(CONFIG_PROPERTY_FILE_PATH);
        System.out.println("Properties Loaded Successfully");
    }
	
}
