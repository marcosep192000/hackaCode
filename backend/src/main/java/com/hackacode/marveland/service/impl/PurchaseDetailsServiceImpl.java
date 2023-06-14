package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public PurchaseDetailsResponseDto createPurchaseDetails(PurchaseDetailsRequestDto purchaseDetailsRequestDto) {

        // extraigo al customer y empleado asignados en el dto del detalle de compra
        Customer customer = customerRepository.findById(purchaseDetailsRequestDto.getCustomerId()).orElseThrow();
        GameEmployee gameEmployee = gameEmployeeRepository.findById(purchaseDetailsRequestDto.getGameEmployeeId())
                .orElseThrow();

        // extraigo los tickets del dto de detalle de compra y los guardo llamando al servicio de tickets
        List<TicketRequestDto> ticketsDto = purchaseDetailsRequestDto.getTickets();
        List<Ticket> tickets = new ArrayList<>();
        for (TicketRequestDto ticketDto : ticketsDto) {
            tickets.add(ticketService.createTicket(ticketDto));
        }

        PurchaseDetails purchaseDetails = purchaseDetailsMapper.fromDtoToEntity(purchaseDetailsRequestDto, customer,
                gameEmployee, tickets);

        purchaseDetailsRepository.save(purchaseDetails);

        // calcular el total de la compra
        Double finalPrice = 10.50;
        return purchaseDetailsMapper.fromEntityToDto(purchaseDetails, finalPrice);
    }

    @Override
    public List<PurchaseDetailsResponseDto> getAllPurchases() {
        List<PurchaseDetails> purchases = purchaseDetailsRepository.findAll();
        List<PurchaseDetailsResponseDto> purchaseResponseDtoList = new ArrayList<>();
        Double finalPrice = 10.50;
        purchases.forEach(purchase -> {
            PurchaseDetailsResponseDto response = purchaseDetailsMapper.fromEntityToDto(purchase, finalPrice);
            purchaseResponseDtoList.add(response);
        });
        return purchaseResponseDtoList;
    }

    @Override
    public PurchaseDetailsResponseDto getPurchaseById(Long id) {
        Optional<PurchaseDetails> purchase = purchaseDetailsRepository.findById(id);
        Double finalPrice = 10.50;
        PurchaseDetailsResponseDto response = purchaseDetailsMapper.fromEntityToDto(purchase.get(), finalPrice);
        return response;
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseDetailsRepository.deleteById(id);
    }
}
