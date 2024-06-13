package com.tananh.service;

import com.tananh.dto.HoaDonDto;
import com.tananh.modal.HoaDon;
import com.tananh.respository.HoaDonRepository;
import com.tananh.respository.KhachHangRespository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HoaDonService implements IHoaDonService {
    private final HoaDonRepository hoaDonRepository;

    @Override
    @Transactional
    public HoaDon createHoaDon(HoaDon hoaDon) throws Exception {


        return hoaDonRepository.save(hoaDon);

    }

    @Override
    public HoaDon getHoaDon(Long id) {
        return null;
    }

    @Override
    public HoaDon updateHoaDon(Long id, HoaDonDto hoaDonDto) throws Exception {
        return null;
    }

    @Override
    public void deleteHoaDon(Long id) {

    }

    @Override
    public List<HoaDon> findByUserId(Long userId) {
        return null;
    }
}
