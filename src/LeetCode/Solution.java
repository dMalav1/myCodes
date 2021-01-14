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
	        
	        class Solution {
	            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	                int[] newNums = new int[nums1.length + nums2.length];
	                
	                int i = 0;
	                int j = 0;
	                int k = 0;
	                
	                while(i < nums1.length && j < nums2.length)
	                    if(nums1[i] <= nums2[j]) 
	                        newNums[k++] = nums1[i++];
	                    else
	                        newNums[k++] = nums2[j++];
	                
	                while(i < nums1.length)
	                    newNums[k++] = nums1[i++];
	                
	                while(j < nums2.length)
	                    newNums[k++] = nums2[j++];
	                
	                if(newNums.length % 2 == 0 && newNums.length > 0)
	                    return (double)(newNums[(newNums.length - 1)/2] + newNums[(newNums.length - 1)/2 + 1])/2;
	                else
	                    return newNums[(newNums.length - 1)/2];
	            }
	        }

	        
	    
	            public String longestPalindrome(String e) {
	               int n=e.length();
	        		int dp[][]=new int[n+1][n+1];
	        		String res="";
	        		int resE=1,resL=1;//length and end index of palindrom
	        		if(n==0)return res;
	        		
	        		for(int i=0;i<=n;i++) dp[0][i]=dp[1][i]=1;
	        		
	        		for(int i=2;i<=n;i++) {
	        			for(int j=i;j<=n;j++) {
	        				if(e.charAt(j-1)==e.charAt(j-i) && dp[i-2][j-1]==1) { //first and last chars are same and remaining middle is also same 
	        					dp[i][j] = 1;
	        					resL = i;
	        					resE = j;
	        				}
	        				else dp[i][j]=0;
	        			}
	        		}
	                
	        		return e.substring(resE-resL,resE);

	            }
	            
	            
	            class Solution {
	                public String convert(String s, int numRows) {
	                    // obvious, if no of rows are 1 or string is empty return as it is
	                        if (numRows == 1 || s == null) {
	                            return s;
	                        }

	                        // to find out how many cols needed
	                        int col = 0;

	                        // to hold real pattern
	                        char[][] pattern = new char[numRows][1000];

	                        for (int row = 0, i =0; i < s.length() ; row++, i++) {
	                            // start filling the pattern array
	                            pattern[row][col] = s.charAt(i);

	                            // once you reached to the max numbers of rows ( -1 as array index starts with 0 ) 
	                            if ( row == numRows - 1) {
	                                while (row > 0 && ++i < s.length()) {
	                                    // start filling in reverse order, till you reach the top or length of string is exhausted
	                                    pattern[--row][++col] = s.charAt(i);
	                                }
	                            }
	                        }
	                    // done print it.
	                    return printString(pattern, s.length(), numRows, col+1);
	                }
	                
	                public String printString(char[][] pattern, int length, int numRows, int numCols) {
	                    StringBuilder result = new StringBuilder(numRows*numCols);
	                    for (int row =0; row < numRows ; row++) {
	                        for (int col =0 ; col < numCols; col++) {
	                            if (pattern[row][col] != '\u0000') {
	                               result.append(pattern[row][col]);
	                            }    
	                        }
	                    }
	                    return result.toString();
	                }
	                
	                
	                class Solution {
	                    public int myAtoi(String s) {
	                        s = s.trim()+" ";
	                        int i=0;
	                        String temp = "";
	                        if(s.charAt(0) =='+' || s.charAt(0) == '-'){
	                            temp = temp+s.charAt(0);i++;
	                        }
	                        while(s.charAt(i) != ' ' && s.charAt(i)>= '0' && s.charAt(i)<='9'){
	                            temp = temp + s.charAt(i);
	                            i++;
	                        }
	                        try{
	                            return (int)Double.parseDouble(temp);
	                        }
	                        catch(Exception e){
	                            return 0;
	                        }
	                    }
	                }
	                class Solution {
	                    
	                    // TC: O(n)
	                    // SC : O(n)
	                    public int minOperations(int[] nums, int x) {
	                        int totalSum = 0;
	                        for(int el: nums){
	                            totalSum += el;
	                        }
	                        int target = totalSum - x;
	                        
	                        Map<Integer, Integer> map = new HashMap<>();
	                        map.put(0, -1);
	                        int maxLenSubArray = -1;
	                        int prefixSum = 0;
	                        for(int i=0;i<nums.length;i++){
	                            prefixSum += nums[i];
	                            map.put(prefixSum, i);
	                            if(map.containsKey(prefixSum - target)){
	                                int currLenSubArray = i - map.get(prefixSum - target);
	                                maxLenSubArray = Math.max(maxLenSubArray, currLenSubArray);
	                            }
	                        }
	                        
	                        if(maxLenSubArray == -1){
	                            return maxLenSubArray;
	                        } else{
	                            return nums.length - maxLenSubArray;
	                        }
	                    }
	                }                                                                                                                 
	            }
	        
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
