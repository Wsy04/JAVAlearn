package Leetcode.leet150.linkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<ListNode> list1 = new LinkedList<>();
        LinkedList<ListNode> list2 = new LinkedList<>();
        int[] arr1 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr2 = {9, 9, 9, 9};
        list1.addFirst(new ListNode(arr1[0]));
        for (int i = 1; i < arr1.length; i++) {
            ListNode node = new ListNode(arr1[i]);
            list1.getLast().next = node;
            list1.add(node);
        }
        list2.addFirst(new ListNode(arr2[0]));
        for (int i = 1; i < arr2.length; i++) {
            ListNode node = new ListNode(arr2[i]);
            list2.getLast().next = node;
            list2.add(node);
        }
        for (ListNode listNode : list1) {
            System.out.print(listNode.val);
        }
        System.out.println();
        for (ListNode listNode : list2) {
            System.out.print(listNode.val);
        }
        System.out.println(addTwoNumbers(list1.getFirst(), list2.getFirst()));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            sum = v1 + v2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

