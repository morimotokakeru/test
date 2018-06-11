
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
<title>Insert title here</title>
</head>
<body>
<html:form>
	<table border="10" summary="hahahaha">
	<caption>顧客一覧</caption>
	
	<thead>
	<tr>
	<th>会社名</th>
	<th>部署名</th>
	<th>部署名</th>
	<th>役職名</th>
	<th>氏名</th>
	<th>郵便番号</th>
	<th>住所</th>
	<th>TELL</th>
	<th>FAX</th>
	<th>MOBILE</th>
	<th>E-mail</th>	
	<th>性別</th>
	<th>☆彡</th>
	</tr>
	</thead>
	<tbody>
	

	<tr>
	<td><bean:write name="bean" property="company" /></td>
	<td><bean:write name="bean" property="positionName" /></td>
	<td><bean:write name="bean" property="department1"/></td>
	<td><bean:write name="bean" property ="department2"/></td>
	<td><bean:write name="bean" property="firstName" />
		<bean:write name="bean" property="lastName" />
		<bean:write name="bean" property="title" /></td>
	<td><bean:write name="bean" property="postal"/></td>
	<td><bean:write name="bean" property="street1"/></td>
	<td><bean:write name="bean" property="tell"/></td>
	<td><bean:write name="bean" property="fax"/></td>
	<td><bean:write name="bean" property="mobile"/></td>
	<td><bean:write name="bean" property="email"/></td>
	<td><bean:write name="bean" property="mobile" /></td>
	<td><bean:write name="bean" property="sex" /></td>
	

	</tr>
			
		
		
		
		</tbody>
		</table>
		</html:form>
		

</body>
</html>