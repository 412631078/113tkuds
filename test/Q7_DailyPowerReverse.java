import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] power = new int[7];
        for (int i = 0; i < 7; i++) {
            power[i] = sc.nextInt();
        }

        for (int i = 0; i < 7 / 2; i++) {
            int tmp = power[i];
            power[i] = power[6 - i];
            power[6 - i] = tmp;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(power[i] + " ");
        }
    }
}