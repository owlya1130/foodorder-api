package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.CodeDao;
import com.example.foodorder.entity.Code;
import com.example.foodorder.util.UUIDHelper;

@Service
public class MealClassificationServiceImpl implements MealClassificationService {

	@Autowired
	private CodeDao codeDao;
	
	@Override
	public List<Code> findAll() {
		return codeDao.findAll();
	}

	@Transactional
	@Override
	public Code save(Code entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		return codeDao.save(entity);
	}

	@Transactional
	@Override
	public Code update(Code entity) {
		return codeDao.update(entity);
	}

	@Transactional
	@Override
	public Code delete(String uid) {
		return codeDao.delete(uid);
	}

}
