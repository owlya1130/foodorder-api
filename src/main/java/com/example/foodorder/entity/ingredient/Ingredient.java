package com.example.foodorder.entity.ingredient;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ingredient")
public class Ingredient {

	@Id
	@Column(name="uid")
	private String uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="packageByUID")
	private String packageByUID;
	
	@Column(name="packageQty")
	private int packageQty;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="ingredientUid")
	private List<IngredientQuantity> quantityDetails;

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

	public String getPackageByUID() {
		return packageByUID;
	}

	public void setPackageByUID(String packageByUID) {
		this.packageByUID = packageByUID;
	}

	public int getPackageQty() {
		return packageQty;
	}

	public void setPackageQty(int packageQty) {
		this.packageQty = packageQty;
	}

	public List<IngredientQuantity> getQuantityDetails() {
		return quantityDetails;
	}

	public void setQuantityDetails(List<IngredientQuantity> quantityDetails) {
		this.quantityDetails = quantityDetails;
	}
}
