package interview;

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
}

class Solution {

    public static boolean hasReachedEnd(ListNode[] lists) {
        boolean flag = true;
        for (ListNode node : lists) {
            if (node != null) {
                flag = false;
                break;
            }
        }
        return flag;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode min = new ListNode();
        ListNode next = null;
        boolean found = false;
        int index = -1;
        while (true) {
            found = false;
            index = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= min.val) {
                    min = lists[i];
                    found = true;
                    index = i;
                }
            }

            if (!found)
                break;

            next.next = min;
            next = next.next;

            lists[index] = lists[index].next;
            min = new ListNode(Integer.MAX_VALUE);
        }

        return head.next;

    }

    public static void main(String[] args) {

        new Solution().mergeKLists(null);
    }
}
