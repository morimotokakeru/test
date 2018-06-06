<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.UserBean"%>
<%-- <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顧客一覧</title>
</head>
<body>

		<logic:iterate id="bean" name="beans">

			<div>
				<table>
					<tr>
						<th><div Align="right">会社名:</div></th>
						<br>
						<td><div Align="left">
								<bean:write name="bean" property="company" />
							</div></td>
						<th><div Align="right">苗字 :</div></th>
						<br>
						<td><div Align="left">
								<bean:write name="bean" property="firstName" />
							</div></td>
						<th><div Align="right">名前 :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="lastName" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">敬称:</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="title" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">性別 :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="sex" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">役職名 :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="positionName" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">部署名1:</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="department1" />
							</div></td>
					</tr>


					<tr>
						<th><div Align="right">部署名2:</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="department2" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">郵便番号 :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="postal" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">住所:</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="street1" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">電話番号 :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="tell" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">ファックス :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="fax" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">携帯電話 :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="mobile" />
							</div></td>
					</tr>
					<tr>
						<th><div Align="right">Eメール :</div></th>
						<td><div Align="left">
								<bean:write name="bean" property="email" />
							</div></td>
					</tr>

					<html:form action="/detail" method="GET">
						<html:hidden name="bean" property="projectCode" />
						<html:submit value="詳細表示" />
					</html:form>
					<html:form action="/delete" method="GET">
						<html:hidden name="bean" property="projectCode" />
						<html:submit value="削除" />
					</html:form>
				</table>
			</div>
			<hr>
		</logic:iterate>
	</div>
</body>
</html>