package com.tananh.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
	private Long id;
    private String matkhau;
    private String trangthai;
    private String email;
    private String username;
    private String vaitro;
    private Long idkh;

}
