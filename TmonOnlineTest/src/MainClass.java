import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Baristar;
import model.BeverageItem;

/*
 * Create by Lai.OH on 2016.10.19
 */
public class MainClass {

	/*
	 * 바리스타 및 음료 정보초기화
	 */
	private static Baristar[] baristarInfo = {
			new Baristar("A", 0),
			new Baristar("B", 0),
			new Baristar("C", 0),
			new Baristar("D", 0)
	};
	private static BeverageItem[] beverage = {
			new BeverageItem(1,"에스프레소", 2),
			new BeverageItem(2,"아메리카노", 3),
			new BeverageItem(3,"과일주스", 5),
			new BeverageItem(4,"카페라떼", 4)
	};
	
	private static ArrayList<BeverageItem> orderList = new ArrayList<BeverageItem>();
	private static ArrayList<Baristar> baristars = new ArrayList<Baristar>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	
		//메뉴 주문
		for(int i = 0; i < orderList.size(); i++){
			order(orderList.get(i));
		}
	}
	
	private static void init(){
		baristars.add(baristarInfo[0]);
		baristars.add(baristarInfo[1]);
		baristars.add(baristarInfo[2]);
		baristars.add(baristarInfo[3]);
		
		/*
		 * 주문할 메뉴들의 dummy data
		 */
		orderList.add(beverage[0]);
		orderList.add(beverage[1]);
		orderList.add(beverage[1]);
		orderList.add(beverage[0]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[0]);
		orderList.add(beverage[1]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[1]);
		orderList.add(beverage[1]);
		orderList.add(beverage[0]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[1]);
		orderList.add(beverage[3]);
		orderList.add(beverage[1]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[1]);
		orderList.add(beverage[0]);
		orderList.add(beverage[1]);
		orderList.add(beverage[1]);
		orderList.add(beverage[0]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[1]);
		orderList.add(beverage[3]);
		orderList.add(beverage[1]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[1]);
		orderList.add(beverage[0]);
		orderList.add(beverage[1]);
		orderList.add(beverage[1]);
		orderList.add(beverage[0]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[3]);
		orderList.add(beverage[2]);
		orderList.add(beverage[1]);
		orderList.add(beverage[3]);
		orderList.add(beverage[1]);
		orderList.add(beverage[2]);
		orderList.add(beverage[3]);
		orderList.add(beverage[1]);
		
	}
	
	private static void order(BeverageItem item){
		//현재 바리스타들중 시간이 가장 적게 남은 바리스타 선별
		Collections.sort(baristars, new NoAscCompare());
		
		//주문 음료 및 선별된 바리스타를 parameter로 넘겨 제작하는 thread
		OrderThread thread = new OrderThread(item, baristars.get(0));
		thread.start();
		
	}
	
	static class NoAscCompare implements Comparator<Baristar> {
		/**
		 * 오름차순(ASC)
		 */
		@Override
		public int compare(Baristar arg0, Baristar arg1) {
			// TODO Auto-generated method stub
			return arg0.getTotalTime() < arg1.getTotalTime() ? -1 : arg0.getTotalTime() > arg1.getTotalTime() ? 1:0;
		}
 
	}

}
