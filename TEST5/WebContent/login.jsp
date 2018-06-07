<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="color: red">
		<html:errors />
	</div>
	<form action = "/login" method="POST">
		Email : <input type="text" name="LoginForm" />
		<br>
		Password : <input type="password" name="LoginForm" />
		<br>
		<input type="submit" value="Login" name="Login" />
		<input type="submit" value="Join" name="Join" />
	</form>
	
	<html:form action="/login">
		Email : <html:text name="LoginForm" property="userName" />
		<br>
		Password : <html:password name="LoginForm" property="password" />
		<br>
		<html:submit value="Login2" />
	</html:form>
	
<%-- 	
	<html:form action="/join">
		<html:submit value="Join" />
	</html:form>
	 --%>

</body>
</html>