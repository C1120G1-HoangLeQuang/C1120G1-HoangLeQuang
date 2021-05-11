package Services;

import Common.FuncReadAndWrite;
import Model.Customer;
import Model.ForeignCustomer;
import Model.VietnameseCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    FuncReadAndWrite<Customer> funcReadAndWrite = new FuncReadAndWrite<>();

    public List<Customer> findAllCustomer() {
        List<String[]> list = FuncReadAndWrite.readFile("Customer.csv");
        List<Customer> listCustomer = new ArrayList<>();
        for (String[] line : list) {
            Customer customer;
            String signal = line[0].substring(2, 4);
            if (signal.equals("VN")) {
                customer = new VietnameseCustomer(line);
            } else {
                customer = new ForeignCustomer(line);
            }
            listCustomer.add(customer);
        }
        return listCustomer;
    }
}
