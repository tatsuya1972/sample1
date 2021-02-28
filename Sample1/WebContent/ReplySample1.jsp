<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="param1" class="org.sample.SessionObject" scope="session" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="WebSphereLiberty.jpg" width="300">

<h1>Reply web page by Sample1 Servlet</h1>

HostName: <%= request.getAttribute("Hostname") %><br>
IP address: <%= request.getAttribute("IPaddr") %><br>
<br>
Session Object (param1) = <jsp:getProperty name="param1" property="param1" /><br>
<p>パラメータ付きリンク</p>
Set param1 : <a href="?param1=LIBERTY">set param1=LIBERTY</a><br>
Set param1 : <a href="?param1=WebSphere">set param1=WebSphere</a><br>
Get param1 : <a href="Sample1">パラメータなしは、保存した値の表示</a><br>

<p>パラメータでGETのためアルファベットのみ対応</p>
<FORM ACTION='Sample1' METHOD='GET'>
<INPUT TYPE='text' NAME='param1' VALUE=''>
<INPUT TYPE='submit' VALUE='ENTER'>
</FORM>

<p>サーブレットで結果を返す</p>
<a href="ViewSessionObject">ViewSessionObject</a>


</body>
</html>