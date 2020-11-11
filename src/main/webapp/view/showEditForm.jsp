<%--
  Created by IntelliJ IDEA.
  User: adminn
  Date: 11/11/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${message != null}">
    <span>${message}</span>
</c:if>

<c:if test="${message == null}">
<div class="container">
    <h2>Edit Product</h2>
    <form action="/update-product?productid=${product.getProductID()}" method="post">
        <input type="text" class="form-control" name="productid" value="${product.getProductID()}" hidden>
        <div class="form-group">
            <label for="email">Name</label>
            <input type="text" class="form-control" id="email" name="name" value="${product.getProductName()}">
        </div>
        <div class="form-group">
            <label for="pwd">Price</label>
            <input type="text" class="form-control" id="pwd"  name="price" value="${product.getProductPrice()}">
        </div>
        <div class="form-group">
            <label for="pwd">Quantity</label>
            <input type="text" class="form-control" name="quantity" value="${product.getProductQuantity()}">
        </div>
        <div class="form-group">
            <label for="pwd">Color</label>
            <input type="text" class="form-control" name="color" value="${product.getProductColor()}">
        </div>
        <div class="form-group">
            <label for="pwd">Description</label>
            <input type="text" class="form-control" name="description" value="${product.getProductDescription()}">
        </div>
        <div class="form-group">
            <label for="pwd">Category</label>
            <input type="text" class="form-control" name="category" value="${product.getCategoryName()}">
        </div>

        <input type="submit" class="btn btn-default" value="Update">

        <input type="submit" class="btn btn-default" value="Back">

    </form>
</div>
</c:if>
</body>
</html>
