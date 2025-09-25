package com.example.mobilestore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.example.mobilestore.controller.MobileController;
import com.example.mobilestore.dto.MobileDTO;
import com.example.mobilestore.entity.Mobile;
import com.example.mobilestore.exception.ResourceNotFoundException;
import com.example.mobilestore.repo.MobileRepository;
import com.example.mobilestore.service.MobileService;
import com.example.mobilestore.service.impl.MobileServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Unit tests for MobileController and MobileServiceImpl.
 *
 * - Uses MockitoExtension (JUnit 5) for clean mock lifecycle.
 * - Controller tests mock the service.
 * - ServiceImpl tests mock the repository and inject via reflection.
 */
@ExtendWith(MockitoExtension.class)
public class MobileStoreTests {

    /* ---------------- Controller tests (mock service) ---------------- */
    @Mock
    private MobileService mockMobileService;

    @InjectMocks
    private MobileController mobileController;

    /* ---------------- ServiceImpl tests (mock repository) ------------- */
    @Mock
    private MobileRepository mockRepository;

    // real service impl (but repository inside it will be mocked)
    private MobileServiceImpl serviceImpl;

    @BeforeEach
    void setUp() throws Exception {
        // create real service impl and inject mocked repository by reflection
        serviceImpl = new MobileServiceImpl();

        // The field name in MobileServiceImpl must be "mobileRepository"
        java.lang.reflect.Field repoField = MobileServiceImpl.class.getDeclaredField("mobileRepository");
        repoField.setAccessible(true);
        repoField.set(serviceImpl, mockRepository);
    }

    @Test
    void controller_createMobile_returnsCreatedAndBody() {
        // Arrange: input DTO
        MobileDTO input = new MobileDTO();
        input.setName("Pixel");
        input.setBrand("Google");
        input.setPrice(599.0);
        input.setStorage("128GB");
        input.setRam("8GB");
        input.setProcessor("Tensor");

        // Arrange: DTO that service will return (with id populated)
        MobileDTO returned = new MobileDTO();
        returned.setId(1L);
        returned.setName("Pixel");
        returned.setBrand("Google");
        returned.setPrice(599.0);
        returned.setStorage("128GB");
        returned.setRam("8GB");
        returned.setProcessor("Tensor");

        // Stub the service method that controller calls
        when(mockMobileService.createMobile(any(MobileDTO.class))).thenReturn(returned);

        // Act
        ResponseEntity<MobileDTO> resp = mobileController.createMobile(input);

        // Assert
        assertNotNull(resp, "ResponseEntity should not be null");
        assertEquals(HttpStatus.CREATED, resp.getStatusCode(), "Status should be 201 CREATED");
        assertNotNull(resp.getBody(), "Response body should not be null");
        assertEquals(1L, resp.getBody().getId());
        assertEquals("Pixel", resp.getBody().getName());

        // Verify service invoked once
        verify(mockMobileService, times(1)).createMobile(any(MobileDTO.class));
    }

    @Test
    void service_getMobileById_whenExists_returnsDto() {
        // Arrange: create entity returned by repository
        Mobile entity = new Mobile();
        entity.setId(10L);
        entity.setName("Galaxy");
        entity.setBrand("Samsung");
        entity.setPrice(799.0);
        entity.setStorage("256GB");
        entity.setRam("12GB");
        entity.setProcessor("Exynos");

        when(mockRepository.findById(10L)).thenReturn(Optional.of(entity));

        // Act
        MobileDTO dto = serviceImpl.getMobileById(10L);

        // Assert
        assertNotNull(dto);
        assertEquals(10L, dto.getId());
        assertEquals("Galaxy", dto.getName());
        assertEquals("Samsung", dto.getBrand());

        verify(mockRepository, times(1)).findById(10L);
    }

    @Test
    void service_getMobileById_whenNotFound_throwsResourceNotFoundException() {
        // Arrange: repository returns empty Optional
        when(mockRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            serviceImpl.getMobileById(99L);
        });

        assertTrue(ex.getMessage().toLowerCase().contains("not found") || ex.getMessage().length() > 0);

        verify(mockRepository, times(1)).findById(99L);
    }
}
