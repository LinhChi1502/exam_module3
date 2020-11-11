package dao;

import model.Product;

import java.util.List;

public interface IProductDao {
    List<Product> findAll();

    void add(Product product);

    List<Product> search(String name);

    Product findProByID(int productID);

    void update(Product product);

    void delete(int proId);
}
