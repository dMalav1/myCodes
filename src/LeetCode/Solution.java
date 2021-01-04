package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution{
	
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> prevMap = new HashMap<>();
	        
	        for (int i = 0; i < nums.length; i++) {
	            int diff = target - nums[i];
	            
	            if (prevMap.containsKey(diff)) {
	                return new int[]{ prevMap.get(diff), i };
	            }
	            prevMap.put(nums[i], i);
	        }
	        return new int[0]; 
	    }

	        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	            ListNode dummy = new ListNode(0);
	            ListNode l3 = dummy;
	            
	            int carry = 0;
	            while (l1 != null || l2 != null){
	                int l1_val = (l1 !=null) ? l1.val : 0;
	                int l2_val = (l2 !=null) ? l2.val : 0;
	                
	                int sum = l1_val + l2_val + carry;
	                carry = sum / 10;
	                int last = sum % 10;
	                
	                ListNode newNode = new ListNode(last);
	                l3.next = newNode;
	                
	                if (l1 != null)  l1 = l1.next;
	                if (l2 != null)  l2 = l2.next;
	                l3 = l3.next;
	            }
	            
	            if (carry != 0){
	                ListNode newNode = new ListNode(carry);
	                l3.next = newNode;
	                l3 = l3.next;
	            }
	            
	            return dummy.next;
	        }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
