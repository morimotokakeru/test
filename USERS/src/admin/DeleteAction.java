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
import users.DeleteForm;


	public class DeleteAction extends Action {
		public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest request,
				HttpServletResponse response) throws SQLException, IOException {
			ActionForward forward;
				if(request.getMethod().equals("GET")) {
					forward = doGet(mapping,_form,response,request);
				}else {
					forward = doPost(mapping,_form,response,request);
				}
			return forward;


		}



		private ActionForward doGet(ActionMapping mapping, ActionForm _form, HttpServletResponse response,
				HttpServletRequest request) {
			UserDao dao = new UserDao();
			DeleteForm form = (DeleteForm) _form;
			request.setAttribute("bean", dao.getOneRecode(form.getUserId()));
			return mapping.findForward("ok");
		}

		private ActionForward doPost(ActionMapping mapping, ActionForm _form, HttpServletResponse response,
				HttpServletRequest request) throws SQLException {
			UserDao dao = new UserDao();
			DeleteForm form = (DeleteForm) _form;
			dao.doDelete(form);
			return mapping.findForward("delete");
		}
	}

