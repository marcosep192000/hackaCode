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
@RequestMapping("/api/v1/open_hours")
@RequiredArgsConstructor
public class OpenHoursController {

    private final IOpenHoursService openHoursService;

    @PostMapping("/create")
    public OpenHoursRequestDto createOpenHours(@RequestBody OpenHoursRequestDto openHours){
        openHoursService.createOpenHours(openHours);
        return openHours;
    }
    @PostMapping("/update")
    public ResponseEntity<OpenHoursResponseDto> updateOpenHours(@RequestParam Long id, @RequestBody OpenHoursRequestDto openHours){
        OpenHoursResponseDto response = openHoursService.updateHours(id, openHours);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<OpenHoursResponseDto>> getAllOpenHours(){
        List<OpenHoursResponseDto> response = openHoursService.getAllOpenHours();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpenHoursResponseDto> getOpenHoursById(@RequestParam Long id){
        OpenHoursResponseDto response = openHoursService.getOpenHoursById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteOpenHours(@RequestParam Long id){
        openHoursService.deleteOpenHours(id);
    }
}
