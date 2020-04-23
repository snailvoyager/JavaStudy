package basic;

public class BitOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt("0111", 2));	//2진수 -> 10진수
		System.out.println(Integer.toBinaryString(7));	//10진수 -> 2진수
		System.out.println();
		int a = 7;	//0111;
		int b = 2;	//0010;
		
		System.out.println("AND : " + (a&b));	//0010
		System.out.println("OR : " + (a|b));	//0111
		System.out.println("XOR : " + (a^b));	//0101
		System.out.println();
		
		System.out.println("Byte Max : " + Byte.MAX_VALUE);		//8bit
		System.out.println("Short Max : " + Short.MAX_VALUE);	//16bit
		System.out.println("Int Max : " + Integer.MAX_VALUE);	//32bit
		System.out.println("Long Max : " + Long.MAX_VALUE);		//64bit
		System.out.println();
		
		System.out.println("int 비트전환: " + Integer.toBinaryString(~a));		//-8, 32bit
		System.out.println("long 비트전환 : " + Long.toBinaryString(~7));			//-8, 64bit
		System.out.println();
		
		System.out.println(3<<2);	//3 * 2^2, 0011 -> 1100
		System.out.println(12>>2);	//12 / 2^2, 1100 -> 0011
		System.out.println();
		
		System.out.println((-4) + " : " + Integer.toBinaryString(-4));
		System.out.println((-4>>2) + " : " + Integer.toBinaryString(-4>>2));
		System.out.println((-4>>>2) + " : " + Integer.toBinaryString(-4>>>2));	//unsigned right shift
		System.out.println();
		
		for(int i=0; i<8; i++) {
			System.out.println(i + " : " + Integer.toBinaryString(i));
		}
		System.out.println();
		
		for(int i=0; i<8; i++) {		//2^i
			System.out.println("1<<" + i + " : " + (1<<i) + " : " + Integer.toBinaryString(1<<i));
		}
	}

}
