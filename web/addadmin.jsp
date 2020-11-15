<%-- 
    Document   : removeclub
    Created on : 14 Nov, 2020, 11:39:15 AM
    Author     : shwet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.servlet.http.*"%>
<%
int sid=Integer.parseInt(session.getAttribute("sid").toString());
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/sports_management?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
String database = "sports_management";
String userid = "root";
String password = "mysoul2000";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>   <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
body {
  background-image: url('bg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  width: 300px;
    margin: 0 auto;
}
h1 {
    color : #000000;
    text-align : center;
    font-family: "SIMPSON";
}
.center {
  margin-left: auto;
  margin-right: auto;
}
.container {
  max-width: 1000px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 200%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

form {
    width: 300px;
    margin: 0 auto;
}
.content {
  max-width: 500px;
  margin: auto;
}
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
input[type=number] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
input,select,li {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
</style>
    </head>

    <body>
        
<h1>All Schools</h1>
<table border="1">
<tr>
<td>School id</td>
<td>School name</td>
<td>School Email</td>
<td>School Phone number</td>
<td>Location</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from school;";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
   
    
%>

<tr>
<td><%=resultSet.getString("school_id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("phone_no") %></td>
<td><%=resultSet.getString("location") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {

e.printStackTrace();
}
%>
</table>
        <h1>Add admin</h1>
        <h3>Enter details</h3>
        <form action="addadmin" method="post">
            <div>School id</div>
            <input type="number" name="sid" placeholder="School id">
            <div>Admin name</div>
            <input type="text" name="name" placeholder="Name">
            <div>Phone number</div>
            <input type="text" name="ph" placeholder="Phone number">
            <div>Email address</div>
            <input type="text" name="email" placeholder="Email">
            <div>Password</div>
            <input type="password" name="pass" placeholder="password">
            <input type="submit" value="Add Admin">
        </form>
    </body>
</html>
