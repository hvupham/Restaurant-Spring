package com.tananh.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tananh.modal.KhachHang;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangRespository extends JpaRepository<KhachHang, Integer>{
    KhachHang findByIdKh(Integer id);

}
