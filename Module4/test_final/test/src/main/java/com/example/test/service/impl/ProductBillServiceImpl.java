package com.example.test.service.impl;

import com.example.test.model.ProductBill;
import com.example.test.repository.ProductBillRepository;
import com.example.test.service.ProductBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductBillServiceImpl implements ProductBillService {

    @Autowired
    ProductBillRepository productBillRepository;

    @Override
    public List<ProductBill> findAll() {
        return productBillRepository.findAll();
    }

    @Override
    public Page<ProductBill> findAll(Pageable pageable) {
        return productBillRepository.findAll(pageable);
    }

    @Override
    public ProductBill findById(Integer id) {
        return productBillRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        productBillRepository.deleteById(id);
    }

    @Override
    public void save(ProductBill productBill) {
        productBill.setTotal(calculateTotal(productBill));
        productBillRepository.save(productBill);
    }

    @Override
    public Page<ProductBill> findAllByBuyDate(String checkFrom, String checkTo, Pageable pageable) {
        return productBillRepository.findAllByBuyDate(checkFrom, checkTo, pageable);
    }

    @Override
    public Integer calculateTotal(ProductBill productBill) {
        Integer productCost = productBill.getProduct().getProductCost();
        Integer quantity = productBill.getQuantity();
        Integer total = productCost * quantity;
        return total;
    }

    @Override
    public List<ProductBill> findAllByTop(Integer top) {
        return productBillRepository.findAllByTop(top);
    }
}
