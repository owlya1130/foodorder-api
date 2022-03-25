package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.DiscountConfigDao;
import com.example.foodorder.entity.DiscountConfig;
import com.example.foodorder.util.UUIDHelper;

@Service
public class DiscountConfigServiceImpl implements DiscountConfigService {

	@Autowired
	private DiscountConfigDao discountConfigDao;
	
	@Override
	public List<DiscountConfig> findAll() {
		return discountConfigDao.findAll();
	}

	@Transactional
	@Override
	public DiscountConfig save(DiscountConfig entity) {
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		return discountConfigDao.save(entity);
	}

	@Transactional
	@Override
	public DiscountConfig update(DiscountConfig entity) {
		return discountConfigDao.update(entity);
	}

	@Transactional
	@Override
	public DiscountConfig delete(String uid) {
		return discountConfigDao.delete(uid);
	}

}
