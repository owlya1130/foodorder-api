package com.example.foodorder.entity.ingredient;

public enum IngredientActionType {
	Restock(0, "Restock"),
	Expired(1, "Expired"),
	PackagedFrom(2, "PackagedFrom"),
	PackagedTo(3, "PackagedTo"),
	Sold(4, "Sold");
	
	private int id;
    private String name;
	
	IngredientActionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
