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
<title>顧客情報更新</title>
</head>
<body>
	<h1>顧客情報更新</h1>
	<logic:iterate id="bean" name="beans">
		<html:form action="/users/update" method="POST">
			<table>
				<tr>
					<th>苗字</th>
					<td><html:text name="bean" property="firstName"></html:text></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><html:text name="bean" property="lastName"></html:text></td>
				</tr>
				<tr>
					<th>敬称</th>
					<td><html:select name="bean" property="title">
							<logic:iterate id="list" name="titleList">
								<html:option value="${list.titleName }" />
							</logic:iterate>
						</html:select></td>
				</tr>
				<tr>
					<th>分類1</th>
					<td><html:text name="bean" property="classification1"></html:text></td>
				</tr>
				<tr>
					<th>分類2</th>
					<td><html:text name="bean" property="classification2"></html:text></td>
				</tr>
				<tr>
					<th>会社名</th>
					<td><html:text name="bean" property="company"></html:text></td>
				</tr>
				<tr>
					<th>部署名1</th>
					<td><html:text name="bean" property="department1"></html:text></td>
				</tr>
				<tr>
					<th>部署名2</th>
					<td><html:text name="bean" property="department2"></html:text></td>
				</tr>
				<tr>
					<th>役職名</th>
					<td><html:text name="bean" property="positionName"></html:text></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><html:text name="bean" property="postal"></html:text></td>
				</tr>
				<tr>
					<th>住所1</th>
					<td><html:text name="bean" property="street1"></html:text></td>
				</tr>
				<tr>
					<th>住所2</th>
					<td><html:text name="bean" property="street2"></html:text></td>
				</tr>
				<tr>
					<th>FAX</th>
					<td><html:text name="bean" property="fax"></html:text></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><html:text name="bean" property="tell"></html:text></td>
				</tr>
				<tr>
					<th>携帯番号</th>
					<td><html:text name="bean" property="mobile"></html:text></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><html:text name="bean" property="email"></html:text></td>
				</tr>
				<tr>
					<th>コメント欄</th>
					<td>
						<html:textarea name="bean" property="company" >${bean.company}</html:textarea>
					</td>
				</tr>
				<%-- <html:submit value="更新内容確認" /> --%>
			</table>
		</html:form>
	</logic:iterate>
</body>
</html>