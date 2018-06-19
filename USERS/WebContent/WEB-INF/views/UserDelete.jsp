<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退会</title>
<script type="text/javascript">
	function checkValue(){
		if(!document.deleteform.password.value){
			alert("パスワードを入力してください")
			return false;
		}
	}
</script>
</head>
<body>
	<br><br>
	<b><font size="6" color="gray">退会しますか。</font></b>
	<br><br><br>
		<form name = "deleteform" method= "post" action="delete.do" onsubmit="return checkValue()">
			<table>
				<tr>
					<td bgcolor="skyblue">パスワード</td>
					<td><input type="password" name="password" maxlength="50"></td>
				</tr>
			</table>
			
			<br>
			<input type="button" value="戻る" onclick=""/>
			<input type="submit" value="退会"/>
		</form>
</body>
</html>