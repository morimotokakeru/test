<%@page import="dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Java Script -->
<!-- <script type="text/javascript">
	function checkValue() {
		inputForm = eval("document.LoginForm");
		if (!inputForm.email.value) {
			alert("Emailを　入力してください")
			inputForm.email.focus();
			return false;

		}
		if (!inputForm.password.value) {
			alert("passwordを　入力してください。")
			inputForm.password.focus();
			return false;
		}
	}

	function goJoinForm() {
		location.href = "JoinForm.jsp";
	}
</script> -->
</head>
<body>

	<table>
		<html:form action="/login">
			<tr>
				<td bgcolor="skyblue">Email :</td>
				<td><html:text name="LoginActionForm" property="userName"
						maxlength="100" /></td>
			</tr>
			<tr>
				<td bgcolor="skyblue">Password :</td>
				<td><html:password name="LoginActionForm" property="password"
						maxlength="100" /></td>
			</tr>
			<tr>
				<td><html:submit value="Login" /></td>
			</tr>
		</html:form>
	</table>

	<html:link action="/join">
		<html:submit value="Join" />
	</html:link>



	<%
		String msg = request.getParameter("msg");

		if (msg != null && msg.equals("0")) {
			out.println("<br>");
			out.println("<font color='red' size='5'>パスワードをご確認ください。</font>");
		} else if (msg != null && msg.equals("-1")) {
			out.println("<br>");
			out.println("<font color='red' size='5'>メールアドレスをご確認ください。</font>");
		}
	%>


	<%-- 	 <div>
		<form action="/login" name="LoginForm" method="POST" 
			onsubmit="return checkValue()">

			<table>
				<tr>
					<td bgcolor="skyblue">Email</td>
					<td><input type="text" name="email" maxlength="100"></td>
				</tr>
				<tr>
					<td bgcolor="skyblue">Password</td>
					<td><input type="password" name="password" maxlength="100"></td>
				</tr>
			</table>
			<br> <input type="submit" value="Login" /> <input type="button"
				value="会員登録" onclick="goJoinForm()" />
		</form>


		<%
			//Email, password 間違えた場合は画面にメッセージ表示
			//LoginPro.jspで　login 処理結果のメッセージ伝える。

			String msg = request.getParameter("msg");

			if (msg != null && msg.equals("0")) {
				out.print("<br>");
				out.print("<font color='red' size ='5'>パスワードをご確認ください。</font>");
			}
			if (msg != null && msg.equals("-1")) {
				out.print("<br>");
				out.print("<font color='red' size ='5'>パスワードをご確認ください。</font>");
			}
		%>
	</div>  --%>



	<%-- <div style="color: red">
		<html:errors />
	</div>
	<form action="/login" method="POST">
		Email : <input type="text" name="LoginForm" /> <br> Password : <input
			type="password" name="LoginForm" /> <br> <input type="submit"
			value="Login" name="Login" /> <input type="submit" value="Join"
			name="Join" />
	</form>
--%>




	<%-- 	
	<html:form action="/join">
		<html:submit value="Join" />
	</html:form>
	 --%>

</body>
</html>