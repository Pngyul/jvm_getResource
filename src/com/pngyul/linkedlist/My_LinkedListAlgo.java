package com.pngyul.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: PengYu
 */

public class My_LinkedListAlgo {

    //单链表反转
    public static Node reverse(Node list){

        Node curr = list,pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //链表中环的检测
    public static boolean checkCircle(Node list){
        if(list == null) return  false;

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }

    //两个有序链表合并
    public static Node mergeSortedLists(Node la,Node lb){
        if(la == null) return lb;
        if(lb == null) return la;

        Node p = la;
        Node q = lb;
        //获取表头
        Node head;
        if(p.data < p.data){
            head = p;
            p = p.next;
        }else{
            head = q;
            q = q.next;
        }

        Node r = head;
        //遍历 p、q，随便一个为空则退出循环
        while (p != null && q != null){
            if(p.data < p.data){
                r.next = p;
                p = p.next;
            }else{
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        //判断是哪一个链表先为空，并且接上不为空余下的数据
        if(p != null){
            r.next = p;
        }else {
            r.next = q;
        }

        return head;
    }

    //删除倒数第K个结点
    public static Node deleteLastKth(Node list,int k){

        Node fast = list;
        int i = 1;
        //判断链表长度是否小于k，并且得到下面循环的fast起始位置
        while (fast != null && i < k){
            fast = fast.next;
            ++i;
        }
        if(fast == null) return null;

        Node slow = list;
        Node pre = null;
        //遍历到链尾
        while (fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if(pre == null){  //如果删除的表头结点
            list = list.next;
        }else { //不是链表头结点
            pre.next = pre.next.next;
        }
        return list;
    }

    //删除中间节点
    public static Node findMiddleNode(Node list) {
        if(list == null) return null;
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
