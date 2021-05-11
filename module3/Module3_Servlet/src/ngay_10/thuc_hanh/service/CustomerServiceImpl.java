package ngay_10.thuc_hanh.service;

import ngay_10.thuc_hanh.model.Customer_10;
import ngay_10.thuc_hanh.repository.CustomerRepository;
import ngay_10.thuc_hanh.repository.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository = new CustomerRepositoryImpl();

    @Override
    public List<Customer_10> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Customer_10 customer_10) {
        repository.save(customer_10);
    }

    @Override
    public Customer_10 findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, Customer_10 customer_10) {
        repository.update(id, customer_10);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
