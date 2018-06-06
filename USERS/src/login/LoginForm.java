package login;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
	private String email;
	private String passWord;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


}
