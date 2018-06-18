package join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.AdminDao;

public class UserInfoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//UserInfoActionForm UIForm = (UserInfoActionForm)form;
		AdminDao dao = AdminDao.getInstance();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionID");
		
				
		request.setAttribute("info", dao.getUserInfo(id));
		return mapping.findForward("success");
	}

}
