package zoho.pages;

import zoho.managers.WebDriverManager;

public class LoginPage {
	
    WebDriverManager app;
	
	public LoginPage(WebDriverManager app) {
		this.app=app;
	}
	
	
	public void doLogin() {
		app.type("username_id", "se.le.ni.umtraining10@gmail.com");
		app.click("nextbutton_xp");
	}

}
