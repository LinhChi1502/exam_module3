package dao;

import jdbc.JDBCConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {

    Connection connection = JDBCConnection.getConnection();
    private static final String FIND_ALL_PRODUCTS = "select * from products join category c on c.categoryID = products.categoryID ";
    private static final String ADD_PRO = "insert in products (productName, productPrice, productQuantity, productColor, productDescription, categoryID) value (?,?,?,?,?,?) ";
    private static final String FIND_CATEGORYNAME = "select categoryID from category where categoryName = ?";
    private static final String SEARCH_PRO_BY_NAME = "select * from products join category c on c.categoryID = products.categoryID where productName like ?";
    private static final String FIND_BY_ID = "select * from products join category c on c.categoryID = products.categoryID where productId=?";
    private static final String UPADTE_PRO = "update products set productName = ?, productPrice = ?, productQuantity = ?, productColor = ?, productDescription = ?, categoryID= ? where productId = ?";
    private static final String DELETE_PRO = "delete from products where productId = ?";

    @Override
    public List<Product> findAll() {
        List<Product> products = null;

        try {
            products = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_PRODUCTS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productId");
                String productName = rs.getString("productName");
                double productPrice = rs.getDouble("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                String productColor = rs.getString("productColor");
                String productDescription = rs.getString("productDescription");
                int categoryID = rs.getInt("products.categoryID");
                String categoryName = rs.getString("categoryName");

                Product product = new Product(productID, productName, productPrice, productQuantity, productColor,
                        productDescription, categoryID, categoryName);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public void add(Product product) {
        int categoryID = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_CATEGORYNAME);
            ps.setString(1, product.getCategoryName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(ADD_PRO);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getProductPrice());
            ps.setInt(3, product.getProductQuantity());
            ps.setString(4, product.getProductColor());
            ps.setString(5, product.getProductDescription());
            ps.setInt(6, categoryID);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = null;


        try {
            products = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(SEARCH_PRO_BY_NAME);
            ps.setString(1, '%' + name + '%');
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productId");
                double productPrice = rs.getDouble("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                String productColor = rs.getString("productColor");
                String productDescription = rs.getString("productDescription");
                int categoryID = rs.getInt("products.categoryID");
                String categoryName = rs.getString("categoryName");
                Product product = new Product(productID, name, productPrice, productQuantity, productColor,
                        productDescription, categoryID, categoryName);
                products.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findProByID(int productID) {
        Product product = null;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("productName");
                double productPrice = rs.getDouble("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                String productColor = rs.getString("productColor");
                String productDescription = rs.getString("productDescription");
                int categoryID = rs.getInt("products.categoryID");
                String categoryName = rs.getString("categoryName");

                product = new Product(productID, productName, productPrice, productQuantity, productColor,
                        productDescription, categoryID, categoryName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {

        int categoryID = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_CATEGORYNAME);
            String categoryName = product.getCategoryName();
            ps.setString(1,categoryName );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(UPADTE_PRO);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getProductPrice());
            ps.setInt(3, product.getProductQuantity());
            ps.setString(4, product.getProductColor());
            ps.setString(5, product.getProductDescription());
            ps.setInt(6, categoryID);
            ps.setInt(7, product.getProductID());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int proId) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_PRO);
            ps.setInt(1, proId);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

