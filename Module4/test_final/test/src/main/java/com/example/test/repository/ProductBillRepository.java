package com.example.test.repository;

import com.example.test.model.ProductBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductBillRepository extends JpaRepository<ProductBill, Integer> {
    Page<ProductBill> findAll(Pageable pageable);


    @Query(value = "select * " +
            "from product_bill " +
            "where buy_date  between ?1 and ?2 ", nativeQuery = true)
    Page<ProductBill> findAllByBuyDate(String fromDate, String toDate, Pageable pageable);

    @Query(value = "select * " +
            "from product_bill " +
            "order by total desc " +
            "limit ?1", nativeQuery = true)
    List<ProductBill> findAllByTop(Integer top);
}
