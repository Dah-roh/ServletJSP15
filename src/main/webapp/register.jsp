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

<%--creating a jsp scriptlet to handle if condition for our username ("Gadibia") in line 19 of
 SalesRegister servlet
--%>
<% if(request.getAttribute("username")!=null)
{
%>
<h1>${username}</h1>

<% } %>

<%--link to HelloServlet class. NOTE: POST methods are handled by doPost method
overriden from the HttpServlet class--%>
<form action="hello-servlet" method="post">


    <%--Remember: input name is the same string needed to get request parameter.
    i.e request.getParameter("product_name") --%>
    Product Name: <input name="product_name" type="text">
    Price: <input name="price" type="text">
    Quantity: <input name="quantity" type="text">
    <button>Submit</button>
</form>

</body>
</html>
