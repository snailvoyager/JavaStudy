package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PersonTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Person person = new Person("James");
		System.out.println(person);
		
		Class c1 = Class.forName("reflection.Person");
		Person person1 = (Person) c1.newInstance();
		System.out.println(person1);
		
		//생성자 파라미터 설정
		Class[] parameterTypes = {String.class};
		Constructor cons = c1.getConstructor(parameterTypes);
		
		Object[] initargs = {"김유신"};
		Person person2 = (Person)cons.newInstance(initargs);
		System.out.println(person2);
	}

}
