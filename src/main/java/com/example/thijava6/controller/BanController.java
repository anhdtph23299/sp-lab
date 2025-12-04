package com.example.thijava6.controller;

import com.example.thijava6.dto.BanDTO;
import com.example.thijava6.model.Ban;
import com.example.thijava6.service.BanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ban")
public class BanController {
    private final BanService banService;

    @Autowired
    public BanController(BanService banService) {
        this.banService = banService;
    }

    @GetMapping
    public List<BanDTO> getAllBans() {
        return banService.getAllBans();
    }

    @GetMapping("/page")
    public Page<BanDTO> getAllBansPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return banService.getAllBansPaged(page, size);
    }

    @GetMapping("/{id}")
    public BanDTO getBanById(@PathVariable Long id) {
        return banService.getBanById(id);
    }

    @PostMapping
    public BanDTO createBan(@Valid @RequestBody Ban ban) {
        return banService.createBan(ban);
    }

    @PutMapping("/{id}")
    public BanDTO updateBan(
            @PathVariable Long id,
            @Valid @RequestBody Ban banDetails) {
        return banService.updateBan(id, banDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBan(@PathVariable Long id) {
        banService.deleteBan(id);
    }

    @GetMapping("/search")
    public Page<BanDTO> searchByHoTen(
            @RequestParam String ten,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return banService.searchByHoTen(ten, page, size);
    }

    @DeleteMapping("/ma/{ma}")
    public void deleteBanByMa(@PathVariable String ma) {
        banService.deleteBanByMa(ma);
    }

}
