package basic.singleton;

public class Company {
	
	private static Company instance = new Company();	//클래스 내부에 유일한 private instance 생성 
	
	private Company() {		//생성자는 private 
		
	}
	
	public static Company getInstance() {		//외부에서 유일한 인스턴스를 참조할 수 있는 public 메서드 제공
		return instance;
	}

	public static void main(String[] args) {
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();
		
		System.out.println(company1);
		System.out.println(company2); 		//유일한 인스턴스를 가져와서 동일
	}

}
