package com.pp.user;

import java.util.Map;

import javax.websocket.Session;

public class Player {
	private final Integer userId;
	private final Session session;
	
	private String userName;
	private Integer userPic;	//player's photo

	private Short userCardsNow[] = new Short[15];
	
	private Integer hpMax;		//player's max blood volume
	private Integer engMax;		//player's max energy 
	private Integer hp;			//player's current blood volume
	private Integer energy;		//player's current energy
	private Integer harm;		//harms to palyer


	private Integer x;			//player's current location
	private Integer y;

	
	private Integer hexColor;	//player's color
	
	private Map buff;			//player's buff

	
	
	public Player(User user, Session session) {
		this.userId = user.getUserId();
		this.session = session;
		this.userName = user.getUserName();
		this.userCardsNow = user.getUserCardsNow();
		this.userPic = user.getUserPic();
	}

	public synchronized Integer getUserId() {
		return userId;
	}

	public synchronized Session getSession() {
		return session;
	}

	public synchronized String getUserName() {
		return userName;
	}

	public synchronized Short[] getUserCardsNow() {
		return userCardsNow;
	}

	public synchronized void setUserCardsNow(Short[] userCardsNow) {
		this.userCardsNow = userCardsNow;
	}

	public synchronized Integer getHp(){
		return hp;
	}

	//setting current hp should not exceed hpMax
	public synchronized void setHp(Integer hp){
		if(hp > 0 && hp <= this.hpMax){
			this.hp = hp;
		}else if(hp > this.hpMax){
			this.hp = this.hpMax;
		}else{
			this.hp = 0;
			this.die();
		}
	}

	public synchronized Integer getHpMax() {
		return hpMax;
	}

	public synchronized void setHpMax(Integer hpMax) {
		this.hpMax = hpMax;
	}

	public synchronized Integer getEngMax() {
		return engMax;
	}

	public synchronized void setEngMax(Integer engMax) {
		this.engMax = engMax;
	}

	public synchronized Integer getEnergy() {
		return energy;
	}

	public synchronized void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public synchronized Integer getX() {
		return x;
	}

	public synchronized void setX(Integer x) {
		this.x = x;
	}

	public synchronized Integer getY() {
		return y;
	}

	public synchronized void setY(Integer y) {
		this.y = y;
	}

	public synchronized Integer getHexColor() {
		return hexColor;
	}

	public synchronized void setHexColor(Integer hexColor) {
		this.hexColor = hexColor;
	}

	public synchronized Map getBuff() {
		return buff;
	}

	public synchronized void setBuff(Map buff) {
		this.buff = buff;
	}

	/**
	 * player round
	 * 
	 */
	private int turn = 0;		//number of player rounds
	private int cardTurn = 16;
	
	public int getTurn(){
		return turn;
	}

	//START OF THE TURE
	public void turnStart(){
		turn++;
		cardTurn += 5;
		if (cardTurn >= 15) {
			cardTurn = 0;
			cardChange();
		}
	}

	//在一轮洗好的牌中卡牌的轮数，当轮数到3时意味着卡牌用完，应该立刻洗牌
	public int getCardTurn() {
		return cardTurn;
	}
	
	/*
	 * 洗牌的方法，洗完牌是cardTurn应置为0
	 * 通过数组的随机排序实现洗牌效果
	 */
	public void cardChange(){
		short temp;
		short temp2;
		for(int i =15;i>0;i--){
			temp2 = (short)(Math.random()*i);
			temp = userCardsNow[temp2];
			userCardsNow[temp2] = userCardsNow[i-1];
			userCardsNow[i-1]= temp;
		}
		cardTurn = 0;
	}
	
	//alive or die
	private boolean isAlive =true;

	public boolean isAlive(){
		return isAlive;
	}
	
	/*
	 * die DMO
	 */
	protected void die(){
		this.isAlive =false;
	};
	

}
