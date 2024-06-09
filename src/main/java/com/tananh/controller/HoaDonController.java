package com.tananh.controller;

import com.tananh.dto.HoaDonDto;
import com.tananh.modal.HoaDon;
import com.tananh.service.HoaDonService;
import com.tananh.service.IHoaDonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class HoaDonController {
    private final IHoaDonService hoaDonService;
    @PostMapping()
    public ResponseEntity<?> creatHoaDon(
            @Valid @RequestBody HoaDonDto hoaDonDto,
            BindingResult result
            ){
        try{
            if(result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }

            HoaDon hoaDon = hoaDonService.createHoaDon(hoaDonDto);
            return ResponseEntity.ok(hoaDon);

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
