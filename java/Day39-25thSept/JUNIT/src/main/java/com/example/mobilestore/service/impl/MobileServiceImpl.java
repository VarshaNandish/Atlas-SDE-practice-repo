package com.example.mobilestore.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mobilestore.dto.MobileDTO;
import com.example.mobilestore.entity.Mobile;
import com.example.mobilestore.exception.ResourceNotFoundException;
import com.example.mobilestore.repo.MobileRepository;
import com.example.mobilestore.service.MobileService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileRepository mobileRepository; // field name used by tests for reflection injection

    @Override
    public MobileDTO createMobile(MobileDTO dto) {
        Mobile entity = toEntity(dto);
        Mobile saved = mobileRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public MobileDTO getMobileById(Long id) {
        Optional<Mobile> opt = mobileRepository.findById(id);
        Mobile m = opt.orElseThrow(() -> new ResourceNotFoundException("Mobile not found for id: " + id));
        return toDto(m);
    }

    // simple mapping helpers
    private Mobile toEntity(MobileDTO dto) {
        Mobile m = new Mobile();
        m.setId(dto.getId());
        m.setName(dto.getName());
        m.setBrand(dto.getBrand());
        m.setPrice(dto.getPrice());
        m.setStorage(dto.getStorage());
        m.setRam(dto.getRam());
        m.setProcessor(dto.getProcessor());
        return m;
    }

    private MobileDTO toDto(Mobile m) {
        MobileDTO dto = new MobileDTO();
        dto.setId(m.getId());
        dto.setName(m.getName());
        dto.setBrand(m.getBrand());
        dto.setPrice(m.getPrice());
        dto.setStorage(m.getStorage());
        dto.setRam(m.getRam());
        dto.setProcessor(m.getProcessor());
        return dto;
    }
}
