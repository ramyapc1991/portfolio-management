import java.util.Arrays;

class Test1
{
    //  Utility method to flip a character
    public static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }

    //  Utility method to get minimum flips when
    //  alternate string starts with expected char
    public static int getFlipWithStartingCharcter(String str,
                                                  char expected)
    {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != expected)
                flipCount++;

            expected = flip(expected);
        }
        return flipCount;
    }

    // method return minimum flip to make binary
    // string alternate
    public static int minFlipToMakeStringAlternate(String str)
    {
        return Math.min(getFlipWithStartingCharcter(str, '0'),
                getFlipWithStartingCharcter(str, '1'));
    }

    //  Driver code to test above method
    public static void main(String args[])
    {
        String str = "0001010111";
        String s[] = str.split("");
//        for(String s1:s)
//            System.out.println(s1);

        int[] val = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
        String newStr = "";
        for(int v: val){
            newStr += v;
        }
        System.out.println(minFlipToMakeStringAlternate(newStr));
    }
}