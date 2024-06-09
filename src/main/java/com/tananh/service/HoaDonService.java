package com.tananh.service;

import com.tananh.config.ModelMaperConfig;
import com.tananh.dto.HoaDonDto;
import com.tananh.dto.OrderDto;
import com.tananh.modal.HoaDon;
import com.tananh.modal.KhachHang;
import com.tananh.modal.Order;
import com.tananh.modal.User;
import com.tananh.respository.HoaDonRepository;
import com.tananh.respository.KhachHangRespository;
import com.tananh.respository.OrderRepository;
import com.tananh.respository.UserResponsitory;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonService implements IHoaDonService {
    private final UserResponsitory userResponsitory;
    private final OrderRepository orderRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    private final ModelMapper modelMapper;
    private final KhachHangRespository khachHangRespository;




    @Override
    @Transactional
    public HoaDon createHoaDon(HoaDonDto hoaDonDto) throws Exception {
        KhachHang Kh = khachHangRespository.findByIdKh(hoaDonDto.getIdKh());

//        modelMapper.typeMap(HoaDonDto.class, HoaDon.class);
        HoaDon hoaDon = new HoaDon();
        modelMapper.map(hoaDonDto, hoaDon);

//        hoaDon.setIdKh(Kh.getIdKh());
        hoaDon.setNgayHd(new Date());
        hoaDon.setIdKh(hoaDonDto.getIdKh());



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
