package service;

import model.Product;

import java.util.Collection;
import java.util.List;

/**
 * Created by admin on 2017/6/17.
 */
public interface ProductService {

    void add(Product product);
    Product get(Long id);
    void update(Product product);
    void delete(Long id);
    Collection<Product> list();
}
