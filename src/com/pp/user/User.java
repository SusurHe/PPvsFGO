package com.pp.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {	
	private String userEmail; 		// user's email
	private String password; 		//user's password
	private Map oldPassword = new HashMap(); 	//previous passwords
	private String userName;		//user's name
	private Integer userAge;		//user's age
	private boolean userSix;		//user's six
	private Integer userPic; 		//user's photo
	private String userExp;			//user's Exp
	private String userClass;		//user's Class
	private Short userCardsNow[];	//user's current card group
	private Integer userId; 		//user's id (primay key)
	private List userCards = new ArrayList();

	public synchronized Integer getUserId() {
		return userId;
	}
	
	public synchronized void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public synchronized String getUserEmail() {
		return userEmail;
	}
	
	public synchronized void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public synchronized String getPassword() {
		return password;
	}
	
	public synchronized void setPassword(String password) {
		this.password = password;
	}
	
	public synchronized Map getOldPassword() {
		return oldPassword;
	}
	
	public synchronized void setOldPassword(Map oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public synchronized String getUserName() {
		return userName;
	}
	
	public synchronized void setUserName(String userName) {
		this.userName = userName;
	}
	
	public synchronized Integer getUserPic() {
		return userPic;
	}
	
	public synchronized void setUserPic(Integer userPic) {
		this.userPic = userPic;
	}
	
	public synchronized String getUserExp() {
		return userExp;
	}
	
	public synchronized void setUserExp(String userExp) {
		this.userExp = userExp;
	}
	
	public synchronized String getUserClass() {
		return userClass;
	}
	
	public synchronized void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	
	public synchronized Short[] getUserCardsNow() {
		return userCardsNow;
	}
	
	public void setUserCardNow(Short[] userCardNow) {
		this.userCardsNow = userCardsNow;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer age) {
		this.userAge = age;
	}

	public boolean isUserSix() {
		return userSix;
	}

	public void setUserSix(boolean six) {
		this.userSix = six;
	}

	public List getUserCaerd() {
		return userCards;
	}

	public void setUserCaerd(List userCaerd) {
		this.userCards = userCards;
	}	
}
