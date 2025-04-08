package object_senior.practice;

public class binary {
    public static int binary_search(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + right >> 1;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 4, 6, 7, 8, 10, 11, 13, 15};
        int target = 4;
        int result = binary_search(arr,target);
        System.out.println(result);
    }
}
