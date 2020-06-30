public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        /*System.out.println(lp.longestPalindrome("babad"));
        System.out.println(lp.longestPalindrome("cbbd"));
        System.out.println(lp.longestPalindrome("ab"));*/
        System.out.println(lp.longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        String longest = s.substring(0,1);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; ++i) {
            // 2 letter palindrom
            if (arr[i] == arr[i + 1]) {
                String palindrom = findPalindrom(s, i, i+1);
                if (palindrom.length() > longest.length())
                    longest = palindrom;
            }
            // 3 letter palindrom
            if (i + 2 < arr.length  && arr[i] == arr[i + 2]) {
                String palindrom = findPalindrom(s, i, i+2);
                if (palindrom.length() > longest.length())
                    longest = palindrom;
            }
        }
        return longest;
    }

    private String findPalindrom(String s, int left, int right) {

        while(left   >= 1 && right +1 < s.length() && s.charAt(left-1) == s.charAt(right+1)) {
            left--;
            right++;
        }
        return s.substring(left, right + 1);

    }
}
