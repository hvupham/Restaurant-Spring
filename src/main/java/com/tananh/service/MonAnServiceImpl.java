package com.tananh.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tananh.exception.MonanException;
import com.tananh.modal.MonAn;
import com.tananh.respository.MonAnRepository;
@Service
public class MonAnServiceImpl implements MonAnService{
	 @Autowired
	  private MonAnRepository monAnRepository;
	@Override
	public List<MonAn> getAllMonAn() {
		 return monAnRepository.findAll();
	}
	@Override
	public MonAn getMonAnById(Integer id) throws MonanException{
		Optional<MonAn> monan = monAnRepository.findById(id);
		if(monan.isPresent()) {
			return monan.get();
		}
		throw new MonanException("Không tồn tại món ăn với ID: "+id);
	}
	@Override
	public MonAn addFood(MonAn food) {
		// TODO Auto-generated method stub
		return monAnRepository.save(food);
	}
	
	@Override
	public MonAn updateFood(Integer id, MultipartFile file, MonAn foodDetails) throws MonanException {
        MonAn existingFood = getMonAnById(id);
               

        // Cập nhật thông tin của món ăn từ foodDetails
        existingFood.setTenMon(foodDetails.getTenMon());
        existingFood.setLoai(foodDetails.getLoai());
        existingFood.setDonGia(foodDetails.getDonGia());
        existingFood.setDescription(foodDetails.getDescription());

        // Nếu có ảnh mới được gửi từ frontend, lưu ảnh mới và cập nhật đường dẫn ảnh trong món ăn
        if (file != null && !file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            try {
                String uploadDir = "D:/subject/java/Project_Restaurant_Java/src/Icons/Food";
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                try (InputStream inputStream = file.getInputStream()) {
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                    existingFood.setImage(filePath.toString());
                }
            } catch (IOException e) {
                throw new MonanException("Could not save file " + fileName + ". Please try again!");
            }
        }

        // Lưu cập nhật vào cơ sở dữ liệu
        return monAnRepository.save(existingFood);
    }
	@Override
	public void deleteFood(Integer id) throws MonanException{
		// TODO Auto-generated method stub
		MonAn food = getMonAnById(id);
		monAnRepository.delete(food);
	}


}
