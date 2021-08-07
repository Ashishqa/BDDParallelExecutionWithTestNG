package com.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tests.BaseTest;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;


@CucumberOptions (
		features={"src/test/resources/features/"},
		glue={"com.steps","Hook"},
		tags="@Regression",
		plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		monochrome=true,
		dryRun=false
		)

public class Runners extends BaseTest{
	
		private TestNGCucumberRunner testNGCucumberRunner;
         
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }

	    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
	    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	    }

	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return testNGCucumberRunner.provideScenarios();
	    }

	    @AfterClass(alwaysRun = true)
	    public synchronized void tearDownClass() {
	        testNGCucumberRunner.finish();
	    }
	    

	}

