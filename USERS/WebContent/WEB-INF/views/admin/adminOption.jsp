 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.UserBean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PullDownInsert</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/users.css"type="text/css"/>
</head>
<body>
	<h1>PullDown項目追加</h1>
	<html:form action="/option" method="POST">
		<table>
			<%-- <tr>
				<html:select property="title">
					<logic:iterate id="list" name="pullDownListT">
						<html:option value="${list.title }" />
					</logic:iterate>
				</html:select>
			</tr> --%>
			<tr>
				<th>敬称</th>
				<td>
					<html:text property="title"></html:text>
				</td>
			</tr>
		</table>
		<html:hidden property="select" value="1"/>
		<html:submit value="敬称[追加]"/>
	</html:form>

	<html:form action="/option" method="POST">
		<table>
			<%-- <tr>
				<html:select property="pullDownListC1">
					<logic:iterate id="list" name="pullDownListC1">
						<html:option value="${list.classification1 }" />
					</logic:iterate>
				</html:select>
			</tr> --%>
			<tr>
				<th>分類1</th>
				<td>
					<html:text property="classification1"></html:text>
				</td>
			</tr>
		</table>
		<html:hidden property="select" value="2"/>
		<html:submit value="分類1[追加]"/>
	</html:form>

	<html:form action="/option" method="POST">
		<table>
			<%-- <tr>
				<html:select property="pullDownListC2">
					<logic:iterate id="list" name="pullDownListC2">
						<html:option value="${list.classification2 }" />
					</logic:iterate>
				</html:select>
			</tr> --%>
			<tr>
				<th>分類2</th>
				<td>
					<html:text property="classification2"></html:text>
				</td>
			</tr>
		</table>
		<html:hidden property="select" value="3"/>
		<html:submit value="分類2[追加]"/>
	</html:form>
</body>
</html>