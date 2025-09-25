package com.example.mobilestore.service;

import com.example.mobilestore.dto.MobileDTO;

public interface MobileService {
    MobileDTO createMobile(MobileDTO dto);
    MobileDTO getMobileById(Long id);
}
