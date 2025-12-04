package com.example.thijava6.service;

import com.example.thijava6.dto.BanDTO;
import com.example.thijava6.model.Ban;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Service interface for managing Ban (Friend) entities.
 */
public interface BanService {
    /**
     * Get all friends without pagination.
     * @return List of BanDTO
     */
    List<BanDTO> getAllBans();
    
    /**
     * Get all friends with pagination.
     * @param page Page number (0-based)
     * @param size Number of items per page
     * @return Page of BanDTO
     */
    Page<BanDTO> getAllBansPaged(int page, int size);
    
    /**
     * Get a friend by ID.
     * @param id Friend ID
     * @return BanDTO
     * @throws com.example.thijava6.exception.ResourceNotFoundException if friend not found
     */
    BanDTO getBanById(Long id);
    
    /**
     * Create a new friend.
     * @param ban Friend entity to create
     * @return Created BanDTO
     * @throws IllegalArgumentException if friend with the same code already exists
     */
    BanDTO createBan(Ban ban);
    
    /**
     * Update an existing friend.
     * @param id Friend ID
     * @param banDetails Updated friend details
     * @return Updated BanDTO
     * @throws com.example.thijava6.exception.ResourceNotFoundException if friend not found
     * @throws IllegalArgumentException if friend with the new code already exists
     */
    BanDTO updateBan(Long id, Ban banDetails);
    
    /**
     * Delete a friend by ID.
     * @param id Friend ID
     * @throws com.example.thijava6.exception.ResourceNotFoundException if friend not found
     */
    void deleteBan(Long id);
    
    /**
     * Search friends by name with pagination.
     * @param hoTen Name to search (case-insensitive)
     * @param page Page number (0-based)
     * @param size Number of items per page
     * @return Page of BanDTO matching the search criteria
     */
    Page<BanDTO> searchByHoTen(String hoTen, int page, int size);
    

    /**
     * Delete a friend by code.
     * @param ma Friend code
     * @throws com.example.thijava6.exception.ResourceNotFoundException if friend not found
     */
    void deleteBanByMa(String ma);
}
