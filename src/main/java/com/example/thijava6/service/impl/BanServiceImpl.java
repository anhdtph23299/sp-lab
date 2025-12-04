package com.example.thijava6.service.impl;

import com.example.thijava6.dto.BanDTO;
import com.example.thijava6.exception.ResourceNotFoundException;
import com.example.thijava6.model.Ban;
import com.example.thijava6.repository.BanRepository;
import com.example.thijava6.service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanServiceImpl implements BanService {

    private final BanRepository banRepository;

    @Autowired
    public BanServiceImpl(BanRepository banRepository) {
        this.banRepository = banRepository;
    }

    @Override
    public List<BanDTO> getAllBans() {
        return banRepository.findAllProjected();
    }

    @Override
    public Page<BanDTO> getAllBansPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return banRepository.findAllProjected(pageable);
    }

    @Override
    public BanDTO getBanById(Long id) {
        return banRepository.findProjectedById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ban", "id", id));
    }

    @Override
    public BanDTO createBan(Ban ban) {
        if (banRepository.existsByMa(ban.getMa())) {
            throw new IllegalArgumentException("Mã bạn đã tồn tại");
        }
        Ban savedBan = banRepository.save(ban);
        return banRepository.findProjectedById(savedBan.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ban", "id", savedBan.getId()));
    }

    @Override
    public BanDTO updateBan(Long id, Ban banDetails) {
        Ban ban = banRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ban", "id", id));

        // Check if the new ma already exists for another record
        if (!ban.getMa().equals(banDetails.getMa()) && 
            banRepository.existsByMa(banDetails.getMa())) {
            throw new IllegalArgumentException("Mã bạn đã tồn tại");
        }

        ban.setMa(banDetails.getMa());
        ban.setHoTen(banDetails.getHoTen());
        ban.setGioiTinh(banDetails.getGioiTinh());
        ban.setNgaySinh(banDetails.getNgaySinh());
        ban.setNgayThamGia(banDetails.getNgayThamGia());
        ban.setDiaChi(banDetails.getDiaChi());
        ban.setSoDienThoai(banDetails.getSoDienThoai());
        ban.setEmail(banDetails.getEmail());
        ban.setMoiQuanHe(banDetails.getMoiQuanHe());
        
        banRepository.save(ban);
        return banRepository.findProjectedById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ban", "id", id));
    }

    @Override
    public void deleteBan(Long id) {
        Ban ban = banRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ban", "id", id));
        banRepository.delete(ban);
    }

    @Override
    public Page<BanDTO> searchByHoTen(String hoTen, int page, int size) {
        return banRepository.findByHoTenContainingIgnoreCase(hoTen, PageRequest.of(page, size));
    }

    @Override
    public void deleteBanByMa(String ma) {
        Ban ban = banRepository.findByMa(ma)
                .orElseThrow(() -> new ResourceNotFoundException("Ban", "ma", ma));
        banRepository.delete(ban);
    }

    @Override
    public List<BanDTO> getFemaleFriendsOrderByBirthday() {
        return banRepository.findFemaleFriendsOrderByBirthday();
    }
}
