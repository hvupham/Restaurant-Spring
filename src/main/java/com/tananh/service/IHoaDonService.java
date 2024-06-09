package com.tananh.service;

import com.tananh.dto.HoaDonDto;
import com.tananh.dto.OrderDto;
import com.tananh.modal.HoaDon;
import com.tananh.modal.Order;

import java.util.List;

public interface IHoaDonService {
    HoaDon createHoaDon(HoaDonDto hoaDonDto) throws Exception;
    HoaDon getHoaDon(Long id);
    HoaDon updateHoaDon(Long id, HoaDonDto hoaDonDto) throws Exception;
    void deleteHoaDon(Long id);
    List<HoaDon> findByUserId(Long userId);
}
