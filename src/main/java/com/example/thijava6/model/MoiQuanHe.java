package com.example.thijava6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Mã mối quan hệ không được để trống")
    private String ma;

    @Column(name = "loai_quan_he", length = 50)
    @NotBlank(message = "Loại quan hệ không được để trống")
    private String loaiQuanHe;

    @Column(name = "ngay_bat_dau", nullable = false)
    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate ngayBatDau;
}
