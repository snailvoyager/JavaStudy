package basic.composition.defaultmethod;

public class CustomerTest {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.buy();
		customer.sell();
		customer.order();			//자식에서 재정의된 default method
		
		Buy buyer = customer;
		buyer.buy();				//부모 인스턴스에서 가능한 method만 가능
		buyer.order();				//자식에서 재정의된 default method
		
		Sell seller = customer;
		seller.sell();
		seller.order();				//자식에서 재정의된 default method
		
	}

}
