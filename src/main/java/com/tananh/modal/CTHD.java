package com.tananh.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CTHD")
@IdClass(CTHDId.class) // For composite key
public class CTHD {

    @Id
    @Column(name = "ID_HoaDonn")
    private Long idHoaDon;

    @Id
    @Column(name = "ID_MonAn")
    private Integer idMonAn;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "Thanhtien")
    private Integer thanhTien;

    @ManyToOne
    @JoinColumn(name = "ID_HoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ID_MonAn")
    private MonAn monAn;

	public CTHD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTHD(Long idHoaDon, Integer idMonAn, Integer soLuong, Integer thanhTien, HoaDon hoaDon, MonAn monAn) {
		super();
		this.idHoaDon = idHoaDon;
		this.idMonAn = idMonAn;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.hoaDon = hoaDon;
		this.monAn = monAn;
	}

	public Long getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(Long idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public Integer getIdMonAn() {
		return idMonAn;
	}

	public void setIdMonAn(Integer idMonAn) {
		this.idMonAn = idMonAn;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Integer thanhTien) {
		this.thanhTien = thanhTien;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}
    
    // Constructors, getters and setters...
    
}