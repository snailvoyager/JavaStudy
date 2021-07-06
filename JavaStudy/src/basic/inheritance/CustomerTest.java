package basic.inheritance;

public class CustomerTest {

	public static void main(String[] args) {
		Customer custom = new Customer();
		System.out.println(custom.calc(10000));
		
		VIPCustomer customVIP = new VIPCustomer();
		System.out.println(customVIP.calc(10000));			//자식 객체에서 재정의된 메소드 호출
		System.out.println("VIP Bonus Point :" + customVIP.getBonusPoint());
		
		Customer custom2 = new VIPCustomer();
		System.out.println(custom2.calc(10000));			//자식 객체에서 재정의된 메소드 호출
		//System.out.println(custom2.getBonusPoint());		//Customer 객체에서 VIP 인스턴스 메소드 호출 불가
	}

}
