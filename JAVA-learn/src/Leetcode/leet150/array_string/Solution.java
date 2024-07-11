package Leetcode.leet150.array_string;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        fullJustify(words, 16).forEach(System.out::println);
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
            if (height[left] < height[right]) {//rightMax>leftMax,水位一定取决于左边,将该位置水量计入
                ans += leftMax - height[left];
                left++;
            } else {//rightMax<=leftMax,水位一定取决于右边,将该位置水量计入
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
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

    public static String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romans.length; i++) {
            int number = numbers[i];
            String s = romans[i];
            while (num >= number) {
                sb.append(s);
                num -= number;
            }
        }
        return sb.toString();
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }
        return len;
    }

    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        if (strs[0].isEmpty()) return "";
        char ch = strs[0].charAt(0);
        StringBuilder sb = new StringBuilder();
        while (true) {
            for (String str : strs) {
                if (i >= str.length()) return sb.toString();
                if (ch != str.charAt(i)) return sb.toString();
            }
            sb.append(ch);
            i++;
            if (i >= strs[0].length()) return sb.toString();
            ch = strs[0].charAt(i);
        }
    }

    public static String reverseWords(String s) {
        int i = s.length() - 1;
        int j;
        StringBuilder sb = new StringBuilder();
        int end = 0;
        while (s.charAt(end) == ' ') {
            end++;
        }
        while (i >= end) {
            j = i;
            while (j >= end && s.charAt(j) == ' ') {
                j--;
            }
            i = j;
            while (i >= end && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1);
            if (i > end)
                sb.append(' ');
        }
        return sb.toString();
    }

    public static String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int len = s.length();
        for (int i = 0; i < len; ) {
            int j = 0;
            while (j < numRows && i < len) {
                sbs[j].append(s.charAt(i));
                i++;
                j++;
            }
            j = numRows - 2;
            while (j >= 1 && i < len) {
                sbs[j].append(s.charAt(i));
                i++;
                j--;
            }
        }
        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int len = 0;
        for (String word : words) {
            len += word.length();//统计全体单词的总长度,用于判断是否到达最后一行
        }
        int i = 0;
        while (i < words.length) {
            StringBuilder sb = new StringBuilder();
            int j = i;//可能选取到的单词
            int l = 0;//此行文本长度
            int space = 0;//此行空格个数
            if(len+(words.length-1-i)<=maxWidth){//最后一行
                len = maxWidth;
                while(i<words.length-1){
                    sb.append(words[i]);
                    sb.append(" ");
                    len-=words[i].length()+1;
                    i++;
                }
                sb.append(words[i]);
                len-=words[i].length();
                sb.append(" ".repeat(len));//填充空格
                list.add(sb.toString());
                return list;
            }
            while (j < words.length && l + space + words[j].length() <= maxWidth) {
                l += words[j].length();
                j++;
                space++;
            }
            j--;
            space = maxWidth - l;
            int eachSpace = space / Math.max(j - i,1);//平均每个单词之间要多少空格,这一行选取了j-i+1个单词,则有j-i个间隔
            int mulSpace = space % Math.max(j - i,1);//有多少个间隔长度比平均多一
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (mulSpace > 0) {//若不能平均分配空格,左边的分配更多的空格
                    sb.append(' ');
                    mulSpace--;
                }
                sb.append(" ".repeat(eachSpace));
                len-=words[k].length();
            }
            sb.append(words[j]);
            if(i==j)
                sb.append(" ".repeat(eachSpace));//对于一行只填了一个单词的情况在末尾填充空格
            len-=words[j].length();
            list.add(sb.toString());
            i = j + 1;

        }
        return list;
    }
}
