package basic.composition.defaultmethod;

public interface Sell {
	void sell();
	
	default void order() {		// default method, duplicate method..
		System.out.println("seller order()...");
	}

}
