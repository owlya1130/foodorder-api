package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.DinningTableDao;
import com.example.foodorder.entity.DinningTable;
import com.example.foodorder.util.UUIDHelper;

@Service
public class DinningTableServiceImpl implements DinningTableService {

	@Autowired
	private DinningTableDao dinningTableDao;
	
	@Override
	public List<DinningTable> findAll() {
		return dinningTableDao.findAll();
	}

	@Transactional
	@Override
	public DinningTable save(DinningTable entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		return dinningTableDao.save(entity);
	}

	@Transactional
	@Override
	public DinningTable update(DinningTable entity) {
		return dinningTableDao.update(entity);
	}

	@Transactional
	@Override
	public DinningTable delete(String uid) {
		return dinningTableDao.delete(uid);
	}

}
