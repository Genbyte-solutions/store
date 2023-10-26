package com.example.demo.repository;

import com.example.demo.model.entities.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail,Integer> {
}
