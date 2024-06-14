package com.tananh.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Khachhang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang {
	 	@Id 
	    @Column(name = "ID_KH")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idKh;

	    @Column(name = "TenKH")
	    private String tenKh;

	   
	    @Column(name = "Ngaythamgia")
	    private LocalDateTime ngayThamGia;

	    @Column(name = "Doanhso")
	    private int doanhSo;

	    @Column(name = "Diemtichluy")
	    private int diemTichLuy;

	    // Assuming 'ID_ND' is a foreign key to another table 'ND' for example
	    @Column(name = "ID_ND")
	    private Long idNd;


	    
	    
}
