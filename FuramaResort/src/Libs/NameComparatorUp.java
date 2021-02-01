package Libs;

import Commons.ReadAndWriteCustomer;
import Models.Customer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameComparatorUp implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getNameCustomer().compareTo(o2.getNameCustomer()) > 0) {
            return 1;
        } else if (o1.getNameCustomer().compareTo(o2.getNameCustomer()) < 0) {
            return -1;
        } else {
            if (o1.getDateOfBirth().compareTo(o2.getDateOfBirth()) > 0) {
                return 1;
            } else if (o1.getDateOfBirth().compareTo(o2.getDateOfBirth()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
