public class MinimumWindowSubsequence {

    public String minWindow(String str1, String str2) {

        if(str2.length()>str1.length()){
            return "";
        }

        int i=0;//i, j for 1st string and k for 2nd string
        int start=-1,end=-1;//for keeping track of start and end of substring;

        while(i<str1.length()){

           int j=i;
           int k=0;

            while(j < str1.length() && k < str2.length()){
                if(str1.charAt(j)==str2.charAt(k)){
                    k++;
                }

                j++;
            }

             if(k != str2.length()) break; // No window found, break

            
            int windowEnd=j;//current window's end

            //backtracking
            j=j-1;
            k=str2.length()-1;
            while(k!=-1){
                if(str1.charAt(j)==str2.charAt(k)){
                    k--;
                }
                j--;
            }
            int windowStart = j + 1;

            //updating start and end

            if(start == -1 || (windowEnd - windowStart) < (end - start)){
                start = windowStart;
                end = windowEnd;
            }

            i = windowStart + 1; // Move i past the current window's left edge

        }

        return (start == -1) ? "" : str1.substring(start, end);
      

        }

   
    public static void main(String[] args) {
        MinimumWindowSubsequence solution = new MinimumWindowSubsequence();
        String str1 = "abcdebdde";
        String str2 = "bde";
        System.out.println(solution.minWindow(str1, str2)); 
    }
}
