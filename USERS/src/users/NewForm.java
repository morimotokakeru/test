package users;

import java.sql.Date;

import org.apache.struts.validator.ValidatorForm;

public class NewForm extends ValidatorForm {

	private int userId;
	private String firstName;
	private String lastName;
	private String firstNameKana;
	private String lastNameKana;
	private String title;
	private String sex;
	private String classification1;
	private String classification2;
	private String company;
	private String department1;
	private String department2;
	private String positionName;
	private String postal;
	private String street1;
	private String street2;
	private String tell;
	private String fax;
	private String mobile;
	private String email;
	private String upDate;
	private Date changeDate;
	private String comment1;

	private int select = 0;
	private String zip01;
	private String pref01;
	private String addr01;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getLastNameKana() {
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment1() {
		return department1;
	}
	public void setDepartment1(String department1) {
		this.department1 = department1;
	}
	public String getDepartment2() {
		return department2;
	}
	public void setDepartment2(String department2) {
		this.department2 = department2;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}

	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getZip01() {
		return zip01;
	}
	public void setZip01(String zip01) {
		this.postal = zip01;
		this.zip01 = zip01;
	}
	public String getPref01() {
		return pref01;
	}
	public void setPref01(String pref01) {
		this.street1 = pref01;
		this.pref01 = pref01;
	}
	public String getAddr01() {
		return addr01;
	}
	public void setAddr01(String addr01) {
		this.street2 = addr01;
		this.addr01 = addr01;
	}

}
