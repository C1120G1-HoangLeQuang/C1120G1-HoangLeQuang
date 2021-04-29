package com.example.test.service;

import com.example.test.model.ProductBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ProductBillService {

    List<ProductBill> findAll();
    ProductBill findById(Integer id);
    void deleteById(Integer id);
    void save(ProductBill productBill);

    Page<ProductBill> findAll(Pageable pageable);

    Page<ProductBill> findAllByBuyDate(String fromDate, String toDate, Pageable pageable);

    Integer calculateTotal(ProductBill productBill);

    List<ProductBill> findAllByTop(Integer top);
}
