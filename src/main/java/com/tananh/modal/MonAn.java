package com.tananh.modal;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Monan")
public class MonAn {
	 	@Id
	    @Column(name = "ID_MonAn")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idMonAn;

	    @Column(name = "TenMon")
	    private String tenMon;

	    @Column(name = "DonGia")
	    private Integer donGia;

	    @Column(name = "Loai")
	    private String loai;

	    @Column(name = "TrangThai")
	    private String trangThai;
	    
	    @Column(name = "image")
	    private String image;
	    
	    @Column(name = "Description")
	    private String Description;


	    
}

