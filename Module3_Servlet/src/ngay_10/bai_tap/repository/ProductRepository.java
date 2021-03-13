package ngay_10.bai_tap.repository;

import ngay_10.bai_tap.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll(); // Tra ve danh sach tat ca khach hang
    void save(Product product); // Luu mot khach hang
    Product findById(int id); //Tim kiem khach hang bang ID
    void update(int id, Product product); // Cap nhap thong tin cua khach hang
    void remove(int id); // xoa khach hang khoi danh sach
}
