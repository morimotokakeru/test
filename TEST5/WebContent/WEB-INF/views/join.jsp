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
<script type="text/javascript">
	function checkValue() {
		if (!document.insertInfo.firstName.value) {
			alert("苗字を入力してください。")
			return false;
		}
		if (!document.insertInfo.lastName.value) {
			alert("名前を入力してください。")
			return false;
		}
		if (!document.insertInfo.email.value) {
			alert("メールを入力してください。")
			return false;
		}
		if (!document.insertInfo.password1.value) {
			alert("パスワードを入力してください。")
			return false;
		}
		if (document.insertInfo.password1.value != document.insertInfo.password2.value) {
			alert("パスワード同じ様に入力してください。");
			return false;
		}
	}
	function goLoginForm() {

		location.href = "login.do";
	}
</script>
</head>
<body>
	<form action="insert.do" name="insertInfo"
		onsubmit="return checkValue()">
		<table>
			<tr>
				<td>苗字</td>
				<td><input type="text" name="firstName" maxlength="50" /></td>
			</tr>
			<tr>
				<td>名前</td>
				<td><input type="text" name="lastName" maxlength="50" /></td>
			</tr>
			<tr>
				<td>メール</td>
				<td><input type="text" name="email" maxlength="50" /></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="password1" maxlength="50" /></td>
			</tr>
			<tr>
				<td>パスワード確認</td>
				<td><input type="password" name="password2" maxlength="50" /></td>
			</tr>
		</table>
		<input type="submit" value="登録" /> <input type="button" value="戻る"
			onClick="goLoginForm()" />
	</form>
</body>
</html>