package com.tananh.dto;

public class UserDto {
	private Integer id;
    private String matkhau;
    private String trangthai;
    private String email;
    private String username;
    private String vaitro;
    
    
    
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(Integer id, String matkhau, String trangthai, String email, String username, String vaitro) {
		super();
		this.id = id;
		this.matkhau = matkhau;
		this.trangthai = trangthai;
		this.email = email;
		this.username = username;
		this.vaitro = vaitro;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVaitro() {
		return vaitro;
	}
	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    
}
