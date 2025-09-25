package com.example.mobilestore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mobilestore.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Long> {
    // standard CRUD methods from JpaRepository
}
