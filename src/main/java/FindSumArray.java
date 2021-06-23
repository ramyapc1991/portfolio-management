public class FindSumArray {
    public static void main(String[] args) {
        //{3, 44, 9, 11, 4, 5}
        // input 18
        int[] arr = {3, 4, 5, 9, 11, 44};
        int input = 18;
        findSubArraySum(arr, input);
    }

    private static void findSubArraySum(int[] arr, int input) {

        for(int i =1;i<=arr.length;i++){
            getElements(i,arr,input);
        }
    }

    private static void getElements(int i, int[] arr, int input) {

        for(int j = 0;j<arr.length;j++){
          int sum = getSum(i,j,arr);
          int rem = Math.abs(sum-input);
          if(i < arr.length){
              getValues(arr,rem, arr[i], arr[j]);
          }
        }
    }

    private static void getValues(int[] arr, int rem, int val1, int val2) {
        for(int j = 0;j<arr.length;j++) {
            if (rem == arr[j]) {
                System.out.println(val1 + "," + val2 + "," + arr[j]);
            }
        }
    }

    private static int getSum(int i, int j, int[] arr) {
        int count = 0;
        int sum =0;
        for(int k =j;k<arr.length;k++){
            if(count <= i){
                sum = sum+arr[k];
                count++;
            }
        }
        return sum;
    }
}
