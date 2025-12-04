package com.example.thijava6.dto;

import com.example.thijava6.model.MoiQuanHe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "moiQuanHeDTO", types = {MoiQuanHe.class})
public interface MoiQuanHeDTO {
    @Value("#{target.id}")
    Long getId();
    
    @Value("#{target.ma}")
    String getMa();
    
    @Value("#{target.loaiQuanHe}")
    String getLoaiQuanHe();
    
    @Value("#{target.ngayBatDau}")
    LocalDate getNgayBatDau();
}
