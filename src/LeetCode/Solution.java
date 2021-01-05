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

	        public int lengthOfLongestSubstring(String s) {
	            int ans = 0;
	            if (s.length() == 0) {
	                return ans;
	            }
	            char[] charArr = s.toCharArray();
	            int start = 0, end = 0;
	            ans = 1;
	            int prevIdx = -1;
	            for (int i = 1; i < charArr.length; i++) {
	                prevIdx = lastIdx(charArr, charArr[i], start, end);
	                
	                if (prevIdx == - 1) { // char has not repeated
	                    end++;
	                } else { // char has repeated
	                    ans = updatedAns(ans, start, end);
	                    // need to restart from the index next to the earlier occurance of the current char
	                    start = prevIdx + 1;
	                    end++;
	                }
	            }
	            return updatedAns(ans, start, end);
	        }
	        
	        private int lastIdx(char[] charArr, char c, int start, int end) {
	            for (int i = start; i <= end; i++) {
	                if (charArr[i] == c) {
	                    return i;
	                }
	            }
	            return -1;
	        }
	        
	        private int updatedAns(int ans, int start, int end) {
	            int currSubstringLength = end + 1 - start;
	            return currSubstringLength > ans ? currSubstringLength : ans;
	        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
