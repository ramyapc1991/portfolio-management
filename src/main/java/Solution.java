import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] A) {

        int count = 0;
        List<Integer> arr = new ArrayList<Integer>();

        for (int i : A) {
            arr.add(i);
        }

        // first check if its already in correct sequence
        boolean check = false;
        for (int i = 0; i < A.length-2 ; i++) {
            if ((arr.get(i) > arr.get(i+1)) && (arr.get(i+1) < arr.get(i+2))) {
                check = true;
            } else if ((arr.get(i) < arr.get(i+1)) && (arr.get(i+1)> arr.get(i+2))) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            return 0;
        }

        List<Integer> ab = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            ab.clear();
            ab.addAll(arr);
            ab.remove(i);
            int k = 0;
            boolean flag = false;
            while (k < A.length - 3) {
                if (!flag && k != 0) {
                    break;
                }
                if ((ab.get(k) > ab.get(k + 1)) && (ab.get(k + 1) < ab.get(k + 2))) {
                    flag = true;
                } else if ((ab.get(k) < ab.get(k + 1)) && (ab.get(k + 1)> ab.get(k + 2))) {
                    flag = true;
                } else {
                    flag = false;
                }
                k++;
            }
            if (flag) {
                count++;
            }
        }
        if (count == 0)
            count = -1;

        return count;
    }

    public static void main(String[] args) {
        int[] A = {3,4,5,3,7};
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
