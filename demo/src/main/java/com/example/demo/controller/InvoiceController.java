package com.example.demo.controller;

import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entity.Branch;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IBranch;
import com.example.demo.service.IInvoiceDetail;
import com.example.demo.service.IInvoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {
    private final IInvoice invoiceService;
    private final IBranch branchService;
    private final IInvoiceDetail invoiceDetailService;
    private final InvoiceMapper invoiceMapper;

    public InvoiceController(IInvoice invoiceService, IBranch branchService, IInvoiceDetail invoiceDetailService, InvoiceMapper invoiceMapper) {
        this.invoiceService = invoiceService;
        this.branchService = branchService;
        this.invoiceDetailService = invoiceDetailService;
        this.invoiceMapper = invoiceMapper;
    }

    @PostMapping("/invoice")
    public ResponseEntity<?> create(@RequestBody InvoiceDto invoiceDto) {

        if (invoiceDto.getInvoiceDetailDtos().isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("It is not possible to generate an invoice without products")
                    .build(), HttpStatus.BAD_REQUEST);
        }

        Invoice invoice = invoiceService.save(invoiceDto);
        for (InvoiceDetailDto invoiceDetailDto : invoiceDto.getInvoiceDetailDtos()) {
            invoiceDetailService.save(invoiceDetailDto, invoice);
        }

        invoiceDto = invoiceMapper.toDTO(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new invoice has been generated")
                .object(invoiceDto)
                .build(), HttpStatus.CREATED);

    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {

        Invoice invoice = invoiceService.findById(id);

        if (invoice == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Invoice not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        InvoiceDto invoiceDto = invoiceMapper.toDTO(invoice);

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

        // Error to convert entity to dto by invoiceDetails
        // List<InvoiceDto> invoiceDtos = invoiceMapper.toDTOs(invoice);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(invoice)
                .build(), HttpStatus.OK);
    }

}
