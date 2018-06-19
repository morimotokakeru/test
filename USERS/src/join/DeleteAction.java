package join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.AdminDao;

public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		
		DeleteActionForm DAForm = (DeleteActionForm)form;
		String password = DAForm.getPassword();
		
		AdminDao dao = AdminDao.getInstance();
		int check = dao.deleteUser(id, password);
		
		if(check ==1)
		{
			session.invalidate();
		}
		
		return mapping.findForward("success");
	}

}
