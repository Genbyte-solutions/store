package com.example.demo.controller;

import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entities.Invoice;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IInvoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
public class InvoiceController {

    private final IInvoice invoiceService;
    private final InvoiceMapper invoiceMapper;

    public InvoiceController(IInvoice invoiceService, InvoiceMapper invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }


    @PostMapping("/invoice")
    public ResponseEntity<?> create(@RequestBody InvoiceDto invoiceDto) {

        Invoice invoice = invoiceService.save(invoiceDto);

        invoiceDto = invoiceMapper.toDTO(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new invoice has been generated")
                .object(invoiceDto)
                .build(), HttpStatus.CREATED);

    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {

        Optional<Invoice> invoice = invoiceService.findById(id);

        if (invoice.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Invoice not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        InvoiceDto invoiceDto = invoiceMapper.toDTO(invoice.get());

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(invoiceDto)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/invoice")
    public ResponseEntity<?> findByPaymentMethod(@RequestParam("paymentmethod") String paymentMethod) {

        List<Invoice> invoice = invoiceService.findByPaymentMethod(paymentMethod.toUpperCase());

        if (invoice.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("no records found with this payment method")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<InvoiceDto> invoiceDtos = invoiceMapper.toDTOs(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(invoiceDtos)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/invoices")
    public ResponseEntity<?> findAll() {

        List<Invoice> invoice = invoiceService.findAll();

        if (invoice.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("No records found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<InvoiceDto> invoiceDtos = invoiceMapper.toDTOs(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(invoiceDtos)
                .build(), HttpStatus.OK);

    }

}
