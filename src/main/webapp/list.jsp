<%@ page import="com.example.servletjsp15.Model.Reciept" %>
<%@ page import="java.util.List" %>
<%--  Created by IntelliJ IDEA.
  User: mac
  Date: 22/03/2023
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Purchases</title>
</head>
<body>
<%
    //TODO: COMMENT ON ALL REMAINING LINES
    List<Reciept> listOfReceipt = (List<Reciept>)request.getAttribute("listOfReceipt");
    if (listOfReceipt!=null){
        %>


<table>
    <th>ID</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Quantity</th>

    <%
        for (Reciept reciept : listOfReceipt)
        {
%>


        <tr>

            <td><% out.print(reciept.getId());%></td>
        <td><% out.print(reciept.getProduct_name());%></td>
        <td><% out.print(reciept.getPrice());%></td>
        <td><% out.print(reciept.getQuantity());%></td>

        </tr>

    <%
        }
    %>
</table>
    <% }
%>
</body>
</html>