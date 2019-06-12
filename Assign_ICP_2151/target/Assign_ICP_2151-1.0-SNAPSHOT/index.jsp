<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academi Gymraeg</title>
</head>
<body>
    <form action="loginServlet" method="post"> <%-- Go to loginServlet when button pressed --%>
        <fieldset style="width: 300px">
            <legend> Academi Gymraeg </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="username" required="required" /></td> <%-- user name entry --%>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass" required="required" /></td> <%-- password entry --%>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td> <%-- submit button --%>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
