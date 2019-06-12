<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<% 

Connection conn = null;
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://mysql.cs.bangor.ac.uk/eeu689";
String user = "eeu689";
String pass = "lambord97";
Statement st = null;
ResultSet qrst;
ResultSet rs = null;


Class.forName(driver);
conn = DriverManager.getConnection(url,user,pass);

st = conn.createStatement();
rs = st.executeQuery("select * from Questions");
int i = 0;

while(rs.next()) {
  
%>
    <br>
    <br/>
    <center>

    <table  width="500px" cellspacing="0" cellpadding="0">
        
        <tr>
        <td width="100%">

        <form method="post" action="ScoreServlet">

        <h2 align="center"><font color="red">Academi Gymreag quiz</font></h2>

        <b>Select Correct Answer</b>
        <table border="0" width="500px" cellspacing="2" cellpadding="4">
        <tr>

        <td width="50%"> Question:</td>
        <input type="hidden" name="CorrectAns" value="<%=rs.getString("CorrectAns")%>"/>
        <tr>
            <textarea rows = "1" cols = "50" name = "question"><%=rs.getString("Question")%></textarea>

        </tr>
        <td>

        1: <input type="radio" name="a" value= "<%=rs.getString("Ans1")%>" /></td>
        <td><%= rs.getString("Ans1") %></td></tr> 
        <tr>
        <td>
        2: <input type="radio" name="a" value="<%=rs.getString("Ans2")%>" /></td>
        <td><%= rs.getString("Ans2") %></td></tr>

        <tr>
        <td>
        3: <input type="radio" name="a" value="<%=rs.getString("Ans3")%>" /></td>
        <td><%= rs.getString("Ans3") %> </td></tr>

        <tr>
        <td>
        4: <input type="radio" name="a" value="<%=rs.getString("Ans4")%>" /> </td>
        <td> <%= rs.getString("Ans4") %> </td></tr>
        <tr>
        <td>
        <center>
            
    </table>
        <% i++;}

%>
        <input type="submit" value="Submit" name="submit"  ></center></td></tr>
    </form>
    </td>
    </tr>
    </table>
    </center>
</body>


</html>



