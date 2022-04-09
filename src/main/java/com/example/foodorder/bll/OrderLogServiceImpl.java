package com.example.foodorder.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.bll.ingredient.IngredientService;
import com.example.foodorder.bll.meal.MealService;
import com.example.foodorder.dao.OrderLogDao;
import com.example.foodorder.entity.ingredient.BOConsume;
import com.example.foodorder.entity.ingredient.IngredientActionType;
import com.example.foodorder.entity.meal.Meal;
import com.example.foodorder.entity.meal.MealIngredient;
import com.example.foodorder.entity.order.OrderLog;
import com.example.foodorder.entity.order.OrderLogDetail;
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
		for (OrderLogDetail detail : entity.getDetails()) {
			detail.setUid(UUIDHelper.getUUID());
			detail.setOrderLogUid(uid);

			int orderQty = detail.getOrderQty();
			Meal orderMeal = detail.getMeal();

			Meal mealEntity = mealService.find(orderMeal.getUid());
			for (MealIngredient mealIngredient : mealEntity.getMealIngredients()) {
				BOConsume consumeBO = new BOConsume();
				consumeBO.setUid(mealIngredient.getUid().getIngredientUid());
				consumeBO.setActionType(IngredientActionType.Sold);
				consumeBO.setQty(mealIngredient.getIngredientQty() * orderQty);
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
