package com.tananh.modal;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HoaDon")
    private Long idHoaDon;

    @Column(name = "ID_KH")
    private Long idKh;

    @Column(name = "ID_Ban")
    private Long idBan;

    @Column(name = "NgayHD")
    private LocalDateTime ngayHd;

    @Column(name = "TienMonAn")
    private Integer tienMonAn;

    @Column(name = "Code_Voucher")
    private String codeVoucher;

    @Column(name = "TienGiam")
    private Integer tienGiam;

    @Column(name = "Tongtien")
    private Integer tongTien;

    @Column(name = "Trangthai")
    private String trangThai;

    @OneToMany(mappedBy="hoaDon")
    private List<CTHD> cthds;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(Long idHoaDon, Long idKh, Long idBan, LocalDateTime ngayHd, Integer tienMonAn, String codeVoucher,
			Integer tienGiam, Integer tongTien, String trangThai, List<CTHD> cthds) {
		super();
		this.idHoaDon = idHoaDon;
		this.idKh = idKh;
		this.idBan = idBan;
		this.ngayHd = ngayHd;
		this.tienMonAn = tienMonAn;
		this.codeVoucher = codeVoucher;
		this.tienGiam = tienGiam;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
		this.cthds = cthds;
	}

	public Long getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(Long idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public Long getIdKh() {
		return idKh;
	}

	public void setIdKh(Long idKh) {
		this.idKh = idKh;
	}

	public Long getIdBan() {
		return idBan;
	}

	public void setIdBan(Long idBan) {
		this.idBan = idBan;
	}

	public LocalDateTime getNgayHd() {
		return ngayHd;
	}

	public void setNgayHd(LocalDateTime ngayHd) {
		this.ngayHd = ngayHd;
	}

	public Integer getTienMonAn() {
		return tienMonAn;
	}

	public void setTienMonAn(Integer tienMonAn) {
		this.tienMonAn = tienMonAn;
	}

	public String getCodeVoucher() {
		return codeVoucher;
	}

	public void setCodeVoucher(String codeVoucher) {
		this.codeVoucher = codeVoucher;
	}

	public Integer getTienGiam() {
		return tienGiam;
	}

	public void setTienGiam(Integer tienGiam) {
		this.tienGiam = tienGiam;
	}

	public Integer getTongTien() {
		return tongTien;
	}

	public void setTongTien(Integer tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<CTHD> getCthds() {
		return cthds;
	}

	public void setCthds(List<CTHD> cthds) {
		this.cthds = cthds;
	}
    
    // Constructors, getters and setters...
    
}

