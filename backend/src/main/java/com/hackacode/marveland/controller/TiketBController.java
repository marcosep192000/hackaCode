package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.TiketB;
import com.hackacode.marveland.service.impl.TiketBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/tiket-b")
@CrossOrigin(origins = "*")
@RestController
public class TiketBController {

	@Autowired
	TiketBService tiketBService;
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TiketB request) {
		tiketBService.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("create");
	}
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAll() {
		List<TiketB> tiket = tiketBService.getAll();
		return ResponseEntity.ok(tiket);
	}



}
