package com.yongren;

class SinglylyNode {

    public SinglylyNode next;

    public int val;
    public SinglylyNode(int value) {
        this.val = value;
        this.next = null;
    }
}

class LinkList {

    public SinglylyNode head;
    public int count;

    public LinkList(SinglylyNode headNode) {
        this.head = headNode;
        this.count = 1;
//        this.head.next = null;
    }

    private SinglylyNode nodeAtIndex(int idx) {
        if(idx > this.count - 1) {
            System.out.println("<Expert> ---- out of index ");
            return null;
        }else {
            SinglylyNode _currentNode = this.head;
            for (int i = 0; i < idx ; i++) {
                _currentNode = _currentNode.next;
            }
            return _currentNode;
        }
    }

    public void discripList() {
        String temp = "";
        for (int i = 0; i < this.count; i++) {
            SinglylyNode node = this.nodeAtIndex(i);
            temp += " ( " + node.val + " ) -> ";
        }
        System.out.println(temp);
    }

    // 添加
    public void push(SinglylyNode node) {
        this.appendAtIndex(this.count, node);
    }
    public void appendAtIndex(int idx, SinglylyNode node) {
        if (idx > this.count) {
            System.out.println("<Expert> ---- out of index, cannot append Node at this index");
        }else  {
            if(idx == 0) {
                node.next = this.head;
                this.head = node;
            }else  {
                SinglylyNode preNode = this.nodeAtIndex(idx - 1);
                node.next = preNode.next;
                preNode.next = node;
            }
        }
        this.count += 1;
    }

    // 删除
    public void pop() {
        this.deleteNodeAtIndex(this.count - 1);
    }
    public void deleteNodeAtIndex(int idx) {
        if(idx > this.count || idx < 0) {
            System.out.println("<Expert> ---- out of index, cannot delete Node at this index");
        }else  {
            if(idx == 0) {
                this.head = this.head.next;
            }else {
                SinglylyNode preNode = this.nodeAtIndex(idx - 1);
                SinglylyNode node = this.nodeAtIndex(idx);
                preNode.next = node.next;
            }
            this.count -= 1;
        }
    }
}

/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * source: https://leetcode-cn.com/problems/add-two-numbers
 * */
class Solution {
    public SinglylyNode addTwoNumbers(SinglylyNode l1, SinglylyNode l2) {

        SinglylyNode n1 = l1;
        SinglylyNode n2 = l2;
        int carry = 0;

        SinglylyNode lastN = null;
        while (n1.next != null) {

            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;

            int result = x + y;

            SinglylyNode currentN = new SinglylyNode(0);
            if(result >= 10) {
                currentN.val = (result % 10);
                carry = 1;
            }else {
                currentN.val = result + carry;
                carry = 0;
            }

            n1 = n1.next;
            n2 = n2.next;

            if (lastN == null) {
                lastN = currentN;
            }else {
                lastN.next = currentN;
                lastN = currentN;
            }
        }

        return lastN;
    }
}

public class LinkListDemo {

    public static void main(String[] args){

//        test001();
        addTwoLinklineNumsDemo();
    }


    static void addTwoLinklineNumsDemo() {
        Solution s = new Solution();

//        s.addTwoNumbers();
    }


    static void test001() {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        obj.deleteAtIndex(1);
    }

    static void text002() {
        LinkList list;

        SinglylyNode node = new SinglylyNode(100);
        list = new LinkList(node);

        SinglylyNode a = new SinglylyNode(200);
        list.push(a);
        list.discripList();

//        int i = list.nodeAtIndex(0).val;
//        int ii = list.nodeAtIndex(1).val;
//        int iii = list.nodeAtIndex(2).val;
//        System.out.println("i " + i);
//        System.out.println("ii " + ii);
//        System.out.println("iii " + iii);

        SinglylyNode b = new SinglylyNode(300);
        list.appendAtIndex(list.count, b);

        list.push(new SinglylyNode(400));
        list.discripList();

        list.deleteNodeAtIndex(1);
        list.pop();
        list.discripList();

        list.deleteNodeAtIndex(3);
        list.appendAtIndex(0, new SinglylyNode(555));
        list.discripList();
    }

}
//// --------- /////
class MyLinkedList {
    // Definition for singly-linked Node.
    public class SinglyListNode {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) { val = x; }
    }

    int count;
    SinglyListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.count = 0;
        this.head = null;
    }

    private SinglyListNode getNode(int index) {
        if(index >= 0 && index < this.count) {
            SinglyListNode currentNode = this.head;
            int length = 0;
            while(length < index) {
                length += 1;
                currentNode = currentNode.next;
            }
            return currentNode;
        }
        return null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        SinglyListNode node = this.getNode(index);
        return node == null ? -1 : node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SinglyListNode node = new SinglyListNode(val);
        node.next = this.head;
        this.head = node;
        this.count += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        int idx = this.count - 1;
        SinglyListNode lastNode = getNode(idx);

        
        lastNode.next = new SinglyListNode(val);
        this.count += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.count || index < 0) {
            return;
        }else if(index == 0) {
            addAtHead(val);
        }else if(index == this.count) {
            addAtTail(val);
        }else {
            SinglyListNode node = new SinglyListNode(val);
            SinglyListNode preNode = getNode(index - 1);
            node.next = preNode.next;
            preNode.next = node;
            this.count += 1;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > this.count || index < 0) {
            return;
        }else {
            if(index == 0) {
                this.head = this.head.next;
            }else {
                SinglyListNode preNode = getNode(index - 1);
                SinglyListNode currentNode = getNode(index);
                preNode.next = currentNode.next;
            }
            this.count -= 1;
        }
    }
}