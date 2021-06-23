package com.turvo.portfolio.management;


public class OccurancesTest {

    public static void main(String[] args) {
        //“9990032239”
        // input 9
        // count ++ = 2 4
        // occ = 1 occ ++ = 2, 3
        String s = "999003223";
        String input = "2";
        System.out.println(countInputOcc(s, input));
    }

    private static boolean countInputOcc(String s, String input) {
    int count = 0, occCount = 1;
        for(int i =0;i<s.length();i++){
            if(Integer.parseInt(String.valueOf(s.charAt(i))) == Integer.parseInt(input)){
                count++;
                if(i !=0 && (Integer.parseInt(String.valueOf(s.charAt(i-1))) == Integer.parseInt(String.valueOf(s.charAt(i))))){
                    occCount++;
                }
            }
        }
        if(count==occCount){
            return true;
        }
        return false;
    }

}
