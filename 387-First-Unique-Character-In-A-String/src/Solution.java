class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0 ; i < s.length() ; i ++){
            freq[s.charAt(i)-'a'] ++;//此处s.charAt(i)-'a' 为哈希函数
        }
        for (int i = 0 ; i < s.length() ; i ++){
            if (freq[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}