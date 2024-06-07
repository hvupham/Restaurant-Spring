package com.tananh.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonAnDto {
    private String tenMon;

    private Integer donGia;

    private String loai;

    private String trangThai;


    private String Description;
    private MultipartFile file;
}
