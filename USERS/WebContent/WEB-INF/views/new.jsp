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
<title>新規顧客登録</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/users.css"type="text/css"/>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
</head>
<body>
	<h1>新規顧客登録</h1>
		<html:form action="/users/new" method="POST">
			<table>
				<tr>
					<th>苗字</th>
					<td><html:text property="firstName"></html:text></td>
					<th>(フリガナ)</th>
					<td><html:text property="firstNameKana"></html:text></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><html:text property="lastName"></html:text></td>
					<th>(フリガナ)</th>
					<td><html:text property="lastNameKana"></html:text></td>
				</tr>
				<tr>
					<th>敬称</th>
					<td><html:select property="title">
							<html:option value=""/>
							<logic:iterate id="list" name="pullDownListT">
								<html:option value="${list.title }" />
							</logic:iterate>
						</html:select></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><html:select property="sex">
							<html:option value=""/>
							<logic:iterate id="list" name="pullDownListS">
								<html:option value="${list.sex }" />
							</logic:iterate>
						</html:select></td>
				</tr>
				<tr>
					<th>分類1</th>
					<td><html:select property="classification1">
							<html:option value=""/>
							<logic:iterate id="list" name="pullDownListC1">
								<html:option value="${list.classification1 }" />
							</logic:iterate>
						</html:select></td>
					<th>分類2</th>
					<td><html:select property="classification2">
							<html:option value=""/>
							<logic:iterate id="list" name="pullDownListC2">
								<html:option value="${list.classification2 }" />
							</logic:iterate>
						</html:select></td>
				</tr>
				<tr>
					<th>会社名</th>
					<td><html:text property="company"></html:text></td>
				</tr>
				<tr>
					<th>部署名1</th>
					<td><html:text property="department1"></html:text></td>
					<th>部署名2</th>
					<td><html:text property="department2"></html:text></td>
				</tr>
				<tr>
					<th>役職名</th>
					<td><html:text property="positionName"></html:text></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><input type="text" name="zip01" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','pref01','addr01');"></td>
				</tr>
				<tr>
					<th>都道府県</th>
					<td><input type="text" name="pref01" size="20">
					<th>詳細住所</th>
					<td><input type="text" name="addr01" size="20"></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><html:text property="tell"></html:text></td>
					<th>FAX</th>
					<td><html:text property="fax"></html:text></td>
				</tr>
				<tr>
					<th>携帯番号</th>
					<td><html:text property="mobile"></html:text></td>
					<th>Email</th>
					<td><html:text property="email"></html:text></td>
				</tr>
				<tr>
					<th>名刺交換日</th>
					<td><html:text property="changeDate"></html:text></td>
				</tr>
				<tr>
					<th>コメント欄</th>
					<td><html:textarea property="comment1"></html:textarea>
					</td>
				</tr>
			</table>
			<html:hidden property="select" value="1"/>
			<html:submit value="登録内容確認" />
		</html:form>
	<html:form action="/users" method="GET">
		<html:submit value="戻る"/>
	</html:form>
</body>
</html>