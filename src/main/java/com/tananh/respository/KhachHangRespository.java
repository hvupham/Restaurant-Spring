package com.tananh.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tananh.modal.KhachHang;

@Repository
public interface KhachHangRespository extends JpaRepository<KhachHang, Integer>{

}
