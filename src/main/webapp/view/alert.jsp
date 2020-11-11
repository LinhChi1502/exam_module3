<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adminn
  Date: 11/11/2020
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <h3>Are you sure?</h3>
    <a href="/delete-pro?productid=${product.getProductID()}"><button>Yes</button></a>
    <a href="/product"><button>Cancel</button></a>




</body>
</html>
