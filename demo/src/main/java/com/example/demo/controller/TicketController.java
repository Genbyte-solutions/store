package com.example.demo.controller;


import com.example.demo.mapper.TicketMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.TicketDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.model.entity.Ticket;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.ITicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
class TicketController {

    private final ITicket ticketService;
    private final TicketMapper ticketMapper;

    TicketController(ITicket ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @PostMapping("/ticket")
    public ResponseEntity<?> addProductToTicket(@RequestBody ProductResponseDto productResponseDto) {

        Ticket ticket = ticketService.findByProductSku(productResponseDto.getSku());

        if (ticket != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product has already been added")
                    .build(), HttpStatus.CONFLICT);
        }

        ticketService.save(productResponseDto);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Added product")
                .build(), HttpStatus.OK);
    }

    @PatchMapping("/ticket/update")
    public ResponseEntity<?> updateTicket(@RequestParam("quantity") Integer quantity, @RequestParam("productSku") String productSku) {

        Ticket ticket = ticketService.findByProductSku(productSku);

        if (ticket == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product is not on the ticket")
                    .build(), HttpStatus.NOT_FOUND);
        }

        ticketService.update(ticket, quantity, productSku);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ticket/products")
    public ResponseEntity<?> findAll() {
        BigDecimal total = new BigDecimal(0);
        List<Ticket> ticket = ticketService.findAll();
        List<TicketDto> products = ticketMapper.toDTOs(ticket);

        for (int i = 0; i < products.size(); i++) {
            total = total.add(products.get(i).getPricePerQuantity());
        }

        return new ResponseEntity<>(ResponseMessage.builder()
                .message(String.valueOf(total))
                .object(products)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/ticket")
    public ResponseEntity<?> deleteByProductSku(@RequestParam("sku") String sku) {

        ticketService.deleteByProductSku(sku);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/ticket/clean")
    public ResponseEntity<?> cleanTicket() {

        ticketService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
