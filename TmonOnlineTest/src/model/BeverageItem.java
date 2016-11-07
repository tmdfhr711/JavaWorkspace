package model;

/*
 * Create by Lai.OH on 2016.10.19
 */

public class BeverageItem {

	private int id;
	private String name;
	private int time;
	
	public BeverageItem(int id, String name, int time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}


	public String getName() {
		return name;
	}

	public int getTime() {
		return time;
	}


	public int getId() {
		return id;
	}


	
}
