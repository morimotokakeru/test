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
<title>削除確認</title>
</head>
<body>

<table border="10" summary="hahahaha">
	<caption>削除情報確認</caption>

		<logic:iterate id="bean" name="bean">
		
			<thead>
				<tr>
					<th>会社名</th>
					<td><bean:write name="bean" property="company" /></td>
					<th>氏名</th>
					<td><bean:write name="bean" property="firstName" />
					    <bean:write name="bean" property="lastName" />
					    <bean:write name="bean"
							property="title" /></td>
				</tr>
				<tr>
					<th>役職名</th>
					<td><bean:write name="bean" property="positionName" /></td>
					<th>フリガナ</th>
					<td><bean:write name="bean" property="firstNameKana" /> <bean:write
							name="bean" property="lastNameKana" /></td>
				</tr>
				<tr>
					<th>部署名</th>
					<td><bean:write name="bean" property="department1" /></td>
					<th>郵便番号</th>
					<td><bean:write name="bean" property="postal" /></td>
				</tr>
				<tr>
					<th>部署名</th>
					<td><bean:write name="bean" property="department2" /></td>
					<th>住所</th>
					<td><bean:write name="bean" property="street1" /> <bean:write
							name="bean" property="street2" /></td>
				</tr>
				<tr>
					<th>分類1</th>
					<td><bean:write name="bean" property="classification1" /></td>
					<th>分類2</th>
					<td><bean:write name="bean" property="classification2" /></td>
				<tr>
					<th>TELL</th>
					<td><bean:write name="bean" property="tell" /></td>
					<th>FAX</th>
					<td><bean:write name="bean" property="fax" /></td>
				</tr>
				<tr>

					<th>MOBILE</th>
					<td><bean:write name="bean" property="mobile" /></td>
					<th>E-mail</th>
					<td><bean:write name="bean" property="email" /></td>
				</tr>
				<tr>

					<th>性別</th>
					<td><bean:write name="bean" property="sex" /></td>
					
					<th>
				</tr>
				</thead>
	

			</logic:iterate>
			
</table>	
この内容を削除しますか？
				<html:form action="/users/delete" method="POST">
				<html:hidden name ="bean" property="userId"/>
				<html:submit value="削除します"></html:submit>
			</html:form>

			<html:form action="/userdetail" method="GET"> 
				<html:hidden name ="bean" property="userId"/>
 				<html:submit value="戻る" />
			</html:form>
			<html:form action="/users" method="GET"> 
 				<html:submit value="TOP" />
			</html:form>

</body>
</html>