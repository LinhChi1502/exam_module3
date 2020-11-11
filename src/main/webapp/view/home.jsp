<%--
  Created by IntelliJ IDEA.
  User: adminn
  Date: 11/11/2020
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
</head>
<body>
<header>
    <div class="header">

    </div>
</header>
<nav>
    <div class="nav">

    </div>
</nav>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-hover table-sortable" id="tab_logic" style="border: none">
                <tr>
                    <td colspan="4"><a href="/add-pro"><input type="submit" value="Add new product"></a></td>
                    <form action="/search">

                        <td colspan="4"><input type="text" name="search" placeholder="search"><button>Search</button></td>
                    </form>
                </tr>

                <tr>
                    <td colspan="8">Product List</td>
                </tr>

                <tr >
                    <td class="text-center">
                        STT
                    </td>
                    <td class="text-center">
                        Product Name
                    </td>
                    <td class="text-center">
                        Price
                    </td>
                    <td class="text-center">
                        Quantity
                    </td>
                    <td class="text-center">
                        Color
                    </td>
                    <td class="text-center">
                        Category
                    </td>
                    <td class="text-center" colspan="2">
                        Action
                    </td>
                </tr>


<%--bat dau foreach--%>
                <c:forEach items="${products}" var="product">
                <tr id='addr0' data-id="0">
                    <td data-name="name">${product.getProductID()}</td>
                    <td data-name="name">${product.getProductName()}</td>
                    <td data-name="name">${product.getProductName()}</td>
                    <td data-name="name">${product.getProductPrice()}</td>
                    <td data-name="name">${product.getProductColor()}</td>
                    <td data-name="name">${product.getCategoryName()}</td>

                    <td data-name="name">
                        <a href="/edit?productid=${product.getProductID()}"><input type="submit" value="edit"></a>
                    </td>

                    <td data-name="name">
                        <a href="/delete?productid=${product.getProductID()}"><input type="submit" value="delete"></a>
                    </td>
                </tr>
                </c:forEach>
<%--                ket thuc foreach--%>
            </table>
        </div>
    </div>
</div>
</body>
</html>
