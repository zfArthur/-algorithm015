class Solution {
    //思路:先判断链表本身和next是否为空，为空则直接返回, 将1->2 为一组，2的next为后面的3->4,处理完第一组得到2->1  第二组 4->3 递归的处理，最后将2->1 指向 4->3  最后组成 2->1->4->3
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        //第一个节点
        ListNode first = head;
        //第二个节点
        ListNode second = head.next;

        //保存记录第二个节点后的节点引用
        ListNode next = second.next;

        //第二个节点指向第一个节点
        second.next = first;

        //第二个节点指向第一个节点，第一个节点指向(原第二个节点的下一个节点)
        first.next = swapPairs(next);

        return second;
    }

}