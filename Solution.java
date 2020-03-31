import comm.ListNodeUtil;

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
//合并两个排序的链表
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null ) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode list0 = null;
        if(list1.val < list2.val){
            list0 = list1;
            list0.next = Merge(list1.next, list2);
        }else{
            list0 = list2;
            list0.next = Merge(list1, list2.next);
        }
        return list0;
    }



    public static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null & root2 != null ){
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result) {result = HasSubtree(root1.left, root2);}
            if(!result) {result = HasSubtree(root1.right,root2);}
        }
        return result;
    }
    private static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 !=null ) return false;
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }



    // 二叉树镜像
    public static void Mirror(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }



    public static void main(String[] args) {

        ListNode listnode = new ListNode(5);
        listnode.next = new ListNode(10);
        ListNode listnode1  = new ListNode(11);
        listnode1.next = new ListNode(15);
        ListNode list = Merge(listnode, listnode1);
        while(list != null ){
            System.out.println(list.val + "");
            list = list.next;
        }

        TreeNode node1 = new TreeNode(5);
        node1.left= new TreeNode(10);
        node1.right = new TreeNode(15);
        node1.left.left= new TreeNode(1);

        TreeNode node2 = new TreeNode(10);
        node2.left = new TreeNode(1);
        boolean a = HasSubtree(node1, node2);
        System.out.println(a);


    }

}
