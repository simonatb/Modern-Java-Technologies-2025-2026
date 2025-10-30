import java.util.Arrays;

public class UniqueSubstringFinder {
    public static String longestUniqueSubstring(String s) {
        int n  = s.length();
        if(n <= 1){
            return s;
        }

        int[] array = {1,0,0}; // length, first index, second index
                              // keep the first longest substring
        int[] letters = new int['z' - 'a' + 1];
        Arrays.fill(letters,-1);
        letters[s.charAt(0)-'a'] = 0;

        int begin = 0, currLength = 1;
        for(int end = 1; end < n; end++){
            char ch = s.charAt(end);

            if(letters[ch-'a'] >= begin){
                begin = letters[ch-'a'] + 1;
            }

            letters[ch-'a'] = end;
            currLength = end - begin + 1;

            if(currLength > array[0]){
                array[0] = currLength;
                array[1] = begin;
                array[2] = end;
            }
        }
        return s.substring(array[1],array[2] + 1);
    }
    public static void main(String[] args){
        System.out.println(longestUniqueSubstring("abba"));
    }
}
