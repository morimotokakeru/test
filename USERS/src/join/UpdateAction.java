package join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.AdminBean;
import dao.AdminDao;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UpdateActionForm UpdateActionForm = (UpdateActionForm)form;
		AdminDao dao = AdminDao.getInstance();
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("sessionID");
		
		dao.doUpdate(email,UpdateActionForm);
		return mapping.findForward("success"); 
	}

}
