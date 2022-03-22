package ch06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	
	public String orderNumber;
	public String customerPhone;
	public String customerAddress;
	public int price;
	public String menuId;
	
	public void showOrderDetail() {
		
		System.out.println("주문 접수 번호: " + orderNumber);
		System.out.println("주문 핸드폰 번호: " + customerPhone);
		System.out.println("주문 집 주소: " + customerAddress);
		System.out.println("주문 날짜: " + CurrentTime.getCurrentDate());
		System.out.println("주문 시간: " + CurrentTime.getCurrentTime());
		System.out.println("주문 가격: " + price);
		System.out.println("메뉴 번호: " + menuId);
	}
	
	class CurrentTime {
		
		static Date today = new Date();
		
		static String getCurrentDate() {
			
			SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
			
			return date.format(today);
		}
		
		static String getCurrentTime() {
			
			SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
			
			return time.format(today);
		}
	}
	
}

