package admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.UserDao;
import users.UserDetailForm;

public class DetailAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {

				UserDetailForm form = (UserDetailForm) _form;
				UserDao dao = new UserDao();
				request.setAttribute("bean", dao.getOneRecode(form.getUserId()));
				return mapping.findForward("ok");


	}
}
