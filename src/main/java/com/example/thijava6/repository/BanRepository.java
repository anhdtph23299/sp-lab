package com.example.thijava6.repository;

import com.example.thijava6.dto.BanDTO;
import com.example.thijava6.model.Ban;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(excerptProjection = BanDTO.class)
public interface BanRepository extends JpaRepository<Ban, Long> {
    
    // Lấy tất cả bạn bè với phân trang, trả về dạng DTO
    @Query("SELECT b FROM Ban b")
    Page<BanDTO> findAllProjected(Pageable pageable);
    
    // Lấy tất cả bạn bè không phân trang, trả về dạng DTO
    @Query("SELECT b FROM Ban b")
    List<BanDTO> findAllProjected();

    // Tìm bạn bè theo tên gần đúng, trả về dạng DTO
    @Query("SELECT b FROM Ban b WHERE LOWER(b.hoTen) LIKE LOWER(concat('%', :ten, '%'))")
    Page<BanDTO> findByHoTenContainingIgnoreCase(@Param("ten") String ten, Pageable pageable);
    
    // Lấy bạn bè theo ID dạng DTO
    @Query("SELECT b FROM Ban b WHERE b.id = :id")
    Optional<BanDTO> findProjectedById(@Param("id") Long id);
    
    // Kiểm tra mã bạn bè đã tồn tại chưa
    boolean existsByMa(String ma);
    
    // Tìm bạn bè theo mã
    Optional<Ban> findByMa(String ma);
    

    void deleteByMa(String ma);
}
