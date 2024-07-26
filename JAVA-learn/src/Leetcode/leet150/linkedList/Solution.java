package Leetcode.leet150.linkedList;

import java.util.*;

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
    public static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode node = reverseBetween(head,1,2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
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

    public static Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(new ListNode());
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if(right+1<list.size())
            list.get(left).next = list.get(right+1);
        else list.get(left).next = null;
        for (int i = left+1; i <= right; i++) {
            list.get(i).next = list.get(i-1);
        }
        list.get(left-1).next = list.get(right);
        if(left>1)
            return list.get(1);
        else return list.get(right);
    }
}

