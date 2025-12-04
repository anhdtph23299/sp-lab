package com.example.thijava6.dto;

import com.example.thijava6.model.Ban;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "banDTO", types = {Ban.class})
public interface BanDTO {
    @Value("#{target.id}")
    Long getId();
    
    @Value("#{target.ma}")
    String getMa();
    
    @Value("#{target.hoTen}")
    String getHoTen();
    
    @Value("#{target.email}")
    String getEmail();
    
    @Value("#{target.soDienThoai}")
    String getSoDienThoai();
    
    @Value("#{target.ngaySinh}")
    LocalDate getNgaySinh();
    
    @Value("#{target.diaChi}")
    String getDiaChi();
    
    @Value("#{target.ngayThamGia}")
    LocalDate getNgayThamGia();
    
    @Value("#{target.moiQuanHe}")
    MoiQuanHeDTO getMoiQuanHe();
}
