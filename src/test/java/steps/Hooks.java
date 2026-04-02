package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //this hooks class will be used to open and close the browser before and after each scenario
    //this hooks class must be inside steps package because in runner class we have mentioned the glue as steps, so it will only look for the classes inside steps package


    //pre condition
    @Before
    public void start() {
        openBrowserAndLaunchApplication();
    }

    //post condition
    @After
    public void end(Scenario scenario){
        //scenario class holds the information about the scenario that is currently running,
        // so we can use it to get the name of the scenario and print it in the console
        byte[] pic;
        //put the condition for pass and fail test cases, if the scenario is failed, then take a screenshot and attach it to the report
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        //the agenda is to attach the screenshot to the report.
        scenario.attach(pic,"image/png",scenario.getName());

        closeBrowser();
    }
}
