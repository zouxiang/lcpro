package medium;
/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

https://leetcode.com/articles/add-two-numbers/

 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    boolean hasNext() {
        return this.next != null;
    }
}


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curl1Val = l1.val;
        int curl2Val = l2.val;
        ListNode curl1Node = l1;
        ListNode curl2Node = l2;
        boolean needCarryBit = false;

        int curl3Val = curl1Val + curl2Val;
        if(curl3Val > 9) {
            curl3Val -= 10;
            needCarryBit = true;
        }
        ListNode curl3Node = new ListNode(curl3Val);
        ListNode curl3Head = curl3Node;
        while(curl1Node.hasNext()) {
            curl1Node = curl1Node.next;
            if(curl2Node.hasNext()) {
                curl2Node = curl2Node.next;
                curl3Val = curl1Node.val + curl2Node.val;
                if(needCarryBit) curl3Val++;
            } else {
                if(!needCarryBit) {
                    curl3Node.next = curl1Node;
                    break;
                }
                curl3Val = needCarryBit?curl1Node.val+1:curl1Node.val;
            }
            needCarryBit = curl3Val > 9?true:false;
            if(needCarryBit) curl3Val -=10;
            curl3Node.next = new ListNode(curl3Val);
            curl3Node = curl3Node.next;
        }
        while(curl2Node.hasNext()) {
            curl2Node = curl2Node.next;
            curl3Val = needCarryBit?curl2Node.val+1:curl2Node.val;
            needCarryBit = curl3Val > 9?true:false;
            if(needCarryBit) curl3Val -=10;
            curl3Node.next = new ListNode(curl3Val);
            curl3Node = curl3Node.next;
        }
        if(needCarryBit) {
            curl3Node.next = new ListNode(1);
        }
        return curl3Head;
    }

    public static void main(String[] args) {
//        ListNode node_a3 = new ListNode(4);
//        ListNode node_a2 = new ListNode(5, node_a3);
//        ListNode node_a1 = new ListNode(9, node_a2);
//
//        ListNode node_b3 = new ListNode(5);
//        ListNode node_b2 = new ListNode(7, node_b3);
//        ListNode node_b1 = new ListNode(8, node_b2);

        ListNode node_a2 = new ListNode(8);
        ListNode node_a1 = new ListNode(9, node_a2);

        ListNode node_b1 = new ListNode(1);

        //9->5->4 + 8->7->5
        //459 + 578 = 1037

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(node_a1, node_b1);

        do{
            System.out.println(result.val);
            result = result.next;
        } while(result!= null);

    }
}
