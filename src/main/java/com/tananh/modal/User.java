package com.tananh.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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


}
