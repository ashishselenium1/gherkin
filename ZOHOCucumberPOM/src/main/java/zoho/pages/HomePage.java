package zoho.pages;

import com.aventstack.extentreports.ExtentTest;

import zoho.managers.WebDriverManager;

public class HomePage {
	WebDriverManager app;
	
	public HomePage(WebDriverManager app) {
		this.app=app;
	}
	
	public void load(String browser) { // open browser and navigate it to home page
		app.log("Trying to load home page after launching browser");
		app.openBrowser(browser);
		app.navigate("url");
		if(!app.verifyTitle("homepagetitle"))
			app.logFailure("Titles did not match");
		// verify if the home page is loaded
		
	}
	
	public void gotoLoginPage() {
		app.log("Trying to load login Page");
		app.click("signin_link_css");
		// verify if login page has loaded
		
	}

}
