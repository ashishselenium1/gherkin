package zoho.teststeps;

import io.cucumber.java.en.When;
import zoho.context.TestContext;

public class TopMenu {
    public TestContext context;
	
	public TopMenu(TestContext context) {
		this.context=context;
	}
	
	@When("I click on {string} in top menu")
	public void loadPage(String menuOption) {
		context.log("I click on "+menuOption+" in top menu");
	}

}
