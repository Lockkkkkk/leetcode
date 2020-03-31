import comm.util;

import java.util.*;
public class Solution {

    public static int findRepeatNumber(int[] nums){
        Arrays.sort(nums);
        int pre = nums[0];
        int length = nums.length;
        for (int i = 1; i < length ; i++) {
            if(nums[i] == pre){
                return pre;
            }else{
                pre = i;
            }

        }
//        Map<Integer, Integer> keymaps = new HashMap<>();
//        for (int i : nums) {
//            if (keymaps.containsKey(i)){
//                return i;
//            }else{
//                keymaps.put(i,1);
//            }
//        }
        return 0;
    }


    public static int JumpFloor(int target){
        if(target <=0) {
            return 0 ;
        }
        if(target<=2){
            return target;
        }
        return JumpFloor(target-1) + JumpFloor(target - 2);
        /*int a=1 , b=2;
        int temp;
        for(int i = 3 ; i<=target; i++){
            temp = a;
            b = a;
            b += temp;
        }
        return b;*/
    }

    public static int jumpFloorII(int target){
        if (target <=0){
            return 0;
        }
        int sumPath = 0;
        int path = 0;
        for (int i = 0; i < target; i++) {
            path = sumPath +1;
            sumPath = sumPath *2  +1;
        }
        return path;
    }

    public static int numberOf1(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n&flag) != 0){
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static double Power(double base, int exp){
        Double res = 0D;
        if(equal(base, 0.0) && exp < 0 ){
            return 0D;
        }
        if(exp == 0){
            return 1.0;
        }
        if(exp < 0){
            res = powerWithExp(1.0/base, -exp);
        }else{
            res = powerWithExp(base, exp);
        }
        return res;
    }

    private static Double powerWithExp(double base, int exp) {
        double res = 1.0;
        for (int i = 1; i < exp; i++) {
            res = res * base;
        }
        return res;
    }

    private static boolean equal(double base, double v) {
        if(Math.abs(base -v) < 0.000000001){
            return true;
        }
        return false;
    }


    // 调整数组顺序使奇数位于偶数前面
    public static void reOrderArray(int[] array){
        if(array == null || array.length == 0) return;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if(((array[j+1]&0x01) == 1) && !((array[j] & 0x01) ==1)){
                    exch(array,j, j+1);
                }
            }
        }
        
    }

    private static void exch(int[] array, int odd, int even) {
        int temp = array[odd];
        array[odd]  = array[even];
        array[even] = temp;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
//    两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，
//    到达第k个节点之后，两个指针同时往后移动，
//    当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
    public static ListNode ListNodeFindKthToTail(ListNode head, int k){
        if(head == null || k==0 ){
            return null;
        }
        ListNode pre = head;
        ListNode behind = head;
        for (int i = 1; i < k ; i++) {
            if(pre.next != null){
                pre = pre.next;
            }else{
                return null;
            }
        }
        while(pre.next !=null){
            pre = pre.next;
            behind = behind.next;
        }
        return behind;
    }


    public static ListNode revertListNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = revertListNode(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};

        int a = findRepeatNumber(nums);
//        System.out.println(a);
//        System.out.println(numberOf1(5));
//        System.out.println(numberOf1(10));
//        System.out.println(numberOf1(-5));
        int[] num = {1,2,3,4,5,6,7,8,9};
        reOrderArray(num);
    }

}
