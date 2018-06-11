package join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.JoinDao;

public class JoinAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		JoinActionForm insertForm = (JoinActionForm)form;
		JoinDao dao = JoinDao.getInstance();
		
		
		
		// TODO Auto-generated method stub
		return super.execute(mapping, form, request, response);
	}
	
}
