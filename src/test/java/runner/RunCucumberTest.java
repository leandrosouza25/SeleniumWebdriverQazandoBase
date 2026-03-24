package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/allure-results/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-html-report.html"
        },
        features = "src/test/resources/features",
        glue = {"steps","LoginSteps"}
        //tags = "@login-invalido"
)
public class RunCucumberTest extends RunBase {

    @AfterClass
    public static void stop() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}