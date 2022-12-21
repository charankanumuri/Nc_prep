package Linked_Lists;

// import java.util.Map;
// import java.util.Stack;

public class Linked_List {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode curr_next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr_next;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(-1);
        ListNode res = list;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }

        res.next = list1 == null ? list2 : list1;
        return list.next;
    }

    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        else if (l2 == null)
            return l1;

        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_2(l1, l2.next);
            return l2;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        // Finding center of Linked List
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reversal of Linked List
        ListNode prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Merge two linked lists.
        ListNode first = head, second = prev;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp, second = temp;

        while (n > 0) {
            second = second.next;
            n--;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
        return temp.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode first = head, second = head;
        while (first != null && first.next != null) {
            second = second.next;
            first = first.next.next;
            if (first == second)
                return true;
        }
        return false;
    }

    public int findDuplicate(int[] nums) {
        while(nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
        // Set<Integer> set = new HashSet<>();
        // for(int num: nums) {
        //     if(set.contains(num))
        //         return num;
        //     set.add(num);
        // }
        // return -1;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKsubLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKsubLists(ListNode[] lists, int start, int end) {
        if(start == end)
            return lists[start];
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            ListNode l1 = mergeKsubLists(lists, start, mid);
            ListNode l2 = mergeKsubLists(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        }
        return null;
    }


   /* public static void main(String[] args) {
        String s = "ACBDCACBD";
        System.out.println(transform(s));
    }
    
    public static String transform(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = Map.of('A', 'B', 'B', 'A', 'C', 'D', 'D', 'C');
        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty() && map.get(ch) == stack.peek()) {
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    } */


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while(count < k) {
            if(node == null) return head;
            node = node.next;
            count++;
        }
        
        ListNode prev = reverseKGroup(node, k);
        while(count > 0) {
            ListNode head_next = head.next;
            head.next = prev;
            prev = head;
            head = head_next;
            count = count - 1;
        }
        return prev;
    }
    

}