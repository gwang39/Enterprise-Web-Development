<%-- 
    Document   : index
    Created on : Jul 12, 2018, 10:49:12 PM
    Author     : guany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <meta name="viewport" content="width=device-width">

  <title>Welcome</title>

  </head>

  <body>

  <h1>Simple Form Servlet Example:</h1><br />

  Please Enter your name:<br /><br />
	<form action="MyFormServlet" method=GET>
   First name:
   <input type="TEXT" name="firstName" value="Bob">
<br />
   Last Name:
   <input type="TEXT" name="lastName" value="Evans">
<br />
<br />
<input type="SUBMIT">
</form>
</body>
</html>
