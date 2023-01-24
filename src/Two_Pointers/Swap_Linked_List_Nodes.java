package Two_Pointers;

import Linked_Lists.ListNode;

public class Swap_Linked_List_Nodes {
    
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode front = head;
        ListNode end = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        for(int i = 1; i < k; i++)
            front = front.next;
        
        for(int i = 1; i <= count - k; i++)
            end = end.next;
        
        int temp = front.val;
        front.val = end.val;
        end.val = temp;
        return head;
    }

}
