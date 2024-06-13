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
public class MonAnService implements IMonAnService {
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
	public MonAn updateFood(Integer id, MonAn monAnUpdate) throws MonanException {
		MonAn monAn = getMonAnById(id);
		monAn.setTenMon(monAnUpdate.getTenMon());
		monAn.setLoai(monAnUpdate.getLoai());
		monAn.setDonGia(monAnUpdate.getDonGia());
		monAn.setDescription(monAnUpdate.getDescription());
		monAn.setImage(monAnUpdate.getImage());
		return monAnRepository.save(monAn);

    }
	@Override
	public void deleteFood(Integer id) throws MonanException{
		MonAn monAn = getMonAnById(id);

		monAnRepository.delete(monAn);
	}


}
