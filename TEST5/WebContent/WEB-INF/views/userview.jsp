<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.UserBean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>

	<h1>★顧客検索一覧画面</h1>
	<%-- 
	<h3>
		Welcome to
		<bean:write scope="session" name="user" property="firstName" />
		様!!
	</h3> --%>
	<%-- <html:form action="/logout" method="GET">
		<html:submit value="ログアウト"></html:submit>
	</html:form>
	<html:form action="/userdetail" method="GET">
		<html:submit value="会員様詳細"></html:submit>
	</html:form>
 --%>
	<h1>検索</h1>
	<%-- <html:form action="/view" method="GET"> --%>
	<html:form action="/users" method="GET">
		<table border="3" summary="hahahaha">

			<thead>
				<tr>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th>会社名</th>
					<td><html:text property="company" /></td>
				</tr>
				<tr>
					<th>顧客苗字</th>
					<td><html:text property="firstName" /></td>
				</tr>
				<tr>
					<th>顧客名前</th>
					<td><html:text property="lastName" /></td>
				</tr>
				<tr>
					<th>役職名</th>
					<td><html:text property="positionName" /></td>
				</tr>
				<tr>
					<th>分類</th>
					<td><html:text property="department1" /></td>
				</tr>
				<tr>
					<th>分類</th>
					<td><html:text property="department2" /></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><html:text property="street1" /></td>
				</tr>



			</tbody>
		</table>
		<html:submit value="検索" />
	</html:form>

	<%-- <html:form>
		<p>
			登録日: 古い順
			<html:radio property="razio" value="1" />

			新しい順
			<html:radio property="razio" value="2" />
		</p>
		

		
	</html:form>


	<hr size="10">
	<html:form action="/insert" method="GET">
		<html:submit value="新規登録" />
	</html:form>	 --%>
	<b>test</b>

	<html:form>
		<table border="10" summary="hahahaha">
			<caption>顧客一覧</caption>

			<thead>
				<tr>
					<th>会社名</th>
					<th>役職名</th>
					<th>氏名</th>

					<th>性別</th>
					<th>☆彡</th>
				</tr>
			</thead>
			<tbody>

				<logic:iterate id="bean" name="beans">
					<html:form action="/userDetail" method="GET">
						<tr>
							<td><bean:write name="bean" property="company" /></td>
							<td><bean:write name="bean" property="positionName" /></td>
							<td><bean:write name="bean" property="firstName" />
							 	<bean:write name="bean" property="lastName" /> 
								<bean:write name="bean" property="title" /></td>
							<td><bean:write name="bean" property="sex" /></td>
							<td><html:hidden name="bean" property="userId" />
							 	<html:submit value="詳細表示" /></td>
						</tr>
					</html:form>
				</logic:iterate>

			</tbody>
		</table>
	</html:form>



</body>
</html>