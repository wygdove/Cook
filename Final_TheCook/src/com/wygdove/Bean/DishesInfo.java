package com.wygdove.Bean;

import java.io.Serializable;

public class DishesInfo implements Serializable{

	private String dishes_name;
	private String dishes_introduce;
	private String dishes_mainMaterial;
	private String dishes_secondarymaterial;
	private String dishes_steps;
	private int image;
	
	public DishesInfo() {}
	public DishesInfo(int i,String dishes_name,String dishes_steps) {
		this.image=i;
		this.dishes_name = dishes_name;
		this.dishes_steps = dishes_steps;
	}

	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getDishes_name() {
		return dishes_name;
	}

	public void setDishes_name(String dishes_name) {
		this.dishes_name = dishes_name;
	}

	public String getDishes_introduce() {
		return dishes_introduce;
	}

	public void setDishes_introduce(String dishes_introduce) {
		this.dishes_introduce = dishes_introduce;
	}

	public String getDishes_mainMaterial() {
		return dishes_mainMaterial;
	}

	public void setDishes_mainMaterial(String dishes_mainMaterial) {
		this.dishes_mainMaterial = dishes_mainMaterial;
	}

	public String getDishes_secondarymaterial() {
		return dishes_secondarymaterial;
	}

	public void setDishes_secondarymaterial(String dishes_secondarymaterial) {
		this.dishes_secondarymaterial = dishes_secondarymaterial;
	}

	public String getDishes_steps() {
		return dishes_steps;
	}

	public void setDishes_steps(String dishes_steps) {
		this.dishes_steps = dishes_steps;
	}
	
}
