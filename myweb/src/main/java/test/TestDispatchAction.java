package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

public class TestDispatchAction extends DispatchAction{

	public ActionForward testMethod(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		String success = request.getParameter("success");
		
		DynaActionForm tform= (DynaActionForm) form;
		tform.set("message", "this is message");
		
		if (success != null) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}
	}
}
