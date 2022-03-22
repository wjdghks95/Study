package ch06;

public class OrderTest {

	public static void main(String[] args) {

		Order myOrder = new Order();
		myOrder.orderNumber = "202011020003";
		myOrder.customerPhone = "01027999308";
		myOrder.customerAddress = "고양시 일산서구 탄중로 501";
		myOrder.price = 25000;
		myOrder.menuId = "0003";
		
		myOrder.showOrderDetail();
		
	}

}
