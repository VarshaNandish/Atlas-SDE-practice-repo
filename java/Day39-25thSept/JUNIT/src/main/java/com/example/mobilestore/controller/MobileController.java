package com.example.mobilestore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mobilestore.dto.MobileDTO;
import com.example.mobilestore.service.MobileService;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mobiles")
public class MobileController {

    private final MobileService mobileService;

    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @PostMapping
    public ResponseEntity<MobileDTO> createMobile(@Valid @RequestBody MobileDTO dto) {
        MobileDTO created = mobileService.createMobile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MobileDTO> getMobileById(@PathVariable Long id) {
        MobileDTO dto = mobileService.getMobileById(id);
        return ResponseEntity.ok(dto);
    }
}
