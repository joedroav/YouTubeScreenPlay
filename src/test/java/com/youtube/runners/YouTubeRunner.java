package com.youtube.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/reproducirVideo.feature",
        glue = "com.youtube.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class YouTubeRunner {
}
