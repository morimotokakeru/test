/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import dao.AdminDao;

public class LoginAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	/**
	 * This is the action called from the Struts framework.
	 * 
	 * @param mapping
	 *            The ActionMapping used to select this instance.
	 * @param form
	 *            The optional ActionForm bean for this request.
	 * @param request
	 *            The HTTP Request we are processing.
	 * @param response
	 *            The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 */

	/*
	 * if user == password -> SUCCESS else user != password -> FAILURE
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionForward forward ;
		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		AdminDao dao = AdminDao.getInstance();
		int check = dao.loginCheck(userName, password);
		System.out.println(check);
		if (check == 0) // wrong passWD -> login
		{
			request.setAttribute("fail", "0");
			return mapping.findForward(FAILURE);
			//forward.setRedirect(false);
			// forward.setNextPath("Login.do");
		} else if (check == -1) // dont have id -> login
		{
			request.setAttribute("fail", "-1");
			return mapping.findForward(FAILURE);
			//forward.setRedirect(false);
			// forward.setNextPath("Login.do");
		} else {
			session.setAttribute("sessionID", userName);
			return mapping.findForward(SUCCESS);
			//forward.setRedirect(true);
			// forward.setNextPath("Login.do");
		}

	     //	return forward;
	}

	/*
	 * AdminDao dao = AdminDao.get;
	 * 
	 * LoginActionForm loginForm = (LoginActionForm) form;
	 * 
	 * request.setAttribute("adminbeans", dao.getAdmin(loginForm));
	 */

	/*
	 * if (loginForm.getUserName().equals(loginForm.getPassword())) { return
	 * mapping.findForward(SUCCESS); } else { return mapping.findForward(FAILURE); }
	 */

	/*
	 * String userName = request.getParameter("userName");
	 * System.out.println("LoginAciton userName: " + userName); String password =
	 * request.getParameter("password"); System.out.println("LoginAciton password: "
	 * + password);
	 * 
	 * if (loginForm.getUserName().equals(loginForm.getPassword())) { return
	 * mapping.findForward(SUCCESS); } else { return mapping.findForward(FAILURE); }
	 */
}
