import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] brackets = {540000, 1210000, 2420000, 4530000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        int[] quickDeduct = {0, 37800, 134600, 376600, 829600};
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            int tax = 0;
            for (int j = 0; j < brackets.length; j++) {
                if (income <= brackets[j]) {
                    tax = (int)(income * rates[j] - quickDeduct[j]);
                    break;
                }
            }
            if (income > brackets[brackets.length - 1]) {
                tax = (int)(income * rates[4] - quickDeduct[4]);
            }
            sum += tax;
            System.out.println("Tax: $" + tax);
        }
        System.out.println("Average: $" + (sum / n));
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每個收入依固定級距檢查稅率並計算，整體為 O(n)。
 */