//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//    你可以假设 nums1 和 nums2 不会同时为空。
//    示例 1:
//    nums1 = [1, 3]
//    nums2 = [2]
//    则中位数是 2.0
//    示例 2:
//    nums1 = [1, 2]
//    nums2 = [3, 4]
//    则中位数是 (2 + 3)/2 = 2.5
public class L4 {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        初始值和边界处理
        double result = 0.0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 && length2 == 0 ){
            return result;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,6,7,88};
        int[] num2 = {99,10,201};
        double result = findMedianSortedArrays(num1, num2);
        System.out.println(result);
    }

}
