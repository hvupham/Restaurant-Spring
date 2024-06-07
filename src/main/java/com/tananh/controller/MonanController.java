package com.tananh.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tananh.exception.MonanException;
import com.tananh.modal.MonAn;
import com.tananh.service.MonAnService;
@RestController
@RequestMapping("/foods")
public class MonanController {
	@Autowired
    private MonAnService monAnService;

	@GetMapping
    public ResponseEntity<List<MonAn>> getAllFoods() {
        List<MonAn> foods = monAnService.getAllMonAn();
        return ResponseEntity.ok(foods);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<MonAn> getFoodById(@PathVariable Integer id) throws MonanException {
		MonAn monan = monAnService.getMonAnById(id);
		return ResponseEntity.ok(monan);
	}
	@PostMapping("/new")
	public ResponseEntity<MonAn> addFood(@RequestParam("file") MultipartFile file,
            @RequestParam("tenMon") String tenMon,
            @RequestParam("loai") String loai,
            @RequestParam("donGia") String donGia,
            @RequestParam("description") String description) {
			MonAn food = new MonAn();
			food.setTenMon(tenMon);
			food.setLoai(loai);
			food.setDonGia(Integer.parseInt(donGia));
			food.setDescription(description);
			
			// Tạo đường dẫn mới dựa trên loại của món ăn
			String folderPath = "D:\\subject\\java\\Project_Restaurant_Java\\src\\Icons\\Food\\" + loai;
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			
			// Lưu ảnh vào thư mục mới
			try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(folderPath + File.separator + file.getOriginalFilename());
			Files.write(path, bytes);
			food.setImage(path.toString());  // Lưu đường dẫn ảnh vào cơ sở dữ liệu
			} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
			}

			MonAn newFood = monAnService.addFood(food);
			return ResponseEntity.status(201).body(newFood);
	}

	@PutMapping("/{id}")
    public ResponseEntity<MonAn> updateFood(
            @PathVariable Integer id,
            @RequestParam("file") MultipartFile file,
            @RequestParam("tenMon") String tenMon,
            @RequestParam("loai") String loai,
            @RequestParam("donGia") Integer donGia,
            @RequestParam("description") String description
    ) {
		MonAn food = new MonAn();
		food.setTenMon(tenMon);
		food.setLoai(loai);
		food.setDonGia(donGia);
		food.setDescription(description);
        try {
            MonAn updatedFood = monAnService.updateFood(id, file, food);
            return ResponseEntity.ok(updatedFood);
        } catch (MonanException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable Integer id) {
        try {
            monAnService.deleteFood(id);
            return ResponseEntity.ok().build();
        } catch (MonanException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
