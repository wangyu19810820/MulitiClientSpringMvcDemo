package service.impl;

import exception.ProductNotFoundException;
import model.Product;
import org.springframework.stereotype.Service;
import service.ProductService;

import java.util.*;

/**
 * Created by admin on 2017/6/17.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> productSet = new ArrayList<>();

    {
        productSet.add(new Product(1L, "苹果", "红富士", new Date()));
    }

    @Override
    public void add(Product product) {
        long maxId = productSet.stream()
                .mapToLong(Product::getId)
                .reduce(1, Long::max);
        product.setId(maxId + 1);
        productSet.add(product);
    }

    @Override
    public Product get(Long id) {
        return productSet.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Product product) {
        delete(product.getId());
        productSet.add(product);
    }

    @Override
    public void delete(Long id) {
        boolean b = productSet.removeIf(p -> p.getId().equals(id));
        if (!b) {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Collection<Product> list() {
        return productSet;
    }
}
