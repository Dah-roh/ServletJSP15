<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--link to HelloServlet class. NOTE: GET METHODS ARE HANDLED BY doGet method overriden from the HttpServlet class--%>
<a href=${pageContext.getRequest().getContextPath()}/hello-servlet>Hello Servlet</a>
<br/>

<%--creating a jsp scriptlet to handle if condition for our product request attribute
coming from client's input in register.jsp and stored in request attribute
in HelloServlet doPost method.
--%>
<% if(request.getAttribute("product")!=null)
{
%>

<%--if condition returns true then the text below should display--%>
<h1>This is Gadibia's product: ${product}</h1>


<%-- Closing our if-condition statement below --%>
<% } %>

</body>
</html>