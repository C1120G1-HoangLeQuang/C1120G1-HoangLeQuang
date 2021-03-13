package ngay_10.bai_tap.repository;

import ngay_10.bai_tap.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{

    private static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Iphone12", "USA", "Apple", 500));
        productMap.put(2, new Product(2, "GalaxyS10", "Korea", "SamSung", 400));
        productMap.put(3, new Product(3, "NokiaPro30", "USA", "Nokia", 250));
        productMap.put(4, new Product(4, "Soft2020", "Vietnam", "FPT", 470));
        productMap.put(5, new Product(5, "Stone23", "USA", "BlackBerry", 300));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
