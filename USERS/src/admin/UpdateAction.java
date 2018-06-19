package admin;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.UserDao;
import users.UpdateForm;

public class UpdateAction extends Action {
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
		UpdateForm form = (UpdateForm)_form;
		UserDao dao = new UserDao();// 実際処理する為のクラス//
		request.setAttribute("beans", dao.getOneRecode(form.getUserId()));
		request.setAttribute("pullDownListT", dao.doPullDownTitle());
		request.setAttribute("pullDownListS", dao.doPullDownSex());
		request.setAttribute("pullDownListC1", dao.doPullDownClassification1());
		request.setAttribute("pullDownListC2", dao.doPullDownClassification2());
		return mapping.findForward("ok");
	}

	public ActionForward doPost(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
		HttpServletResponse response) {
		UserDao dao = new UserDao();// 実際処理する為のクラス//
		UpdateForm form = (UpdateForm)_form;
		if(form.getSelect() == 1) {
			if (_form instanceof UpdateForm) {
				ActionErrors errors = form.validate(mapping, request);
				if (errors != null && !errors.isEmpty()) {
					saveErrors(request, errors);
					request.setAttribute("form",form );
					return mapping.getInputForward();
				}
			}
			request.setAttribute("form",form );
			return mapping.findForward("check");
		}
			dao.doUpdate(form);
			return mapping.findForward("view");
	}
}
