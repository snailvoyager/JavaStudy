package basic.composition.defaultmethod;

public class Customer implements Sell, Buy{

	@Override
	public void buy() {

		System.out.println("Customer buy()...");
	}
	
	@Override
	public void sell() {

		System.out.println("Customer sell()...");
	}

	@Override
	public void order() {		//중복된 Default method 재정의

		System.out.println("Customer order()...");
	}
	
	
}
