package Leetcode.leet150.stack;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            switch (c) {
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        int i = 0, j = 0;
        List<StringBuilder> stack = new ArrayList<>();
        while (i < chars.length && j < chars.length) {
            while (i < chars.length && chars[i] == '/') {
                i++;
            }
            j = i;
            while (j < chars.length && chars[j] != '/') {
                j++;
            }
            StringBuilder sb = new StringBuilder(path.substring(i, j));
            if (sb.toString().equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (sb.toString().equals(".")) {
                i = j;
                continue;
            } else if (!sb.isEmpty()) {
                stack.add(sb);
            }
            i = j;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : stack) {
            res.append("/").append(stringBuilder);
        }
        if (res.isEmpty()) {
            res.append("/");
        }
        return res.toString();
    }

    static class MinStack {
        private List<Integer> minValue;
        private List<Integer> stack;

        public MinStack() {
            minValue = new ArrayList<>();
            stack = new ArrayList<>();
            minValue.add(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.add(val);
            minValue.add(Math.min(val, minValue.getLast()));
        }

        public void pop() {
            stack.removeLast();
            minValue.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return minValue.getLast();
        }
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 + num2);
                }
                case "-" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                }
                case "*" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 * num2);
                }
                case "/" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                }
                default -> {
                    Integer num = Integer.valueOf(token);
                    stack.push(num);
                }
            }
        }
        return stack.pop();
    }

    public static int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        s = s.replaceAll(" ", "");
        nums.addLast(0);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                int start = i;
                while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {
                    i++;
                }
                nums.addLast(Integer.parseInt(s.substring(start, i)));
            }
            if (i >= chars.length) break;
            if (chars[i] == '(') {
                ops.addLast(chars[i]);
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i>0&&chars[i - 1] == '(') nums.addLast(0);
                if (!ops.isEmpty()&&ops.peekLast() != '(') {
                    cal(nums, ops);
                }
                ops.addLast(chars[i]);
            } else if (chars[i] == ')') {
                while (ops.peekLast() != '(') {
                    cal(nums, ops);
                }
                ops.pollLast();
            }

        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.pollLast();
    }

    public static void cal(Deque<Integer> nums, Deque<Character> ops) {
        int num2 = nums.pollLast();
        int num1 = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? num1 + num2 : num1 - num2);
    }
}
