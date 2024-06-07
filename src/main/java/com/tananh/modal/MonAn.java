package com.tananh.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

		public MonAn() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public MonAn(Integer idMonAn, String tenMon, Integer donGia, String loai, String trangThai, String image,
				String description) {
			super();
			this.idMonAn = idMonAn;
			this.tenMon = tenMon;
			this.donGia = donGia;
			this.loai = loai;
			this.trangThai = trangThai;
			this.image = image;
			Description = description;
		}

		

		public String getDescription() {
			return Description;
		}



		public void setDescription(String description) {
			Description = description;
		}



		public Integer getIdMonAn() {
			return idMonAn;
		}

		public void setIdMonAn(Integer idMonAn) {
			this.idMonAn = idMonAn;
		}

		public String getTenMon() {
			return tenMon;
		}

		public void setTenMon(String tenMon) {
			this.tenMon = tenMon;
		}

		public Integer getDonGia() {
			return donGia;
		}

		public void setDonGia(Integer donGia) {
			this.donGia = donGia;
		}

		public String getLoai() {
			return loai;
		}

		public void setLoai(String loai) {
			this.loai = loai;
		}

		public String getTrangThai() {
			return trangThai;
		}

		public void setTrangThai(String trangThai) {
			this.trangThai = trangThai;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
	    
}

