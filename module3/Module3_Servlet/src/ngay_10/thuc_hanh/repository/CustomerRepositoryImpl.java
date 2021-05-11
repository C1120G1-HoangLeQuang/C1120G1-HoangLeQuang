package ngay_10.thuc_hanh.repository;

import ngay_10.thuc_hanh.model.Customer_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository{

    private static Map<Integer, Customer_10> customer_10Map;
    static {
        customer_10Map = new HashMap<>();
        customer_10Map.put(1, new Customer_10(1, "John", "john@codegym.vn", "Hanoi"));
        customer_10Map.put(2, new Customer_10(2, "Bill", "bill@codegym.vn", "DaNang"));
        customer_10Map.put(3, new Customer_10(3, "Alex", "alex@codegym.vn", "Saigon"));
        customer_10Map.put(4, new Customer_10(4, "Adam", "adam@codegym.vn", "Beijing"));
        customer_10Map.put(5, new Customer_10(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customer_10Map.put(6, new Customer_10(6, "Rose", "rose@codegym.vn", "NewYork"));
    }

    @Override
    public List<Customer_10> findAll() {
        return new ArrayList<>(customer_10Map.values());
    }

    @Override
    public void save(Customer_10 customer_10) {
        customer_10Map.put(customer_10.getId(), customer_10);
    }

    @Override
    public Customer_10 findById(int id) {
        return customer_10Map.get(id);
    }

    @Override
    public void update(int id, Customer_10 customer_10) {
        customer_10Map.put(id, customer_10);
    }

    @Override
    public void remove(int id) {
        customer_10Map.remove(id);
    }

}
