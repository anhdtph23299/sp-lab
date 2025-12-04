package com.example.thijava6.repository;

import com.example.thijava6.model.MoiQuanHe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoiQuanHeRepository extends JpaRepository<MoiQuanHe, Long> {
    boolean existsByMa(String ma);
    Optional<MoiQuanHe> findByMa(String ma);
}
