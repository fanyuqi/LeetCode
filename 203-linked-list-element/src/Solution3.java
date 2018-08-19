/// Leetcode 203. Remove Linked List Elements,递归操作，使用打印输出，显示递归调用的过程
/// https://leetcode.com/problems/remove-linked-list-elements/description/

import java.util.List;

class Solution3 {

    public ListNode removeElements(ListNode head, int val, int depth) {//depth 表示递归的深度，方便可视化的展示递归调用的过程

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: rmove "+ val + " in " + head);
        if (head == null){
            System.out.print(depthString);
            System.out.println("Return " + head);
            return null;
        }
//        head.next = removeElements(head.next , val);
//        return head.val == val ? head.next : head ;
//    这两行代码可代替下面的逻辑

        ListNode res = removeElements(head.next , val , depth + 1 );
        System.out.print(depthString);
        System.out.println("After remove" + val + ":" + res);
        ListNode ret;
        if (head.val == val){
           ret = res;
        }
        else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("return " + ret );
        return ret;
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < depth ; i ++){
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6 , 0);
        System.out.println(res);
    }
}