public class Pallindrome {
    public static boolean isPallindromeSimple(String word) {
        StringBuilder sb = new StringBuilder(word);
        if (sb.reverse().toString().equalsIgnoreCase(word)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPallindromeAdvanced(String word) {
        boolean isPallindrome = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.toLowerCase().charAt(i) != word.toLowerCase().charAt(word.length() - i - 1)) {
                isPallindrome = false;
                break;
            }
        }
        return isPallindrome;
    }
}
