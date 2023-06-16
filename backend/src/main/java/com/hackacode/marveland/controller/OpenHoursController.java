package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class OpenHoursController {

    private final IOpenHoursService openHoursService;

    @GetMapping("/filters")
    public ResponseEntity<List<OpenHoursResponseDto>> getOpenHourssByFilters() {
        List<OpenHoursResponseDto> response = openHoursService.getOpenHoursByFilters();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpenHoursResponseDto> getOpenHoursById(@PathVariable Long id) {
        OpenHoursResponseDto response = openHoursService.getOpenHoursById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<OpenHoursResponseDto> createOpenHours(@RequestBody OpenHoursRequestDto request) {
        OpenHoursResponseDto response = openHoursService.createOpenHours(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<OpenHoursResponseDto> updateOpenHours(@PathVariable Long id,
            @RequestBody OpenHoursRequestDto request) {
        OpenHoursResponseDto response = openHoursService.updateOpenHours(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> deleteOpenHours(@PathVariable Long id) {
        openHoursService.deleteOpenHours(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("OpenHours successfully deleted"));
    }
}
