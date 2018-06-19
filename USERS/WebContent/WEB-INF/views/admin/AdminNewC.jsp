<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.UserBean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新確認画面</title>
</head>
<body>
	<html:form action="/users/new" method="POST">
		<table>
			<tr>
				<th>(フリガナ)：</th>
				<td><bean:write name="form" property="firstNameKana" /><bean:write name="form" property="lastNameKana" /></td>
			</tr>
			<tr>
				<th>苗字・名前：</th>
				<td><bean:write name="form" property="firstName" />
					<bean:write name="form" property="lastName" />
					<bean:write name="form" property="title" /></td>
			</tr>
			<tr>
				<th>性別：</th>
				<td><bean:write name="form" property="sex" />
			</tr>
			<tr>
				<th>分類1：</th>
				<td><bean:write name="form" property="classification1" /></td>
				<th>分類2：</th>
				<td><bean:write name="form" property="classification2" /></td>
			</tr>
			<tr>
				<th>会社名：</th>
				<td><bean:write name="form" property="company" /></td>
			</tr>
			<tr>
				<th>部署名1：</th>
				<td><bean:write name="form" property="department1" /></td>
				<th>部署名2：</th>
				<td><bean:write name="form" property="department2" /></td>
			</tr>
			<tr>
				<th>役職名：</th>
				<td><bean:write name="form" property="positionName" /></td>
			</tr>
			<tr>
				<th>郵便番号：</th>
				<td><bean:write name="form" property="postal" /></td>
			</tr>
			<tr>
				<th>住所：</th>
				<td><bean:write name="form" property="street1" />
					<bean:write name="form" property="street2" /></td>
			</tr>
			<tr>
				<th>電話番号：</th>
				<td><bean:write name="form" property="tell" /></td>
				<th>FAX：</th>
				<td><bean:write name="form" property="fax" /></td>
			</tr>
			<tr>
				<th>携帯番号：</th>
				<td><bean:write name="form" property="mobile" /></td>
				<th>Email：</th>
				<td><bean:write name="form" property="email" /></td>
			</tr>
			<tr>
				<th>名刺交換日：</th>
				<td><bean:write name="form" property="changeDate" /></td>
			</tr>
			<tr>
				<th>コメント欄：</th>
				<td><bean:write name="form" property="comment1" /></td>
			</tr>
		</table>
		<html:hidden property="firstName" value="${form.firstName }" />
		<html:hidden property="lastName" value="${form.lastName }" />
		<html:hidden property="firstNameKana" value="${form.firstNameKana }" />
		<html:hidden property="lastNameKana" value="${form.lastNameKana }" />
		<html:hidden property="title" value="${form.title }" />
		<html:hidden property="sex" value="${form.sex }" />
		<html:hidden property="classification1" value="${form.classification1 }" />
		<html:hidden property="classification2" value="${form.classification2 }" />
		<html:hidden property="company" value="${form.company }" />
		<html:hidden property="department1" value="${form.department1 }" />
		<html:hidden property="department2" value="${form.department2 }" />
		<html:hidden property="positionName" value="${form.positionName }" />
		<html:hidden property="postal" value="${form.postal }" />
		<html:hidden property="street1" value="${form.street1 }" />
		<html:hidden property="street2" value="${form.street2 }" />
		<html:hidden property="tell" value="${form.tell }" />
		<html:hidden property="fax" value="${form.fax }" />
		<html:hidden property="mobile" value="${form.mobile }" />
		<html:hidden property="email" value="${form.email }" />
		<html:hidden property="changeDate" value="${form.changeDate }" />
		<html:hidden property="comment1" value="${form.comment1 }" />
		<html:submit value="登録" />
	</html:form>
	<html:form action="/users/new" method="GET">
		<html:submit value="戻る"></html:submit>
	</html:form>
</body>
</html>