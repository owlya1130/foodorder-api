package com.example.foodorder.bll.meal;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.code.CodeDao;
import com.example.foodorder.dao.code.CodeTypeDao;
import com.example.foodorder.entity.code.Code;
import com.example.foodorder.entity.code.CodeType;
import com.example.foodorder.util.UUIDHelper;

@Service
public class MealClassificationServiceImpl implements MealClassificationService {

	@Autowired
	private CodeDao codeDao;
	
	@Autowired
	private CodeTypeDao codeTypeDao;
	
	@Override
	public List<Code> findAll() {
		return codeDao.findAll("meal-classification");
	}

	@Transactional
	@Override
	public Code save(Code entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		
		List<CodeType> codeTypes = this.codeTypeDao.find("meal-classification");
		if(codeTypes.size() == 0) {
			System.err.println("CodeType[meal-classification]未設定");
			return null;
		} else {
			entity.setType(codeTypes.get(0));
			return codeDao.save(entity);
		}
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
