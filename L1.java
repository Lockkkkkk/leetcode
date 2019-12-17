//给定 nums = [2, 7, 11, 15], target = 9
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]

//1、暴力方法就不写了
//2、根据题意A+B=TARGET ==》 A=TARTGET-B 也就是代码中的 target-nums[i]，如果有符合条件的，则说明配对成功

import java.util.HashMap;
import java.util.Map;

public class L1 {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,15,16,18,20,7};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
