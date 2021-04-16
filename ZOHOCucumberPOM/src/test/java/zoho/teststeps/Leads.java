package zoho.teststeps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zoho.context.TestContext;

public class Leads {
	
	public TestContext context;
	
	
	public Leads(TestContext context) {
		this.context=context;
	}
	
	@Before
	public void before(Scenario scenario) {		
		context.createScenario(scenario.getName());
		context.log("Starting scenario "+ scenario.getName());
	}
	
	@After
	public void after(Scenario scenario) {
		context.log("Ending scenario "+ scenario.getName());
		context.endScenario();
		System.out.println("-------------------------------------------------");
	}
	
	

	@When("I go to {string} page")
	public void verifyLeadsPage(String pageName) {
		context.log("I go to "+pageName+" page");
	}
	
	@And("enter and submit lead details")
	public void submitDetails() {
		context.log("enter and submit lead details");
	}
	
	@And("I verify lead details")
	public void verifyLeadDetails() {
		context.log("I verify lead details");
	}
	
	@Then("Lead should be present inside the grid")
	public void verifyLeadCreation() {
		context.log("Lead should be present inside the grid");
	}
	

}
