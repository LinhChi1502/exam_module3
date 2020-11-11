<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adminn
  Date: 11/11/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${message != null}">
    <span>${message}</span>
</c:if>


<div class="container">
    <h2>Add new product</h2>
    <form  action="/add-pro" method="post">
        <div class="form-group">
            <label for="email">Name</label>
            <input type="text" class="form-control" id="email" name="name">
        </div>
        <div class="form-group">
            <label for="pwd">Price</label>
            <input type="text" class="form-control" id="pwd"  name="price">
        </div>
        <div class="form-group">
            <label for="pwd">Quantity</label>
            <input type="text" class="form-control" name="quantity">
        </div>
        <div class="form-group">
            <label for="pwd">Color</label>
            <input type="text" class="form-control" name="color">
        </div>
        <div class="form-group">
            <label for="pwd">Description</label>
            <input type="text" class="form-control" name="description">
        </div>
        <div class="form-group">
            <label for="pwd">Category</label>
            <input type="text" class="form-control" name="category">
        </div>

        <input type="submit" class="btn btn-default" value="Create">
        <a href="/product">Back</a>
    </form>
</div>
</body>
</html>
