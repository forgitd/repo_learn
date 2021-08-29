package codeTest;

public class ReverseLinked {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode1 = ReverseList(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        //首先判断链表是否为空，为空的话则返回空
        if (head == null) {
            return null;
        }
        //pre表示head的前一个节点
        ListNode pre = null;
        //next表示head的后一个节点
        ListNode next = null;
        //一直循环到head为空
        while (head != null) {
            //为了防止链表断裂，先储存后一个节点
            next = head.next;
            //让head的下一个节点指向前一个节点，也就是实现了反转
            head.next = pre;
            //因为要继续向下再一次循环执行，所以移位，可看附图进行理解
            pre = head;
            head = next;
        }
        //当head为空的时候，pre已经是最后一个元素了，也就是现在链表的表头
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }

}