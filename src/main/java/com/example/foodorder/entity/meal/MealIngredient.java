package com.example.foodorder.entity.meal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "meal_ingredient")
public class MealIngredient {

	@EmbeddedId
	private MealIngredientId uid = new MealIngredientId();

	@Column(name = "ingredientQty")
	private int ingredientQty;

	public MealIngredientId getUid() {
		return uid;
	}

	public void setUid(MealIngredientId uid) {
		this.uid = uid;
	}

	public int getIngredientQty() {
		return ingredientQty;
	}

	public void setIngredientQty(int ingredientQty) {
		this.ingredientQty = ingredientQty;
	}

}
