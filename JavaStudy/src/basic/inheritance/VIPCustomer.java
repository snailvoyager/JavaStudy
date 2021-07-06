package basic.inheritance;

public class VIPCustomer extends Customer{
	
	int bonusPoint;
	
	public VIPCustomer() {
		this.customerGrade = "VIP";
		this.salesRatio = 0.05;
		this.bonusPoint = 100;
	}
	
	@Override
	public int calc(int price) {
		return price - (int)(price * salesRatio) - bonusPoint;
	}
	
	public int getBonusPoint() {
		return this.bonusPoint;
	}
}
