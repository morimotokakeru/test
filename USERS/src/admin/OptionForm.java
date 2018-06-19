package admin;
import org.apache.struts.action.ActionForm;

public class OptionForm extends ActionForm {

	private String title;
	private String classification1;
	private String classification2;

	private int select = 0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getClassification1() {
		return classification1;
	}

	public void setClassification1(String classification1) {
		this.classification1 = classification1;
	}

	public String getClassification2() {
		return classification2;
	}

	public void setClassification2(String classification2) {
		this.classification2 = classification2;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

}
