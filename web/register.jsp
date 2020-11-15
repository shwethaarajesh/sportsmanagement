<%-- 
    Document   : register
    Created on : 12 Nov, 2020, 5:34:07 PM
    Author     : shwet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
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
%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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

    <%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select name from school ;";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
    <body>
        <h1>REGISTRATION</h1>
        <h3>Enter details</h3>
        <form action="register" method="post">
            <div>Roll Number</div>
            <input type="number" name="rno" placeholder="Roll number">
            <div>Student name</div>
            <input type="text" name="name" placeholder="Name">
            <div>Phone Number</div>
            <input type="text" name="phno" placeholder="Phone number">
            <div>Email Address</div>
            <input type="email" name="email" placeholder="Email address">
            <div>Age</div>
            <input type="number" name="age" placeholder="age">
            <div>School Year</div>
            <input type="number" name="year" placeholder="Year of Study">
            <div>Section</div>
            <input type="text" name="section" placeholder="section">
            <div>School</div>
            <select name="school">
        <%  while(resultSet.next()){ %>
            <option><%= resultSet.getString("name")%></option>
        <% } %>
        </select>
 <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
           <div>Enter password</div>
            <input type="password" name="pass" placeholder="Password">
            <div>Gender</div>
            <select name="gender">
                <option>Female</option>
                <option>Male</option>
                <option>Other</option></select>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select name from sports_club ;";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<div>Sport interested in </div>           
<select name="club">
        <%  while(resultSet.next()){ %>
            <option><%= resultSet.getString("name")%></option>
        <% } %>
        </select>
            
 <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
        <input type="submit" value="Register now">
        </form>
    </body>
</html>
