package users;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.UserDao;

public class NewAction extends Action {
	ActionForward forward;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, NamingException {
		if(request.getMethod().equals("GET")) {
			forward = doGet (mapping,_form,request,response);
		}
		else if (request.getMethod().equals("POST")) {
			forward = doPost (mapping,_form,request,response);
		}
		return forward;
	}

	public ActionForward doGet(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
		HttpServletResponse response) {
		UserDao dao = new UserDao();// 実際処理する為のクラス//
		request.setAttribute("pullDownList", dao.doPullDown());
		return mapping.findForward("ok");

	}

	public ActionForward doPost(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
		HttpServletResponse response) {
		UserDao dao = new UserDao();// 実際処理する為のクラス//
		NewForm form = (NewForm)_form;
		if(form.getSelect() == 1) {
			request.setAttribute("form",form );
			return mapping.findForward("check");
		}
//			dao.doUpdate(form);
			return mapping.findForward("view");

	}
}
