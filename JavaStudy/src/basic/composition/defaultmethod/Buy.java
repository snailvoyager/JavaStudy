package basic.composition.defaultmethod;

public interface Buy {

	void buy();
	
	default void order() {		//duplicate method..
		System.out.println("buyer order()....");
	}
}
