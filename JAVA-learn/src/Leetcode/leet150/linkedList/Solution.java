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

    public static class Node {
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
//        ListNode head = new ListNode(2);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(2);
//        ListNode node6 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        ListNode node = partition(head,2);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
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
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode Left1 = prev;
        ListNode Left2 = prev.next;
        for (int i = 0; i < right - left + 1; i++) {
            prev = prev.next;
        }
        ListNode Right1 = prev;
        ListNode Right2 = prev.next;
        //截断链表
        Left1.next = null;
        Right1.next = null;
        reverseListNode(Left2);
        //重新拼接
        Left1.next = Right1;
        Left2.next = Right2;
        return dummy.next;
    }

    public static void reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            for (int i = 0; i < k - 1; i++) {
                right = right.next;
                if (right == null) break;
            }
            if (right == null) break;
            else {
                ListNode next = right.next;
                right.next = null;
                prev.next = null;
                reverseListNode(left);
                prev.next = right;
                left.next = next;
                prev = left;
                left = next;
                right = next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                int val = fast.val;
                do {
                    fast = fast.next;
                } while (fast.next != null && fast.next.val == val);
                slow.next = fast.next;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        k = k % count;
        ListNode prev = head;
        for (int i = 0; i < count - k - 1; i++) {
            prev = prev.next;
        }
        cur.next = head;
        cur = prev.next;
        prev.next = null;
        return cur;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode small = dummy1;
        ListNode large = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                cur = cur.next;
                small = small.next;
            }else {
                large.next = cur;
                cur = cur.next;
                large = large.next;
            }
        }
        small.next = dummy2.next;
        large.next = null;
        return dummy1.next;
    }

    static class LRUCache {
        /**
         * Your LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        static class Node {
            int key;
            int val;
            Node next;
            Node prev;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        private HashMap<Integer, Node> map;//key对应的Node地址
        private int capacity;
        private Node dummy;
        private Node tail;
        private int size;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.dummy = new Node(0,0);
            this.tail = new Node(0,0);
            dummy.next = tail;
            tail.prev = dummy;
            this.size = 0;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                update(key);
                return map.get(key).val;
            } else return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                update(key);
                map.get(key).val = value;
            } else {
                Node node = new Node(key,value);
                node.next = dummy.next;
                node.prev = dummy;
                dummy.next = node;
                node.next.prev = node;
                map.put(key, node);
                size++;
                if(size > capacity) {
                    //移除链表末尾的元素
                    size--;
                    Node prev = tail.prev;
                    prev.prev.next = tail;
                    tail.prev = prev.prev;
                    map.remove(prev.key);
                }
            }
        }

        public void update(int key){
            //将最近访问的元素放到链表的头部
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = dummy.next;
            dummy.next.prev = node;
            node.prev = dummy;
            dummy.next = node;
        }
    }


}

