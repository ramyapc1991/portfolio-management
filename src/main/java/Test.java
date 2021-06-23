import java.util.Arrays;

class Test
{
    //  Utility method to flip a character
    public static int flip(int val)
    {
        return (val == 0) ? 1 : 0;
    }

    //  Utility method to get minimum flips when
    //  alternate string starts with expected char
    public static int coinStarting(int[] str, int expected)
    {
        int flipCount = 0;
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] != expected)
                flipCount++;
            expected = flip(expected);
        }
        return flipCount;
    }

    // method return minimum flip to make binary
    // string alternate
    public static int minFlipToMakeCoinsAlternate(int[] str)
    {
        return Math.min(coinStarting(str, 0), coinStarting(str, 1));
    }

    //  Driver code to test above method
    public static void main(String args[])
    {
        String str = "0001010111";
        String s[] = str.split("");
//        for(String s1:s)
//            System.out.println(s1);

        int[] val = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(minFlipToMakeCoinsAlternate(val));
    }
}