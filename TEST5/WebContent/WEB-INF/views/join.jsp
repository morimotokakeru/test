<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<html:form action="/insert">
		<table>
			<tr>
				<td>苗字</td>
				<td><html:text property="firstName" /></td>
			</tr>
			<tr>
				<td>名前</td>
				<td><html:text property="lastName" /></td>
			</tr>
			<tr>
				<td>メール</td>
				<td><html:text property="email" /></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><html:password property="password1" /></td>
			</tr>
			<tr>
				<td>パスワード確認</td>
				<td><html:password property="password2" /></td>
			</tr>
		</table>
		<html:submit value="登録" />
	</html:form>
</body>
</html>