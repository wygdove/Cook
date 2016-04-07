package com.cook.bean;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userID;
	private String userName;
	private String userPassword;
	private String userPhotoSrc;
    private static boolean isLogin;
	
	public User() {}
	
	public User(String userName,String userPassword) {
		this.setUserName(userName);
		this.setUserPassword(userPassword);
	}
	
	public User(String userID,String userName,String userPassword) {
		this.setUserID(userID);
		this.setUserName(userName);
		this.setUserPassword(userPassword);
	}
	
	public User(String userID,String userName,String userPassword,String userPhotoSrc) {
		this.setUserID(userID);
		this.setUserName(userName);
		this.setUserPassword(userPassword);
		this.setUserPhotoSrc(userPhotoSrc);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhotoSrc() {
		return userPhotoSrc;
	}

	public void setUserPhotoSrc(String userPhotoSrc) {
		this.userPhotoSrc = userPhotoSrc;
	}

	public static boolean getIsLogin() {
		return isLogin;
	}

	public static void setIsLogin(boolean isLogin) {
		isLogin = isLogin;
	}

	
}