package com.tananh.respository;

import com.tananh.modal.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    @Query("SELECT MAX(h.idHoaDon) FROM HoaDon h")
    Long findLastIdHoaDon();
}
