package com.hackacode.marveland.controller;
import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.service.impl.CustomerServiceImpl;
import com.hackacode.marveland.util.Exeptions.GeneralMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		customerService.create(customerRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new GeneralMessage("Customer Created!"));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getById(id));
	}
	@GetMapping("/dni/{dni}")
	public ResponseEntity<?> findByDni(@PathVariable int dni) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getByDni(dni));
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update( @Valid @PathVariable Long id, @RequestBody  CustomerRequestDto requestDto){
	Customer customer=	customerService.Update(requestDto,id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id ){
		customerService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Customer Deleted"));
	}
}
