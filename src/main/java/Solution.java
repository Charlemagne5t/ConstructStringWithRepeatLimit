class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for(int i = 0 ; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int  i = 25;
        int j = find(24, count);
        while(n != 0) {
            int repeated = 0;
            while(count[i] != 0 && repeated != repeatLimit){
                sb.append((char)('a' + i));
                n--;
                repeated++;     
                count[i]--;   
            }
            if(repeated == repeatLimit && count[i] != 0 ) {
                if(j == -1){
                    break;
                }
                sb.append((char)('a' + j));
                n--;
                count[j]--;
                j =  find(i - 1, count);
            }else if(count[i] == 0){
                i--;
                if(j == i){
                    j = find(i - 1, count);
                }
            }
            
        }
        return sb.toString();
    }
    int find(int start, int[] count) {
        
        for(int i = start; i >=0; i--) {
            if(count[i] != 0) {
                return i;
            }
        }

        return -1;
    }
}