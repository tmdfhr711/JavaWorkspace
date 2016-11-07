package model;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Create by Lai.OH on 2016.10.19
 */

public class Baristar {

	private String name;
	private int totalTime;

	
	public Baristar(String name, int totalTime) {
		super();
		this.name = name;
		this.totalTime = totalTime;
	}
	public String getName() {
		return name;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public synchronized void makeBeverage(BeverageItem menu){
		try{
			Thread.sleep(menu.getTime()*1000);
			this.setTotalTime(this.getTotalTime() - menu.getTime());
			System.out.println("*********************************************************");
			System.out.println(this.getName() + "바리스타가 " + menu.getName() +"를 제작하였습니다, 남은 제작시간 : " + this.totalTime );
			System.out.println("*********************************************************");
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	
	}
	
}
