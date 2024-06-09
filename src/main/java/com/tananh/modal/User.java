package com.tananh.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Nguoidung")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ND")
    private Long id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Matkhau")
    private String matKhau;

    @Column(name = "username")
    private String username;
    
    @Column(name = "Verifycode")
    private String verifyCode;

    @Column(name = "Trangthai")
    private String trangThai;

    @Column(name = "Vaitro")
    private String vaiTro;

	public Long getId() {
		return id;
	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public User(Long id, String email, String matKhau, String username, String verifyCode, String trangThai,
			String vaiTro) {
		super();
		this.id = id;
		this.email = email;
		this.matKhau = matKhau;
		this.username = username;
		this.verifyCode = verifyCode;
		this.trangThai = trangThai;
		this.vaiTro = vaiTro;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
    
}
