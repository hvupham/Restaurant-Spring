package com.tananh.dto;

import java.sql.Date;

public class KhachHang {
	 	private Long idKh;
	    private String tenKh;
	    private Date ngayThamGia;
	    private Integer doanhSo;
	    private Integer diemTichLuy;
	    private Long idNd; // Giả sử bạn muốn bao gồm cả ID Người dùng liên quan

	    // Constructors
	    

	    // Getters and Setters
	    public Long getIdKh() {
	        return idKh;
	    }

	    public KhachHang() {
			super();
			// TODO Auto-generated constructor stub
		}

		public KhachHang(Long idKh, String tenKh, Date ngayThamGia, Integer doanhSo, Integer diemTichLuy, Long idNd) {
			super();
			this.idKh = idKh;
			this.tenKh = tenKh;
			this.ngayThamGia = ngayThamGia;
			this.doanhSo = doanhSo;
			this.diemTichLuy = diemTichLuy;
			this.idNd = idNd;
		}

		public void setIdKh(Long idKh) {
	        this.idKh = idKh;
	    }

	    public String getTenKh() {
	        return tenKh;
	    }

	    public void setTenKh(String tenKh) {
	        this.tenKh = tenKh;
	    }

	    public Date getNgayThamGia() {
	        return ngayThamGia;
	    }

	    public void setNgayThamGia(Date ngayThamGia) {
	        this.ngayThamGia = ngayThamGia;
	    }

	    public Integer getDoanhSo() {
	        return doanhSo;
	    }

	    public void setDoanhSo(Integer doanhSo) {
	        this.doanhSo = doanhSo;
	    }

	    public Integer getDiemTichLuy() {
	        return diemTichLuy;
	    }

	    public void setDiemTichLuy(Integer diemTichLuy) {
	        this.diemTichLuy = diemTichLuy;
	    }

	    public Long getIdNd() {
	        return idNd;
	    }

	    public void setIdNd(Long idNd) {
	        this.idNd = idNd;
	    }

}
