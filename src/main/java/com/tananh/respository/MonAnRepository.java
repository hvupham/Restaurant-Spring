package com.tananh.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tananh.modal.MonAn;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, Integer> {
}
