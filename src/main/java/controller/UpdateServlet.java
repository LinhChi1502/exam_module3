package controller;

import dao.IProductDao;
import dao.ProductDaoImpl;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update-product")
public class UpdateServlet extends HttpServlet {

    IProductDao productDao = new ProductDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String producName = request.getParameter("name");
        Double productPrice = Double.parseDouble(request.getParameter("price"));
        int productQuantity = Integer.parseInt(request.getParameter("quantity"));
        String productColor = request.getParameter("color");
        String productDescription = request.getParameter("description");
        String categoryName = request.getParameter("category");

        int productID = Integer.parseInt(request.getParameter("productid"));
        Product product = new Product(productID,producName,productPrice,productQuantity,productColor,productDescription,categoryName);
        productDao.update(product);
        List<Product> products = productDao.findAll();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
