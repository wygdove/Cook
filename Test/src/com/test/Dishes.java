package com.test;

import java.io.Serializable;
import android.graphics.Bitmap;

public class Dishes implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String dishesID;
	private String dishesName;
	private String dishesMaterial;
	private String dishesIntroduce;
	private String dishesWay;
	private Bitmap dishesImage;
	
	private Dishes dishes;
	
	public Dishes() {}

	public Dishes(Dishes dishes) {
		this.dishes=dishes;
	}
	
	public Dishes(String dishesName,String dishesMaterial,String dishesIntroduce,String dishesWay) {
		this.setDishesName(dishesName);
		this.setDishesMaterial(dishesMaterial);
		this.setDishesIntroduce(dishesIntroduce);
		this.setDishesWay(dishesWay);
	}
	
	public Dishes(String dishesName,String dishesMaterial,String dishesIntroduce,String dishesWay,Bitmap dishesImage) {
		this.setDishesName(dishesName);
		this.setDishesMaterial(dishesMaterial);
		this.setDishesIntroduce(dishesIntroduce);
		this.setDishesWay(dishesWay);
		this.setDishesImage(dishesImage);
	}
	
	public Dishes(String dishesID,String dishesName,String dishesMaterial,String dishesIntroduce,String dishesWay,Bitmap dishesImage) {
		this.setDishesID(dishesID);
		this.setDishesName(dishesName);
		this.setDishesMaterial(dishesMaterial);
		this.setDishesIntroduce(dishesIntroduce);
		this.setDishesWay(dishesWay);
		this.setDishesImage(dishesImage);
	}

	public String getDishesID() {
		return dishesID;
	}

	public void setDishesID(String dishesID) {
		this.dishesID = dishesID;
	}

	public String getDishesName() {
		return dishesName;
	}

	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}

	public String getDishesMaterial() {
		return dishesMaterial;
	}

	public void setDishesMaterial(String dishesMaterial) {
		this.dishesMaterial = dishesMaterial;
	}

	public String getDishesIntroduce() {
		return dishesIntroduce;
	}

	public void setDishesIntroduce(String dishesIntroduce) {
		this.dishesIntroduce = dishesIntroduce;
	}

	public String getDishesWay() {
		return dishesWay;
	}

	public void setDishesWay(String dishesWay) {
		this.dishesWay = dishesWay;
	}

	public Bitmap getDishesImage() {
		return dishesImage;
	}

	public void setDishesImage(Bitmap dishesImage) {
		this.dishesImage = dishesImage;
	}
	
	
}
