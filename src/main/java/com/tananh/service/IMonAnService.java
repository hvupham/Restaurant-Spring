package com.tananh.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tananh.exception.MonanException;
import com.tananh.modal.MonAn;

public interface IMonAnService {
	 public List<MonAn> getAllMonAn();
	 public MonAn getMonAnById(Integer id) throws MonanException;
	 public MonAn addFood(MonAn food);
	 public MonAn updateFood(Integer id, MonAn foodDetails) throws MonanException;
	 public void deleteFood(Integer id)throws MonanException;
}
