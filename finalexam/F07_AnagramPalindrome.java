import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        int[] count = new int[26];
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                count[c - 'a']++;
            }
        }
        int odd = 0;
        for (int c : count) {
            if (c % 2 != 0) odd++;
        }
        System.out.println(odd <= 1 ? "Possible" : "Impossible");
    }
}