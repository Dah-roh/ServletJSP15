<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 20/03/2023
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sales Register</title>
</head>
<body>
<% if(request.getAttribute("username")!=null)
{
%>
<h1>${username}</h1>

<% } %>

<form action="hello-servlet" method="post">

    Product Name: <input name="product_name" type="text">
    Price: <input name="price" type="text">
    Quantity: <input name="quantity" type="text">
    <button>Submit</button>
</form>

</body>
</html>
