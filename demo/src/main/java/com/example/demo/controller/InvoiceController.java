package com.example.demo.controller;

import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.dto.response.InvoiceResponseDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.enums.PaymentMethod;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IInvoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {
    private final IInvoice invoiceService;
    private final InvoiceMapper invoiceMapper;

    public InvoiceController(IInvoice invoiceService, InvoiceMapper invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {

        Invoice invoice = invoiceService.findById(id);

        if (invoice == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Invoice not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        InvoiceResponseDto invoiceDto = invoiceMapper.toDTO(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(invoiceDto)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/invoice")
    public ResponseEntity<?> findByPaymentMethod(@RequestParam("paymentmethod") PaymentMethod paymentMethod) {

        List<Invoice> invoice = invoiceService.findByPaymentMethod(paymentMethod);

        if (invoice.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("no records found with this payment method")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<InvoiceResponseDto> invoiceDtos = invoiceMapper.toDTOs(invoice);

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

        List<InvoiceResponseDto> invoiceDtos = invoiceMapper.toDTOs(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(invoiceDtos)
                .build(), HttpStatus.OK);
    }

}
