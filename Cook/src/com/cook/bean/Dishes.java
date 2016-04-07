package com.cook.bean;

import java.io.Serializable;
import android.graphics.Bitmap;

public class Dishes implements Serializable,Comparable {
	
	private static final long serialVersionUID = 1L;

	private String dishesID;
	private String dishesName;
	private String dishesMaterial;
	private String dishesIntroduce;
	private String dishesWay;
	private byte[] dishesImage;
	
	public Dishes() {}
	
	public Dishes(String dishesName,String dishesMaterial,String dishesIntroduce,String dishesWay) {
		this.setDishesName(dishesName);
		this.setDishesMaterial(dishesMaterial);
		this.setDishesIntroduce(dishesIntroduce);
		this.setDishesWay(dishesWay);
	}
	
	public Dishes(String dishesName,String dishesMaterial,String dishesIntroduce,String dishesWay,byte[] dishesImage) {
		this.setDishesName(dishesName);
		this.setDishesMaterial(dishesMaterial);
		this.setDishesIntroduce(dishesIntroduce);
		this.setDishesWay(dishesWay);
		this.setDishesImage(dishesImage);
	}
	
	public Dishes(String dishesID,String dishesName,String dishesMaterial,String dishesIntroduce,String dishesWay,byte[] dishesImage) {
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

	public byte[] getDishesImage() {
		return dishesImage;
	}

	public void setDishesImage(byte[] dishesImage) {
		this.dishesImage = dishesImage;
	}
	

	@Override
	public int compareTo(Object arg0) {
		Dishes d=(Dishes) arg0;
		int i=this.dishesName.compareTo(d.dishesName);
		if(i>0) {
			return 1;
		}
		else if(i<0) {
			return -1;
		}
		return 0;
	}

}
