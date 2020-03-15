package myTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
//    String S = "ADOBECODEBANC", T = "ABC";
// "aaaaaaaaaaaabbbbbcdd"
//"abcdd"

	public static void main(String[] args) {
		String S = "abc",
        T = "bc";
		System.out.println(minWindow(S,T));
	}
	
    public String minWindow(String s, String t) {
    	
    	
		return t;

    }

	private static String forChars(char[] chars, String t, Integer start, String result, String s) {
        String tt = t;
        int a = 0;
        int length = chars.length;
        if(result != null){
            length = Math.min(result.length() + start,chars.length);
        }
        for (int i = start; i < length; i++) {
            char aChar = chars[i];
            if(tt.indexOf(aChar)==-1){
                continue;
            }
            a++;
            if(a==1){
                start1.put(0,i);
            }
            if(a == 2){
                start1.put(1,i);
            }
            if(t.indexOf(aChar)!=-1){
                t = t.substring(0, t.indexOf(aChar)) + t.substring(t.indexOf(aChar)+1);
            }
            if(t.isEmpty()) {
                String string = s.substring(start1.get(0), i + 1);
                if(result == null){
                    result = string;
                }
                return result.length() > string.length() ? string : result;
            }
        }
        return result;
	}


        public String minWindow1(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Dictionary which keeps a count of all the unique characters in t.
            Map<Character, Integer> dictT = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            // Number of unique characters in t, which need to be present in the desired window.
            int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            // formed is used to keep track of how many unique characters in t
            // are present in the current window in its desired frequency.
            // e.g. if t is "AABC" then the window must have two A's, one B and one C.
            // Thus formed would be = 3 when all these conditions are met.
            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            // ans list of the form (window length, left, right)
            int[] ans = {-1, 0, 0};

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and co***act the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done co***acting.
                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }


//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}