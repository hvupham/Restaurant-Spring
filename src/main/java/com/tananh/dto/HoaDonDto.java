package com.tananh.dto;

import com.tananh.modal.CTHD;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonDto {

    private Long idHoaDon;

    private Integer idKh;

    private Long idBan;

    private Date ngayHd;

    private Integer tienMonAn;

    private String codeVoucher;

    private Integer tienGiam;

    private Integer tongTien;


}
