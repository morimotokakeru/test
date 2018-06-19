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
import users.UserViewForm;

public class ViewAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {

		UserViewForm form = (UserViewForm) _form;
		UserDao dao = new UserDao();
		request.setAttribute("beans", dao.getUserAll(form));
		return mapping.findForward("ok");

	}

}
