package Pages;

import java.io.IOException;
import POM.Login;

public class LoginPage extends SuperTestNG {
	
	public void UserLogin(String username, String password) throws InterruptedException, IOException{
		Login login = new Login(driver);
		login.UserLogin(username, password);
	}
}
