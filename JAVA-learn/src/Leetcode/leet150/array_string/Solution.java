package Leetcode.leet150.array_string;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {3, 4, 5, 1, 2};
        int ans = trap(arr);
        System.out.println(ans);
//        int[] ans = productExceptSelf(arr);
//        for (int i : ans) {
//            System.out.print(i + " ");
//        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
        while (j >= 0) nums1[j] = nums2[j--];
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public static int romanToInt(String s) {
        int res = 0;
        int curInt;
        int preInt = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            curInt = getValue(s.charAt(i));
            if (curInt > preInt) {
                res -= preInt;
            } else
                res += preInt;
            preInt = curInt;
        }
        res += preInt;
        return res;


    }

    private static int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int k = 2;
        int i = 2;
        while (i < len) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }

    public static int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 0;
        for (int num : nums) {
            if (cur == num) {
                count++;
            } else if (count == 0) {
                cur = num;
            } else count--;
        }
        return cur;
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            end--;
            begin++;
        }
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                max = Math.max(max, prices[i] - buy);
            } else buy = prices[i];
        }
        return max;
    }

    public static boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }
        return target == 0;
    }

    public static int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) sum += temp;
        }

        return sum;
    }

    public static int jump(int[] nums) {
        int cnt = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;//能到达的下标范围是[i,maxPos]
                cnt++;
                System.out.println("end = " + end);
            }
        }
        return cnt;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int ans = Math.min(citations[len - 1], len);//答案不会超过总的论文数量和单篇论文的最高引用量
        while (ans > 0 && citations[len - ans] < ans) {//citations[len-ans]<ans代表从len-ans到len-1
            // 一共ans篇论文引用量都大于ans,找到最大的满足条件的ans即可停止
            ans--;
        }
        return ans;
    }

    public static class RandomizedSet {
        private ArrayList<Integer> list;
        private HashMap<Integer, Integer> map;
        private Random r;

        public RandomizedSet() {
//            RandomizedSet() 初始化 RandomizedSet 对象
            list = new ArrayList<>();
            map = new HashMap<>();
            r = new Random();
        }

        public boolean insert(int val) {
//            bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
            if (map.containsKey(val))
                return false;
            else {
                map.put(val, list.size());
                list.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
//            bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
            if (map.containsKey(val)) {
                int pos = map.get(val);//val在list中的索引
                int last = list.getLast();//list末尾元素的值
                list.set(pos, last);//用末尾元素覆盖val
                map.put(last, pos);//修改末尾元素的位置记录
                map.remove(val);//删除val的位置记录
                list.removeLast();
                return true;
            }
            return false;
        }

        public int getRandom() {
//            int getRandom() 随机返回现有集合中的一项
//            （测试用例保证调用此方法时集合中至少存在一个元素）。
//            每个元素应该有相同的概率被返回。
            return list.get(r.nextInt(list.size()));
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int suffix = 1;
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            ans[i] *= suffix;
        }
        return ans;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //从x到y若不能到达,则x,y之间也无需尝试
        int sum = 0;
        int min = 0;
        int ans = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                ans = i + 1;
                min = sum;
            }
        }
        return sum >= 0 ? (ans == gas.length ? gas.length : ans) : -1;
    }

    public static int candy(int[] ratings) {
        //相邻的两个当中分数高的分的更多,要想总糖果最少,则每个大小关系只能加1
        //前后各自遍历一遍
        int sum = 0;
        int[] Candy = new int[ratings.length];
        Arrays.fill(Candy, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                Candy[i + 1] = Candy[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                Candy[i - 1] = Math.max(Candy[i] + 1, Candy[i - 1]);
            }
        }
        for (int i : Candy) {
            sum += i;
        }//
        return sum;
    }

    public static int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left]<height[right]) {//rightMax>leftMax,水位一定取决于左边,将该位置水量计入
                ans+=leftMax-height[left];
                left++;
            }
            else {//rightMax<=leftMax,水位一定取决于右边,将该位置水量计入
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
