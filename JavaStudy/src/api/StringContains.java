package api;

public class StringContains {

	public static void main(String args[] ) throws Exception {
        System.out.println(contains("testtttabtestest", "test"));
        System.out.println(contains("a", "testaaaaaaaaaaaaaa"));
        System.out.println(contains("test", "test"));
        System.out.println(contains("testandtest", "test"));
        System.out.println(contains("test", "test"));
        System.out.println(contains("ttestest", "test"));
        System.out.println();
        
        System.out.println(contains2("testtttabtestest", "test"));
        System.out.println(contains2("a", "testaaaaaaaaaaaaaa"));
        System.out.println(contains2("test", "test"));
        System.out.println(contains2("testandtest", "test"));
        System.out.println(contains2("test", "test"));
        System.out.println(contains2("test", "testtest"));
        System.out.println(contains2("ttttttesssssttttt", "test"));
        System.out.println(contains2("ttestest", "test"));
        System.out.println();
        
        System.out.println("testtttabtestest".contains("test"));
        System.out.println("a".contains("testaaaaaaaaaaaaaa"));
        System.out.println("test".contains("test"));
        System.out.println("testandtest".contains("test"));
        System.out.println("test".contains("test"));
        System.out.println("ttestest".contains("test"));
        System.out.println();
    }
    
    public static boolean contains(String str, String include) {
        char[] arr1 = str.toCharArray();
        char[] arr2 = include.toCharArray();
        
        boolean result = false;
        
        int j = 0;
        
        for(int i=0; i<arr1.length; i++){
            j = 0;
            if (arr1[i] == arr2[j]) {
                while(i<arr1.length && j < arr2.length){
                    if(arr1[i] != arr2[j])
                        break;
                    i++;
                    j++;
                }        
            }
            if(j == arr2.length)
                break;
        }
        
        if(j == arr2.length)
            result = true;
        
        return result;
    }
    
    public static boolean contains2(String str, String include) {
    	if(str.length() < include.length())
    		return false;
    	
    	for(int i=0; i<str.length(); i++) {
    		int j = 0;
    		if(str.charAt(i) == include.charAt(j)) {
    			j++;
    			for(int k=i+1; j<include.length(); k++, j++) {
    				if(k>=str.length() || str.charAt(k) != include.charAt(j))
    					break;
    			}
    			if(j == include.length())
    				return true;
    		}
    	}
    	return false;
    }

}
