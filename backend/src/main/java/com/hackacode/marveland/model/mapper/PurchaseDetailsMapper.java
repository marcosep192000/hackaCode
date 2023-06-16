package com.hackacode.marveland.model.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.model.entity.Ticket;

@Component
public class PurchaseDetailsMapper {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PurchaseDetailsResponseDto fromEntityToDto(PurchaseDetails purchaseDetails, Double finalPrice) {

        List<Ticket> tickets = purchaseDetails.getTickets();
        List<TicketResponseDto> ticketsDto = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketsDto.add(ticketMapper.fromEntityToDto(ticket));
        }

        return PurchaseDetailsResponseDto.builder()
                .id(purchaseDetails.getId())
                .details(purchaseDetails.getDetails())
                .purchaseDate(purchaseDetails.getPurchaseDate())
                .tickets(ticketsDto)
                .paymentMethod(purchaseDetails.getPaymentMethod())
                .customer(customerMapper.fromEntityToDto(purchaseDetails.getCustomer()))
                .finalPrice(finalPrice)
                .gameEmployee(employeeMapper.fromEntityToDto(purchaseDetails.getGameEmployee()))
                .build();
    }

    public PurchaseDetails fromDtoToEntity(PurchaseDetailsRequestDto request, Customer customer,
            GameEmployee gameEmployee, List<Ticket> tickets) {
        return PurchaseDetails.builder()
                .details(request.getDetails())
                .purchaseDate(LocalDate.now())
                .tickets(tickets)
                .paymentMethod(request.getPaymentMethod())
                .customer(customer)
                .gameEmployee(gameEmployee)
                .build();
    }
}
