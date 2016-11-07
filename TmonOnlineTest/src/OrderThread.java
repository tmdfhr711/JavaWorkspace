
import java.util.LinkedList;
import java.util.Queue;

import model.Baristar;
import model.BeverageItem;

/*
 * Create by Lai.OH on 2016.10.19
 */

class OrderThread extends Thread{
	
	//주문들어온 메뉴들을 관리하는 queue
	private Queue<BeverageItem> orderQueue = new LinkedList<BeverageItem>();;
	private Baristar baristar;
		
	public OrderThread(BeverageItem item, Baristar bari){
		this.orderQueue.offer(item);
		this.baristar = bari;
		
		//주문건에 대한 시간을 밀린 주문의 제작하는데 걸린시간에 더해준다.
		baristar.setTotalTime(this.baristar.getTotalTime() + item.getTime());
		
		//바리스타가 받은 주문에 대한 내용 출력
		System.out.println(this.baristar.getName() + "바리스타가 주문을 받았습니다.");
		System.out.println("주문내용 : " + item.getName() + ", 소요시간  " + item.getTime());
		System.out.println("음료를 만들기까지 " + this.baristar.getName() + "바리스타가 걸리는 시간 : " + this.baristar.getTotalTime());
		System.out.println();
	}
	public void run(){
		//바리스타가 제작하는과정
		//제작할 메뉴를 넘겨주고 queue에서 제거해준다.
		baristar.makeBeverage(orderQueue.element());
		orderQueue.poll();
	}
		
}