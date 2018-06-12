package join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.JoinDao;

public class JoinAction extends Action {
	
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		JoinActionForm insertForm = (JoinActionForm)form;
		JoinDao dao = JoinDao.getInstance();
		
		String email = request.getParameter("email");
		
		int check = dao.idCheck(email);
		System.out.println(check);
		if(check == 0)//fail
		{
			return mapping.findForward(FAILURE);
		}else {
			dao.insertAdmin(insertForm);
			return mapping.findForward(SUCCESS);
		}
		
	}
	
}
