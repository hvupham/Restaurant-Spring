package com.tananh.controller;

import com.tananh.dto.HoaDonDto;
import com.tananh.modal.HoaDon;
import com.tananh.modal.KhachHang;
import com.tananh.respository.HoaDonRepository;
import com.tananh.respository.KhachHangRespository;
import com.tananh.service.HoaDonService;
import com.tananh.service.IHoaDonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hoadon")
@RequiredArgsConstructor
public class HoaDonController {
    private final HoaDonService hoaDonService;
    private final HoaDonRepository hoaDonRepository;
    private final KhachHangRespository khachHangRespository;

    @PostMapping("/new")
    public ResponseEntity<?> creatHoaDon (
            @RequestBody HoaDon hoaDon
            ) throws Exception{


            Long lastId = hoaDonRepository.findLastIdHoaDon();

            // Nếu không có hóa đơn nào trong cơ sở dữ liệu, sử dụng ID bắt đầu từ 1
            Long nextId = (lastId == null) ? 1L : lastId + 1;
            hoaDon.setIdHoaDon(nextId);
            hoaDon =hoaDonService.createHoaDon(hoaDon);
            return ResponseEntity.status(201).body(hoaDon);



    }


}
