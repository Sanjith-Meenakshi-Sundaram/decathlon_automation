package hooks;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;

public class ExtentHooks {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void startScenario(Scenario scenario) {
        ExtentTest extentTest =
                ExtentManager.getExtent().createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void endScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            test.get().fail("Scenario Failed");
        } else {
            test.get().pass("Scenario Passed");
        }

        ExtentManager.getExtent().flush();
    }
}
