<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>現在　ユーザー情報画面</title>
<script type="text/javascript">
	function changeForm(val){
		if(val == "-1"){
			location.href="users.do";
		}else if(val =="0"){
			location.href="info/modify.do";
		}else if(val =="1"){
			location.href="info/confirm.do";
		}
	}
</script>
</head>
<body>
	
	<table>
		<tr>
			<td>メール</td>
			<td>${info.email}</td>
		</tr>
		<tr>
			<td>苗字</td>
			<td>${info.firstName}</td>
		</tr>
		<tr>
			<td>名前</td>
			<td>${info.lastName}</td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td>セキュリティ保護のため、表示していません。</td>
		</tr>
	</table>
	
	
	<input type="button" value="戻る" onclick="changeForm(-1)"/>
	<input type="button" value="情報変更" onclick="changeForm(0)"/>
	<input type="button" value="退会" onclick="changeForm(1)"/>
	
</body>
</html>