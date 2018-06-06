package login;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.AdminDao;

public class LoginAction extends Action{
	ActionForward forward;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, NamingException {

		if (request.getMethod().equals("GET")) {
			forward = doGet(mapping, _form, request, response);
		} else if (request.getMethod().equals("POST")) {
			if (_form instanceof LoginForm) {
				LoginForm form = (LoginForm) _form;
				ActionErrors errors = form.validate(mapping, request);
				if (errors != null && !errors.isEmpty()) {
					saveErrors(request, errors);
					return mapping.getInputForward();
				}
				forward = doPost(mapping, _form, request, response);
			}
		}
		return forward;
	}

	public ActionForward doGet(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response) {
//		HttpSession session = request.getSession(false);// セッションを持っているか確認する
//		if (session != null && session.getAttribute("user") != null) {
//			// セッションが発行されている
//			return mapping.findForward("Login");
//		}
		return mapping.findForward("ok");

	}

	public ActionForward doPost(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response) {
		AdminDao dao = new AdminDao();// 実際処理する為のクラス//
		LoginForm form = (LoginForm) _form;
		request.setAttribute("form", form);
		int i = dao.OneList(form.getEmail(), form.getPassWord());
		switch (i) {

		case -1:
		case -2:
			return mapping.findForward("NotLogin");
		case -3:
			return mapping.findForward("LockLogin");
		case 1:
//			dao.OneList(form.getEmail(), form.getPassWord());
//			HttpSession session = request.getSession(true);
//			session.setAttribute("user", dao.getAdmin());
			return mapping.findForward("Login");
		}

		return mapping.findForward("No");
	}
}
