package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.service.IOpenHoursService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class OpenHoursController {

    private final IOpenHoursService openHoursService;

    @GetMapping("/all")
    public ResponseEntity<List<OpenHoursResponseDto>> getAll() {
        List<OpenHoursResponseDto> response = openHoursService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpenHoursResponseDto> getById(@PathVariable Long id) {
        OpenHoursResponseDto response = openHoursService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<OpenHoursResponseDto> create(@RequestBody OpenHoursRequestDto request) {
        OpenHoursResponseDto response = openHoursService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OpenHoursResponseDto> update(@PathVariable Long id,
            @RequestBody OpenHoursRequestDto request) {
        OpenHoursResponseDto response = openHoursService.update(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
        openHoursService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Open Hours successfully deleted"));
    }
}
