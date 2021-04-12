package com.example.practise.controller;

import com.example.practise.model.Customer;
import com.example.practise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //-------------------Retrieve All Customers--------------------------------------------------------

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> listCustomer() {
        List<Customer> customerList = this.customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    //-------------------Retrieve Single Customer--------------------------------------------------------

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        Customer customer = this.customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    //-------------------Create a Customer--------------------------------------------------------

    @PostMapping("/customer/create")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
        System.out.println("Creating Customer " + customer.getLastName());
        this.customerService.save(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("/customer/create/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    //------------------- Update a Customer --------------------------------------------------------

    @PutMapping("/customer/edit/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);
        Customer currentCustomer = this.customerService.findById(id);
        if (currentCustomer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setId(customer.getId());
        customerService.save(currentCustomer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        this.customerService.deleteById(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
