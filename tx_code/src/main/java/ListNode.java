///**
// * 5,{0,1,3,4,5,11,6}
// *
// * [{0,5},{1,11,6},{},{3},{4}]
// */
//
//
//import java.util.*;
//
///*
//public class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}*/
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param m int整型
//     * @param a ListNode类 指向彩带的起点，val表示当前节点的val，next指向下一个节点
//     * @return ListNode类一维数组
//     */
//    public ListNode[] solve (int m, ListNode a) {
//        // write code here
//        ListNode[] res = new ListNode[m];
//
//        while (a != null) {
//            // 怎么加到二位数组中
//            int i = a.val % m;
//            if (res[i] == null) {
//                res[i] = new ListNode(a.val);
//            } else if (res[i].next == null) {
//                res[i].next = new ListNode(a.val);
//            } else if (res[i].next.next == null) {
//                res[i].next.next = new ListNode(a.val);
//            } else if (res[i].next.next.next == null) {
//                res[i].next.next.next = new ListNode(a.val);
//            }
//            a = a.next;
//        }
//        System.out.println(res.toString());
//        return res;
//    }
//}