package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.OrderLogDao;
import com.example.foodorder.entity.Ingredient4ConsumeBO;
import com.example.foodorder.entity.Ingredient4ConsumeBO.ConsumeType;
import com.example.foodorder.entity.Meal;
import com.example.foodorder.entity.MealIngredient;
import com.example.foodorder.entity.OrderLog;
import com.example.foodorder.entity.OrderLogDetail;
import com.example.foodorder.util.UUIDHelper;

@Service
public class OrderLogServiceImpl implements OrderLogService {

	@Autowired
	private OrderLogDao orderLogDao;
	
	@Autowired
	private MealService mealService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Override
	public List<OrderLog> findAll() {
		return orderLogDao.findAll();
	}

	@Transactional
	@Override
	public OrderLog save(OrderLog entity) throws Exception {
		String batchno = UUIDHelper.getBatchNo();
		String uid = UUIDHelper.getUUID();
		entity.setUid(uid);
		for(OrderLogDetail detail: entity.getDetails()) {
			detail.setUid(UUIDHelper.getUUID());
			detail.setOrderLogUid(uid);
			
			// 扣除食材
			int orderQty = detail.getOrderQty();
			Meal orderMeal = detail.getMeal();
			
			Meal mealEntity = mealService.find(orderMeal.getUid());
			for(MealIngredient mealIngredient: mealEntity.getMealIngredients()) {
				int ingredientQty = mealIngredient.getIngredientQty();
				
				Ingredient4ConsumeBO consumeBO = new Ingredient4ConsumeBO();
				consumeBO.setAction(ConsumeType.Sold);
				consumeBO.setUid(mealIngredient.getUid().getIngredientUid());
				consumeBO.setQty(ingredientQty*orderQty);
				consumeBO.setComment("orderlogUid: " + uid);
				ingredientService.consume(consumeBO, batchno);
			}
		}
		return orderLogDao.save(entity);
	}

	@Transactional
	@Override
	public OrderLog update(OrderLog entity) {
		return orderLogDao.update(entity);
	}

	@Transactional
	@Override
	public OrderLog delete(String uid) {
		return orderLogDao.delete(uid);
	}

}
