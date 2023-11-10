package com.example.demo.repository;

import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, Integer> {
    List<InvoiceDetail> findAllByFkInvoiceId(Invoice invoice);

}
