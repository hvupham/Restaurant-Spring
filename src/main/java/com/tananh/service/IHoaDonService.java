package com.tananh.service;

import com.tananh.dto.HoaDonDto;
import com.tananh.modal.HoaDon;

import java.util.List;

public interface IHoaDonService {
    HoaDon createHoaDon(HoaDon hoaDon) throws Exception;
    HoaDon getHoaDon(Long id);
    HoaDon updateHoaDon(Long id, HoaDonDto hoaDonDto) throws Exception;
    void deleteHoaDon(Long id);
    List<HoaDon> findByUserId(Long userId);
}
