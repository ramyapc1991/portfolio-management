package com.turvo.portfolio.management;

public class TestInfo {

    public static void main(String[] args) {
        String str = "jeee";
        String res = getFormattedString(str);
        System.out.println(res);
    }

    private static String getFormattedString(String str) {
        int count =1;

        char[] ch = str.toCharArray();
        String res = "";
        int j =1;

        for(int i =0;i<ch.length;i++){
            if(ch[i] == ch[j]){
                count++;
            }
            else{
                if(count>1){
                    res = res + count +ch[i];
                }
                else
                    res = res + ch[i];
                i = j;
                break;
            }


        }

//        while(i< ch.length){
//            if(ch[i-1] == ch[i]){
//                count++;
//                if(count>1){
//                    res = res+count+ch[i];
//                }
//                else{
//                    res = res +ch[i];
//                }
//            }else{
//                count = 1;
//                if(i+1 == ch.length){
//                    res = res +ch[i];
//                }
//            }
//            i++;
//        }
        return res;
    }
}
