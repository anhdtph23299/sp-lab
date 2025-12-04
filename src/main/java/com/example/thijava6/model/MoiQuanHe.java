package com.example.thijava6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "moi_quan_he")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoiQuanHe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma", nullable = false, length = 50)
    private String ma;

    @Column(name = "loai_quan_he", length = 50)
    private String loaiQuanHe;

    @Column(name = "ngay_bat_dau", nullable = false)
    private LocalDate ngayBatDau;
}
