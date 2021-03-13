package ngay_10.thuc_hanh.service;

import ngay_10.thuc_hanh.model.Customer_10;

import java.util.List;

public interface CustomerService {
    List<Customer_10> findAll();
    void save(Customer_10 customer_10);
    Customer_10 findById(int id);
    void update(int id, Customer_10 customer_10);
    void remove(int id);
//    boolean validateName(String name);
//    boolean validateId(int id);
}
