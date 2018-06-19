package admin;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.UserDao;

public class OptionAction extends Action {
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
		request.setAttribute("pullDownListT", dao.doPullDownTitle());
		request.setAttribute("pullDownListS", dao.doPullDownSex());
		request.setAttribute("pullDownListC1", dao.doPullDownClassification1());
		request.setAttribute("pullDownListC2", dao.doPullDownClassification2());
		return mapping.findForward("ok");

	}

	public ActionForward doPost(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
		HttpServletResponse response) {
		UserDao dao = new UserDao();// 実際処理する為のクラス//
		OptionForm form = (OptionForm)_form;
		int i = form.getSelect();
		switch (i) {
			case 1:
				dao.titleInsert(form.getTitle());break;
			case 2:
				dao.classInsert1(form.getClassification1());break;
			case 3:
				dao.classInsert2(form.getClassification2());break;
		}

			return mapping.findForward("view");

	}
}
