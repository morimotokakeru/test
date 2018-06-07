package users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.UserBean;




public class UserViewAction extends Action {
	public ActionForward execute (ActionMapping mapping,ActionForm _form,HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException{
		
		UserViewForm form = (UserViewForm) _form;
		UserDao dao = new UserDao();
		List<UserBean> list = dao.getUserAll(form);
		request.setAttribute("beans",list);
		//request.setAttribute("bean", );
		return mapping.findForward("ok");
		
		
	}
	
}
