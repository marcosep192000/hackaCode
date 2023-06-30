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

    @Override
    public PurchaseDetails findById(Long id) {
        return purchaseDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    @Override
    public List<PurchaseDetailsResponseDto> getByFilters() {
        return purchaseDetailsRepository.findAll().stream()
                .map(purchase -> purchaseDetailsMapper.fromEntityToDto(purchase,
                        calculateTotalPrice(purchase.getTickets())))
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDetailsResponseDto getById(Long id) {
        PurchaseDetails purchase = findById(id);
        Double totalPrice = calculateTotalPrice(purchase.getTickets());
        return purchaseDetailsMapper.fromEntityToDto(purchase, totalPrice);
    }

    @Transactional
    public PurchaseDetailsResponseDto create(PurchaseDetailsRequestDto request) {
        // extract customer and employee
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        GameEmployee gameEmployee = gameEmployeeRepository.findById(request.getGameEmployeeId())
                .orElseThrow(() -> new RuntimeException("Game Employee not found"));

        // extract tickets and save in db
        List<Ticket> tickets = create(request.getTickets());

        // save purchase in db
        PurchaseDetails purchase = purchaseDetailsMapper.fromDtoToEntity(request, customer,
                gameEmployee, tickets);
        purchaseDetailsRepository.save(purchase);

        // calculate total price and return
        Double totalPrice = calculateTotalPrice(purchase.getTickets());
        return purchaseDetailsMapper.fromEntityToDto(purchase, totalPrice);
    }

    @Transactional
    public PurchaseDetailsResponseDto update(PurchaseDetailsRequestDto request, Long id) {
        // PurchaseDetails purchase = findPurchaseDetailsById(id);
        // PurchaseDetails updatedPurchase =
        // purchaseDetailsMapper.updatePurchase(purchase, request);
        // purchaseDetailsRepository.save(updatedPurchase);
        // return purchaseDetailsMapper.fromEntityToDto(updatedPurchase);
        return null;
    }

    @Transactional
    public void delete(Long id) {
        purchaseDetailsRepository.deleteById(id);
    }

    @Transactional
    private List<Ticket> create(List<TicketRequestDto> ticketsDto) {
        List<Ticket> tickets = new ArrayList<>();
        for (TicketRequestDto ticketDto : ticketsDto) {
            tickets.add(ticketService.create(ticketDto));
        }
        return tickets;
    }

    @Override
    public Double calculateTotalPrice(List<Ticket> tickets) {
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

   @Override
   public Double totalSalesByYear(int year){
        List<PurchaseDetails> purchases = purchaseDetailsRepository.findAll();
        double total = 0.00;
        for (PurchaseDetails purchase : purchases){
            if (purchase.getPurchaseDate().getYear() == year){
                total = calculateTotalPrice(purchase.getTickets());
            }
        }
        return total;
    }

    @Override
    public Double totalSalesByMonth(int month, int year){
        List<PurchaseDetails> purchases = purchaseDetailsRepository.findAll();
        double total = 0.00;
        for (PurchaseDetails purchase : purchases){
            if (purchase.getPurchaseDate().getMonth().equals(month) && purchase.getPurchaseDate().getYear() == year){
                total = calculateTotalPrice(purchase.getTickets());
            }
        }
        return total;
    }
}
