package com.hackacode.marveland.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.model.mapper.PurchaseDetailsMapper;
import com.hackacode.marveland.repository.ICustomerRepository;
import com.hackacode.marveland.repository.IGameEmployeeRepository;
import com.hackacode.marveland.repository.IPurchaseDetailsRepository;
import com.hackacode.marveland.service.IPurchaseDetailsService;
import com.hackacode.marveland.service.ITicketService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseDetailsServiceImpl implements IPurchaseDetailsService {

    private final PurchaseDetailsMapper purchaseDetailsMapper;

    private final IPurchaseDetailsRepository purchaseDetailsRepository;

    private final ICustomerRepository customerRepository;

    private final IGameEmployeeRepository gameEmployeeRepository;

    private final ITicketService ticketService;

    private PurchaseDetails findPurchaseDetailsById(Long id) {
        return purchaseDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    @Override
    public List<PurchaseDetailsResponseDto> getPurchaseDetailsByFilters() {
        return purchaseDetailsRepository.findAll().stream()
                .map(purchase -> purchaseDetailsMapper.fromEntityToDto(purchase,
                        calculateTotalPrice(purchase.getTickets())))
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDetailsResponseDto getPurchaseDetailsById(Long id) {
        PurchaseDetails purchase = findPurchaseDetailsById(id);
        Double totalPrice = calculateTotalPrice(purchase.getTickets());
        return purchaseDetailsMapper.fromEntityToDto(purchase, totalPrice);
    }

    @Override
    public PurchaseDetailsResponseDto createPurchaseDetails(PurchaseDetailsRequestDto request) {
        // extract customer and employee
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        GameEmployee gameEmployee = gameEmployeeRepository.findById(request.getGameEmployeeId())
                .orElseThrow(() -> new RuntimeException("Game Employee not found"));

        // extract tickets and save in db
        List<Ticket> tickets = createTickets(request.getTickets());

        // save purchase in db
        PurchaseDetails purchase = purchaseDetailsMapper.fromDtoToEntity(request, customer,
                gameEmployee, tickets);
        purchaseDetailsRepository.save(purchase);

        // calculate total price and return
        Double totalPrice = calculateTotalPrice(purchase.getTickets());
        return purchaseDetailsMapper.fromEntityToDto(purchase, totalPrice);
    }

    @Override
    @Transactional
    public PurchaseDetailsResponseDto updatePurchaseDetails(PurchaseDetailsRequestDto request, Long id) {
        // PurchaseDetails purchase = findPurchaseDetailsById(id);
        // PurchaseDetails updatedPurchase =
        // purchaseDetailsMapper.updatePurchase(purchase, request);
        // purchaseDetailsRepository.save(updatedPurchase);
        // return purchaseDetailsMapper.fromEntityToDto(updatedPurchase);
        return null;
    }

    @Override
    public void deletePurchaseDetails(Long id) {
        purchaseDetailsRepository.delete(findPurchaseDetailsById(id));
    }

    private List<Ticket> createTickets(List<TicketRequestDto> ticketsDto) {
        List<Ticket> tickets = new ArrayList<>();
        for (TicketRequestDto ticketDto : ticketsDto) {
            tickets.add(ticketService.createTicket(ticketDto));
        }
        return tickets;
    }

    private Double calculateTotalPrice(List<Ticket> tickets) {
        Double totalPrice = 0.00;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getGame().getPrice();
        }
        return totalPrice;
    }

    @Override
    public List<PurchaseDetails> findByPurchaseDate(LocalDate date) {
        List<PurchaseDetails> purchaseList = purchaseDetailsRepository.findByPurchaseDate(date);
        return purchaseList;
    }

    @Override
    public Double totalSalesByDate(LocalDate date) {
        List<PurchaseDetails> purchases = findByPurchaseDate(date);
        double total = 0.00;
        for (PurchaseDetails purchase : purchases) {
            total = calculateTotalPrice(purchase.getTickets());
        }
        return total;
    }

    public Double totalSalesByYear(Integer year) {
        List<PurchaseDetails> purchases = purchaseDetailsRepository.findAll();
        double total = 0.00;
        for (PurchaseDetails purchase : purchases) {
            if (purchase.getPurchaseDate().getMonth().equals(year)) {
                total = calculateTotalPrice(purchase.getTickets());
            }
        }
        return total;
    }
}
