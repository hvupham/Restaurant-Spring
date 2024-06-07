package com.tananh.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tananh.dto.MonAnDto;
import jakarta.validation.Valid;
import org.aspectj.weaver.StandardAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

	@PostMapping(value = "/upload",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	)
	public ResponseEntity<?> uploadImages(
			@Valid @ModelAttribute MonAnDto monAnDto,

			BindingResult result
	) throws MonanException {
		try {
			MultipartFile file = monAnDto.getFile();
			// Kiểm tra nếu file trống
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File rỗng");
			}
//			MonAn existingMonAn = monAnService.getMonAnById(monAnId);

            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")){
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                        .body("file must be an image");
            }
			String fileName = storeFile(file);


			return ResponseEntity.ok("ok");

        }

		catch (Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	@GetMapping("/images/{imageName}")
	public ResponseEntity<?> viewImage(@PathVariable String imageName) {
		try {
			java.nio.file.Path imagePath = Paths.get("uploads/"+imageName);
			UrlResource resource = new UrlResource(imagePath.toUri());

			if (resource.exists()) {
				return ResponseEntity.ok()
						.contentType(MediaType.IMAGE_JPEG)
						.body(resource);
			} else {
				return ResponseEntity.ok()
						.contentType(MediaType.IMAGE_JPEG)
						.body(new UrlResource(Paths.get("uploads/notfound.jpg").toUri()));
				//return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	// Ham luu file
	private String storeFile(MultipartFile file) throws  IOException {
		// doi ten file de tranh up trung lap
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		String uniqueFileName = UUID.randomUUID().toString() + "_" + filename;
		java.nio.file.Path uploadDir = Paths.get("uploads");
		if (!Files.exists(uploadDir)){
			Files.createDirectories(uploadDir);

		}
		java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
		Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
		return uniqueFileName;


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
