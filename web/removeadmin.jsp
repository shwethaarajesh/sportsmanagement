
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.servlet.http.*"%>
<%
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
ResultSet rs=null;
%>
<!DOCTYPE html>
<html>
       <head>
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

<h1>All admins</h1>
<table border="1">

<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from admin,school where school.school_id=admin.school_id;";
resultSet = statement.executeQuery(sql);
 if(!resultSet.isBeforeFirst())
    {
    %>
    <div> No admins yet </div>
    <% }
    else
{   
%>
<table border="1">
<tr>
<td>Admin id</td>
<td>Admin name</td>
<td>Admin Phone number</td>
<td>Admin email</td>
<td>Admin School id</td>
<td>Admin School name</td>
</tr>
    <%

while(resultSet.next()){  
%>

<tr>
<td><%=resultSet.getInt("admin.id") %></td>
<td><%=resultSet.getString("admin.name") %></td>
<td><%=resultSet.getString("admin.phone_no") %></td>
<td><%=resultSet.getString("admin.email") %></td>
<td><%=resultSet.getString("admin.school_id") %></td>
<td><%=resultSet.getString("school.name") %></td>
</tr>
<%

    }}
connection.close();

} catch (Exception e) {

e.printStackTrace();
}
%>
</table>
<h1>Remove admin</h1>
        <h3>Enter details</h3>
        <form action="removeadmin" method="post">
            <div>Admin id</div>
            <input type="number" name="aid" placeholder="Admin id">
            <input type="submit" value="Remove admin">
        </form>
</body>
</html>