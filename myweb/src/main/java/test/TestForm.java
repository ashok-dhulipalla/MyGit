package test;

import org.apache.struts.action.ActionForm;

public class TestForm extends ActionForm{

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
