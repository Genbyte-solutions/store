package com.example.demo.controller;


import com.example.demo.mapper.TicketMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.TicketDto;
import com.example.demo.model.entity.Ticket;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.ITicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> addProductToTicket(ProductDto productDto) {

        Ticket ticket = ticketService.findByProductSku(productDto.getSku());

        if (ticket != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product has already been added")
                    .build(), HttpStatus.CONFLICT);
        }

        ticketService.save(productDto);

        List<Ticket> items = ticketService.findAll();
        List<TicketDto> ticketDtos = ticketMapper.toDTOs(items);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Added product")
                .object(ticketDtos)
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


    /*@GetMapping("/ticket/products")
    public ResponseEntity<?> findAll() {
        List<Ticket> ticket = ticketService.findAll();

        List<TicketDto> products = ticketMapper.toDTOs(ticket);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Added product")
                .object(products)
                .build(), HttpStatus.OK);
    }*/

    @DeleteMapping("/ticket")
    public ResponseEntity<?> deleteByProductSku(@RequestParam("sku") String sku) {

        ticketService.deleteByProductSku(sku);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Deleted product")
                .build(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/ticket/clean")
    public ResponseEntity<?> cleanTicket() {
        ticketService.deleteAll();
        List<Ticket> items = ticketService.findAll();
        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Ticket cleaned")
                .object(items)
                .build(), HttpStatus.OK);
    }

}
