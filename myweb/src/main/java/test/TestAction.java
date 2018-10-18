package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

public class TestAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String success = request.getParameter("success");
		
		TestForm tform= (TestForm) form;
		tform.setMessage("------------------------");
		
		if (success != null) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}
	}

}
