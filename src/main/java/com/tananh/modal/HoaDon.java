package com.tananh.modal;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity

@Builder

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Hoadon")
@Data

public class HoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_HoaDon")
	private Long idHoaDon;

	@Column(name = "ID_KH")
	private Integer idKh;

	@Column(name = "ID_Ban")
	private Long idBan;

	@Column(name = "NgayHD")
	private Date ngayHd;

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

	@OneToMany(mappedBy = "hoaDon")
	private List<CTHD> cthds;



}

