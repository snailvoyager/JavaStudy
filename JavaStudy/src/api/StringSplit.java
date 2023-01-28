package api;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringSplit {
    public static void main(String[] args) {
        String str = "1,2,3,,5,";
        String[] strArr = str.split(",");

        System.out.println(Arrays.toString(strArr));        //마지막 , 무시
        System.out.println("3 : " + strArr[3].length());    //null 아니고 공백 포함

        StringTokenizer st = new StringTokenizer(str, ",");
        while(st.hasMoreElements()) {
            System.out.println("st : " + st.nextToken());   //공백 무시
        }
    }
}
