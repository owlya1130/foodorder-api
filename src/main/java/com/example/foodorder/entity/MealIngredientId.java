package com.example.foodorder.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MealIngredientId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "mealUid")
    private String mealUid;

    @Column(name = "ingredientUid")
    private String ingredientUid;

	public String getMealUid() {
		return mealUid;
	}

	public void setMealUid(String mealUid) {
		this.mealUid = mealUid;
	}

	public String getIngredientUid() {
		return ingredientUid;
	}

	public void setIngredientUid(String ingredientUid) {
		this.ingredientUid = ingredientUid;
	}
    
    

}
