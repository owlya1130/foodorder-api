package com.example.foodorder.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
public class Meal {

	@Id
	@Column(name = "uid")
	private String uid;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "classificationUid")
	private Code classification;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "mealUid")
	private List<MealIngredient> mealIngredients;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<MealIngredient> getMealIngredients() {
		return mealIngredients;
	}

	public void setMealIngredients(List<MealIngredient> mealIngredients) {
		this.mealIngredients = mealIngredients;
	}

	public Code getClassification() {
		return classification;
	}

	public void setClassification(Code classification) {
		this.classification = classification;
	}

}
