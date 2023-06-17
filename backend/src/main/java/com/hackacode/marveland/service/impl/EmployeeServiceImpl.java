package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;
import com.hackacode.marveland.model.entity.Employee;
import com.hackacode.marveland.model.mapper.EmployeeMapper;
import com.hackacode.marveland.repository.IEmployeeRepository;
import com.hackacode.marveland.service.IEmployeeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	private final EmployeeMapper employeeMapper;

	private final IEmployeeRepository employeeRepository;

	private Employee findById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	@Override
	public List<EmployeeListResponseDto> getByFilters() {
		return employeeRepository.findAll().stream()
				.map(employee -> employeeMapper.fromEntityToDto(employee))
				.collect(Collectors.toList());
	}


    // @Override
    // public List<TransactionResponseDto> getTransactionsByFilters(Long paymentMethodId,
    //         TransactionType transactionType,
    //         LocalDate transactionDate, Long purchaseCoinId, Double purchaseAmount, Long saleCoinId,
    //         Double saleAmount, Long walletId) {

    //     Specification<Transaction> spec = Specification.where(null);

    //     if (paymentMethodId != null) {
    //         spec = spec.and(TransactionSpecification.hasPaymentMethod(paymentMethodId));
    //     }

    //     if (transactionType != null) {
    //         spec = spec.and(TransactionSpecification.hasTransactionType(transactionType));
    //     }

    //     if (transactionDate != null) {
    //         spec = spec.and(TransactionSpecification.hasTransactionDate(transactionDate));
    //     }

    //     if (purchaseCoinId != null) {
    //         spec = spec.and(TransactionSpecification.hasPurchaseCoin(purchaseCoinId));
    //     }

    //     if (purchaseAmount != null) {
    //         spec = spec.and(TransactionSpecification.hasPurchaseAmount(purchaseAmount));
    //     }

    //     if (saleCoinId != null) {
    //         spec = spec.and(TransactionSpecification.hasSaleCoin(saleCoinId));
    //     }

    //     if (saleAmount != null) {
    //         spec = spec.and(TransactionSpecification.hasSaleAmount(saleAmount));
    //     }

    //     if (walletId != null) {
    //         spec = spec.and(TransactionSpecification.hasWalletId(walletId));
    //     }

    //     List<Transaction> transactionsFiltered = transactionRepository.findAll(spec);
    //     List<TransactionResponseDto> TransactionResponseDtoList = new ArrayList<>();
    //     for (Transaction transaction : transactionsFiltered) {
    //         TransactionResponseDto transactionResponseDto = transactionMapper.fromEntityToTransactionDto(transaction);
    //         TransactionResponseDtoList.add(transactionResponseDto);
    //     }

    //     return TransactionResponseDtoList;
    // }

	@Override
	public EmployeeListResponseDto getById(Long id) {
		Employee Employee = findById(id);
		return employeeMapper.fromEntityToDto(Employee);
	}

	@Override
	@Transactional
	public EmployeeListResponseDto update(EmployeeRequestDto request, Long id) {
		Employee employee = findById(id);
		Employee updatedEmployee = employeeMapper.update(employee, request);
		employeeRepository.save(updatedEmployee);
		return employeeMapper.fromEntityToDto(updatedEmployee);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.delete(findById(id));
	}
}