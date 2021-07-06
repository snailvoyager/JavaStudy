package basic.inheritance;

public class Customer {
	
	protected String customerGrade;
	protected double salesRatio;
	
	public Customer() {
		this.customerGrade = "SILVER";
		this.salesRatio = 0.01;
	}
	
	public int calc(int price) {
		return price - (int)(price * salesRatio);
	}
	
}
