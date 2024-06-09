package com.tananh.dto;

import com.tananh.modal.CTHD;
import com.tananh.modal.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {


    private User user;

    private String fullName;


    private String note;


    private Integer totalMoney;


    private String shippingAddress;

    private Date shippingDate;

    private String paymentMethod;


}
