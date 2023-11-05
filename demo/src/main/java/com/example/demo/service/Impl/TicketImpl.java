package com.example.demo.service.Impl;

import com.example.demo.mapper.TicketMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.TicketDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.model.entity.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.ITicket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TicketImpl implements ITicket {

    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    public TicketImpl(TicketMapper ticketMapper, TicketRepository ticketRepository) {
        this.ticketMapper = ticketMapper;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    @Override
    public void save(ProductResponseDto productResponseDto) {
        Ticket ticket = ticketMapper.toEntity(productResponseDto);
        ticketRepository.save(ticket);
    }

    @Transactional
    @Override
    public void update(Ticket ticket, Integer quantity, String productSku) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(ticket.getUnitPrice()));

        ticket.setQuantity(quantity);
        ticket.setPricePerQuantity(bigDecimal.multiply(BigDecimal.valueOf(quantity)));

        ticketRepository.save(ticket);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Ticket findByProductSku(String productSku) {
        return ticketRepository.findByProductSku(productSku);
    }

    @Transactional
    @Override
    public void deleteAll() {
        ticketRepository.deleteAll();
    }

    @Transactional
    @Override
    public void deleteByProductSku(String productSku) {
        ticketRepository.deleteByProductSku(productSku);
    }
}
