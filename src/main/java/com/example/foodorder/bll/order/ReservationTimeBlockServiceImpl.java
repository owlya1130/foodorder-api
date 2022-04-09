package com.example.foodorder.bll.order;

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
public class ReservationTimeBlockServiceImpl implements ReservationTimeBlockService {


	@Autowired
	private CodeDao codeDao;
	
	@Autowired
	private CodeTypeDao codeTypeDao;
	
	@Override
	public List<Code> findAll() {
		return codeDao.findAll("reservation-time-block");
	}

	@Transactional
	@Override
	public Code save(Code entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		
		List<CodeType> codeTypes = this.codeTypeDao.find("reservation-time-block");
		if(codeTypes.size() == 0) {
			System.err.println("CodeType[reservation-time-block]未設定");
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

}
