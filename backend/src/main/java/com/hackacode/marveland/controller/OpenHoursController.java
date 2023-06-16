package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.service.IOpenHoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class OpenHoursController {

    private final IOpenHoursService openHoursService;

    @PostMapping("/create")
    public OpenHoursRequestDto create(@RequestBody OpenHoursRequestDto openHours){
        openHoursService.create(openHours);
        return openHours;
    }
    
    @PostMapping("/update")
    public ResponseEntity<OpenHoursResponseDto> update(@RequestParam Long id, @RequestBody OpenHoursRequestDto openHours){
        OpenHoursResponseDto response = openHoursService.update(id, openHours);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OpenHoursResponseDto>> getAll(){
        List<OpenHoursResponseDto> response = openHoursService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpenHoursResponseDto> getById(@RequestParam Long id){
        OpenHoursResponseDto response = openHoursService.getById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        openHoursService.delete(id);
    }
}
