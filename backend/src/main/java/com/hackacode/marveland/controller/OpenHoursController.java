package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.service.IOpenHoursService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/schedules")
@CrossOrigin(origins = "*")
@Tag(name = "Open Hours", description = "Management of open hours in Marveland. It allows creating, modifying, and deleting open hours, as well as obtaining detailed information about them.")
@SecurityRequirement(name = "bearerAuth")
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
